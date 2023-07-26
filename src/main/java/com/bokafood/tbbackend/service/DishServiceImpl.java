package com.bokafood.tbbackend.service;


import com.bokafood.tbbackend.dto.dishesDTO.DishDTO;
import com.bokafood.tbbackend.dto.dishesDTO.DishLightDTO;
import com.bokafood.tbbackend.dto.dishesDTO.DishWithIngredientListDTO;
import com.bokafood.tbbackend.dto.dishesIngredientsDTO.DishIngredientDTO;
import com.bokafood.tbbackend.dto.dishesIngredientsDTO.DishIngredientObjectDTO;
import com.bokafood.tbbackend.dto.ingredientsDTO.IngredientDTO;
import com.bokafood.tbbackend.dto.ingredientsDTO.IngredientLessDTO;
import com.bokafood.tbbackend.entity.Dish;
import com.bokafood.tbbackend.entity.DishIngredient;
import com.bokafood.tbbackend.entity.DishIngredientId;
import com.bokafood.tbbackend.entity.Ingredient;
import com.bokafood.tbbackend.exception.EntityNotFoundException;
import com.bokafood.tbbackend.repository.DishRepository;
import com.bokafood.tbbackend.utils.DishMapper;
import com.bokafood.tbbackend.utils.IngredientMapper;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.*;

@Service
public class DishServiceImpl implements DishService {

    @Autowired
    private DishRepository dishRepository;

    @Autowired
    private DishIngredientService dishIngredientService;

    @Autowired
    private IngredientService ingredientService;

    @Override
    public List<DishLightDTO> getDishes() {
        List<Dish> dishes = (List<Dish>) dishRepository.findAll();
        return dishes.stream().map(DishMapper::toLightDTO).toList();
    }

    @Override
    public DishWithIngredientListDTO getDishById(Long id) {
        Optional<Dish> dish = dishRepository.findById(id);
        if(dish.isPresent()) {
            return DishMapper.toDishWithIngredientListDTO(dish.get());
        } else {
            throw new EntityNotFoundException(id, Dish.class);
        }
    }


    @Override
    public DishDTO addDish(DishWithIngredientListDTO dishDTO) {
        Dish dish = DishMapper.toDish(dishDTO);
        Dish savedDish = dishRepository.save(dish);

        List<IngredientLessDTO> ingredients = dishDTO.getIngredients();

        if(ingredients != null) {
            for (IngredientLessDTO ingredient : ingredients) {
                IngredientDTO ingredientDTO = ingredientService.getIngredientById(ingredient.getId());
                Ingredient ingredientEntity = IngredientMapper.toEntity(ingredientDTO);

                DishIngredientId dishIngredientId = new DishIngredientId(savedDish.getId(), ingredient.getId());
                DishIngredientObjectDTO dishIngredientObjectDTO = new DishIngredientObjectDTO(dishIngredientId, savedDish, ingredientEntity, ingredient.getWeight());
                DishIngredientDTO savedDishIngredientDTO = dishIngredientService.addDishIngredient(dishIngredientObjectDTO);
            }
        }
        return DishMapper.toDTO(savedDish);
    }

    @Transactional
    @Override
    public DishDTO updateDish(Long id, DishWithIngredientListDTO updatedDishDTO) {
        Dish dish = DishMapper.toDishWithId(getDishById(id));
        update(dish, updatedDishDTO);
        Dish savedDish = dishRepository.save(dish);
        return DishMapper.toDTO(savedDish);
    }

    @Transactional
    @Override
    public void deleteDish(Long id) {
        dishRepository.deleteById(id);
    }


    @Override
    public List<DishWithIngredientListDTO> getDishesWithIngredients() {
        List<Dish> dishes = (List<Dish>) dishRepository.findAll();
        return dishes.stream().map(DishMapper::toDishWithIngredientListDTO).toList();
    }


