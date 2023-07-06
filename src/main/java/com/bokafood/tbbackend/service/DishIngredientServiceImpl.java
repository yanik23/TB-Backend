package com.bokafood.tbbackend.service;

import com.bokafood.tbbackend.dto.dishes.DishDTO;
import com.bokafood.tbbackend.dto.dishesIngredientsDTO.DishIngredientDTO;
import com.bokafood.tbbackend.dto.dishesIngredientsDTO.DishIngredientObjectDTO;
import com.bokafood.tbbackend.dto.ingredients.IngredientDTO;
import com.bokafood.tbbackend.entity.Dish;
import com.bokafood.tbbackend.entity.DishIngredient;
import com.bokafood.tbbackend.entity.Ingredient;
import com.bokafood.tbbackend.exception.EntityNotFoundException;
import com.bokafood.tbbackend.repository.DishIngredientRepository;
import com.bokafood.tbbackend.utils.DishIngredientMapper;
import com.bokafood.tbbackend.utils.DishMapper;
import com.bokafood.tbbackend.utils.IngredientMapper;
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
    public DishIngredient getDishIngredientById(Long id) {
        Optional<DishIngredient> dishIngredient = dishIngredientRepository.findById(id);
        if(dishIngredient.isPresent()) {
            return dishIngredient.get();
        } else {
            throw new EntityNotFoundException(id, DishIngredient.class);
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
    public DishIngredient updateDishIngredient(Long id, DishIngredient updatedDishIngredient) {
        DishIngredient dishIngredient = getDishIngredientById(id);
        dishIngredient.update(updatedDishIngredient);
        return dishIngredientRepository.save(dishIngredient);
    }

    @Override
    public void deleteDishIngredient(Long id) {
        dishIngredientRepository.deleteById(id);
    }
}
