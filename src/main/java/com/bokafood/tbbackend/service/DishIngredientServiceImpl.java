package com.bokafood.tbbackend.service;

import com.bokafood.tbbackend.dto.dishesIngredientsDTO.DishIngredientDTO;
import com.bokafood.tbbackend.dto.dishesIngredientsDTO.DishIngredientObjectDTO;
import com.bokafood.tbbackend.entity.DishIngredient;
import com.bokafood.tbbackend.entity.DishIngredientId;
import com.bokafood.tbbackend.repository.DishIngredientRepository;
import com.bokafood.tbbackend.utils.DishIngredientMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class DishIngredientServiceImpl implements  DishIngredientService {

    @Autowired
    private DishIngredientRepository dishIngredientRepository;

   /* @Autowired
    private DishService dishService;*/

    @Autowired
    private IngredientService ingredientService;

    @Override
    public List<DishIngredient> getDishIngredients() {
        return (List<DishIngredient>) dishIngredientRepository.findAll();
    }

    @Override
    public DishIngredient getDishIngredientById(DishIngredientId id) {
        Optional<DishIngredient> dishIngredient = dishIngredientRepository.findById(id);
        if(dishIngredient.isPresent()) {
            return dishIngredient.get();
        } else {
            return null;
            //throw new EntityNotFoundException(id.getIdDish(), id.getIdIngredient(), DishIngredient.class);
        }
    }

    @Override
    public DishIngredientDTO addDishIngredient(DishIngredientObjectDTO dishIngredientObjectDTO) {
        DishIngredient dishIngredient = DishIngredientMapper.toEntity(dishIngredientObjectDTO);
        DishIngredient savedDishIngredient = dishIngredientRepository.save(dishIngredient);
        return DishIngredientMapper.toDTO(savedDishIngredient);


        /*DishDTO dishDTO = dishService.getDishById(dishIngredientDTO.getIdDish());
        IngredientDTO ingredientDTO = ingredientService.getIngredientById(dishIngredientDTO.getIdIngredient());

        Dish dish = DishMapper.toDish(dishDTO);
        Ingredient ingredient = IngredientMapper.toIngredient(ingredientDTO);

        DishIngredientObjectDTO dishIngredientObjectDTO = DishIngredientObjectDTO.builder()
                .id(dishIngredientDTO.getId())
                .dish(dish)
                .ingredient(ingredient)
                .weight(dishIngredientDTO.getWeight())
                .build();

        DishIngredient savedDishIngredient = dishIngredientRepository.save(DishIngredientMapper.toEntity(dishIngredientObjectDTO));*/


    }

    @Override
    public DishIngredientDTO updateDishIngredient(DishIngredientId id, DishIngredientObjectDTO updatedDishIngredient) {
        DishIngredient dishIngredient = getDishIngredientById(id);
        update(dishIngredient, updatedDishIngredient);
        DishIngredient savedDishIngredient = dishIngredientRepository.save(dishIngredient);
        return DishIngredientMapper.toDTO(savedDishIngredient);
    }

    @Override
    public void deleteDishIngredient(DishIngredientId id) {
        dishIngredientRepository.deleteById(id);
    }



    @Override
    public void deleteAllByDishId(Long id) {
        /*List<DishIngredient> dishIngredients = dishIngredientRepository.findAllByDishId(id);
        for (DishIngredient dishIngredient : dishIngredients) {
            dishIngredient.setDish(null); // Remove the association with the parent entity
        }
        dishIngredientRepository.deleteAll(dishIngredients);*/
        dishIngredientRepository.deleteAllDishIngredientsByDishIdQuery(id);
        //dishIngredientRepository.deleteAllDishIngredientsByDishId(id);
    }

    @Override
    public List<DishIngredient> findAllByDishId(Long id) {
        return dishIngredientRepository.findAllByDishId(id);
    }

    private void update(DishIngredient dishIngredient, DishIngredientObjectDTO dishIngredientObjectDTO) {
        dishIngredient.setDish(dishIngredientObjectDTO.getDish());
        dishIngredient.setIngredient(dishIngredientObjectDTO.getIngredient());
        dishIngredient.setWeight(dishIngredientObjectDTO.getWeight());
    }
}