    /**
     * Method to update a dish.
     * @param dish The dish to be updated.
     * @param updatedDishDTO The DishDTO object with the updated dish.
     */
    private void update(Dish dish, DishWithIngredientListDTO updatedDishDTO) {

        // set the new values
        dish.setName(updatedDishDTO.getName());
        dish.setDescription(updatedDishDTO.getDescription());
        dish.setCurrentType(updatedDishDTO.getCurrentType());
        dish.setCurrentSize(updatedDishDTO.getCurrentSize());
        dish.setPrice(updatedDishDTO.getPrice());
        dish.setAvailable(updatedDishDTO.isAvailable());
        dish.setCalories(updatedDishDTO.getCalories());
        dish.setFats(updatedDishDTO.getFats());
        dish.setSaturatedFats(updatedDishDTO.getSaturatedFats());
        dish.setSodium(updatedDishDTO.getSodium());
        dish.setCarbohydrates(updatedDishDTO.getCarbohydrates());
        dish.setFibers(updatedDishDTO.getFibers());
        dish.setSugars(updatedDishDTO.getSugars());
        dish.setProteins(updatedDishDTO.getProteins());
        dish.setCalcium(updatedDishDTO.getCalcium());
        dish.setIron(updatedDishDTO.getIron());
        dish.setPotassium(updatedDishDTO.getPotassium());

        // set the new list of ingredients
        List<IngredientLessDTO> updatedIngredients = updatedDishDTO.getIngredients();
        // the new list of dish ingredients that will be set to the dish
        List<DishIngredient> dishIngredients = new ArrayList<>();

        // If the updated list of ingredients is not null, check if the ingredients already exist
        if (updatedIngredients != null) {


            List<DishIngredient> existingIngredients = dishIngredientService.findAllByDishId(dish.getId());

            // update the existing ingredients in the database by deleting the ones that are not in the updatedIngredient list
            for (DishIngredient existingIngredient : existingIngredients) {
                DishIngredientId existingIngredientId = existingIngredient.getId();
                boolean ingredientExists = updatedIngredients.stream()
                        .anyMatch(ingredient -> ingredient.getId().equals(existingIngredientId.getIdIngredient()));

                if (!ingredientExists) {
                    dishIngredientService.deleteDishIngredient(existingIngredientId);
                }
            }

            // update the existing ingredients in the database by updating the ones that are in the updatedIngredient list
            // by creating a new DishIngredient entity if the ingredient is new or updating the existing one.
            for (IngredientLessDTO ingredient : updatedIngredients) {
                IngredientDTO ingredientDTO = ingredientService.getIngredientById(ingredient.getId());
                Ingredient ingredientEntity = IngredientMapper.toEntity(ingredientDTO);
                DishIngredientId dishIngredientId = new DishIngredientId(dish.getId(), ingredient.getId());
                // Check if the ingredient already exists
                DishIngredient existingIngredient = findExistingIngredient(existingIngredients, dishIngredientId);
                if (existingIngredient != null) {
                    // If the ingredient exists, add it to the new dishIngredients list
                    dishIngredients.add(existingIngredient);
                } else {
                    // If the ingredient is new, create a new DishIngredient entity
                    DishIngredient dishIngredient = new DishIngredient(dishIngredientId, dish, ingredientEntity, ingredient.getWeight());
                    dishIngredients.add(dishIngredient);
                }
            }
        }

        // Set the new list of dish ingredients
        dish.setDishIngredients(dishIngredients);
    }

    /**
     * Method to find an existing ingredient in a list of ingredients.
     * @param existingIngredients The list of existing ingredients.
     * @param dishIngredientId The id of the dishIngredient to be found.
     * @return The DishIngredient if found, null otherwise.
     */
    private DishIngredient findExistingIngredient(List<DishIngredient> existingIngredients, DishIngredientId dishIngredientId) {
        for (DishIngredient existingIngredient : existingIngredients) {
            if (existingIngredient.getId().equals(dishIngredientId)) {
                return existingIngredient;
            }
        }
        return null;
    }
}
