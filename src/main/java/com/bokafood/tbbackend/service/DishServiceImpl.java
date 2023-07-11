package com.bokafood.tbbackend.service;


import com.bokafood.tbbackend.dto.dishes.DishDTO;
import com.bokafood.tbbackend.dto.dishes.DishLightDTO;
import com.bokafood.tbbackend.dto.dishes.DishWithIngredientListDTO;
import com.bokafood.tbbackend.dto.dishesIngredientsDTO.DishIngredientDTO;
import com.bokafood.tbbackend.dto.dishesIngredientsDTO.DishIngredientObjectDTO;
import com.bokafood.tbbackend.dto.ingredients.IngredientDTO;
import com.bokafood.tbbackend.dto.ingredients.IngredientLessDTO;
import com.bokafood.tbbackend.entity.Dish;
import com.bokafood.tbbackend.entity.DishIngredient;
import com.bokafood.tbbackend.entity.DishIngredientId;
import com.bokafood.tbbackend.entity.Ingredient;
import com.bokafood.tbbackend.exception.EntityNotFoundException;
import com.bokafood.tbbackend.repository.DishRepository;
import com.bokafood.tbbackend.utils.DishIngredientMapper;
import com.bokafood.tbbackend.utils.DishMapper;
import com.bokafood.tbbackend.utils.IngredientMapper;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
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
            DishWithIngredientListDTO dishWithIngredientListDTO = DishMapper.toDishWithIngredientListDTO(dish.get());
            return dishWithIngredientListDTO;
        } else {
            throw new EntityNotFoundException(id, Dish.class);
        }
    }

    /*@Override
    public DishDTO addDish(DishDTO dishDTO) {
        Dish dish = DishMapper.toDish(dishDTO);
        Dish savedDish = dishRepository.save(dish);
        return DishMapper.toDTO(savedDish);
    }*/

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
        System.out.println("=================Deleting dish with id: " + id);
        dishRepository.deleteById(id);
    }


    @Override
    public List<DishWithIngredientListDTO> getDishesWithIngredients() {
        List<Dish> dishes = (List<Dish>) dishRepository.findAll();
        return dishes.stream().map(DishMapper::toDishWithIngredientListDTO).toList();
    }


    /*private void update(Dish dish, DishWithIngredientListDTO updatedDishDTO) {

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

        List<IngredientLessDTO> ingredients = updatedDishDTO.getIngredients();

        dishIngredientService.deleteAllByDishId(dish.getId()); //empty the list of ingredients before adding the new ones.

        List<DishIngredient> dishIngredients = new ArrayList<>();

        if(ingredients != null) {
            for (IngredientLessDTO ingredient : ingredients) {
                IngredientDTO ingredientDTO = ingredientService.getIngredientById(ingredient.getId());
                Ingredient ingredientEntity = IngredientMapper.toEntity(ingredientDTO);

                DishIngredientId dishIngredientId = new DishIngredientId(dish.getId(), ingredient.getId());

                DishIngredient dishIngredient = new DishIngredient(dishIngredientId, dish, ingredientEntity, ingredient.getWeight());
                dishIngredients.add(dishIngredient);
                //DishIngredientObjectDTO dishIngredientObjectDTO = new DishIngredientObjectDTO(dishIngredientId, dish, ingredientEntity, ingredient.getWeight());

                //check if dishIngredient exists, it it does, update it, if not, create it
                /*if(dishIngredientService.getDishIngredientById(dishIngredientId) == null) {
                    DishIngredientDTO savedDishIngredientDTO = dishIngredientService.addDishIngredient(dishIngredientObjectDTO);
                } else {
                    DishIngredientDTO savedDishIngredientDTO = dishIngredientService.updateDishIngredient(dishIngredientId, dishIngredientObjectDTO);
                }*/

                //DishIngredientDTO savedDishIngredientDTO = dishIngredientService.updateDishIngredient(dishIngredientId, dishIngredientObjectDTO);
           /* }
            dish.setDishIngredients(dishIngredients);
        }

        //List<DishIngredient> = dishIngredientService.getDishIngredientsByDishId(dish.getId());
    }*/

    /*private void update(Dish dish, DishWithIngredientListDTO updatedDishDTO) {
        // Update the dish properties
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

        List<IngredientLessDTO> updatedIngredients = updatedDishDTO.getIngredients();
        List<DishIngredient> dishIngredients = new ArrayList<>();

        if (updatedIngredients != null) {
            // Retrieve the existing ingredients associated with the dish
            List<DishIngredient> existingIngredients = dishIngredientService.findAllByDishId(dish.getId());//dish.getDishIngredients();

            // Iterate through the updated ingredients
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

    private DishIngredient findExistingIngredient(List<DishIngredient> existingIngredients, DishIngredientId dishIngredientId) {
        for (DishIngredient existingIngredient : existingIngredients) {
            if (existingIngredient.getId().equals(dishIngredientId)) {
                return existingIngredient;
            }
        }
        return null;
    }*/

    private void update(Dish dish, DishWithIngredientListDTO updatedDishDTO) {
        // Update the dish properties
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

        List<IngredientLessDTO> updatedIngredients = updatedDishDTO.getIngredients();
        List<DishIngredient> dishIngredients = new ArrayList<>();

        if (updatedIngredients != null) {
            // Retrieve the existing ingredients associated with the dish
            List<DishIngredient> existingIngredients = dishIngredientService.findAllByDishId(dish.getId()); //dish.getDishIngredients();

            // Iterate through the existing ingredients and delete those not present in the updated list
            for (DishIngredient existingIngredient : existingIngredients) {
                DishIngredientId existingIngredientId = existingIngredient.getId();

                boolean ingredientExists = updatedIngredients.stream()
                        .anyMatch(ingredient -> ingredient.getId().equals(existingIngredientId.getIdIngredient()));

                if (!ingredientExists) {
                    dishIngredientService.deleteDishIngredient(existingIngredientId);
                }
            }

            // Iterate through the updated ingredients
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

    private DishIngredient findExistingIngredient(List<DishIngredient> existingIngredients, DishIngredientId dishIngredientId) {
        for (DishIngredient existingIngredient : existingIngredients) {
            if (existingIngredient.getId().equals(dishIngredientId)) {
                return existingIngredient;
            }
        }
        return null;
    }
}
