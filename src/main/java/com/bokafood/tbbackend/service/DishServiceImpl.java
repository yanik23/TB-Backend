package com.bokafood.tbbackend.service;


import com.bokafood.tbbackend.dto.DishWithIngredientListDTO;
import com.bokafood.tbbackend.dto.DishWithIngredientsDTO;
import com.bokafood.tbbackend.dto.IngredientDTO;
import com.bokafood.tbbackend.entity.Dish;
import com.bokafood.tbbackend.exception.EntityNotFoundException;
import com.bokafood.tbbackend.repository.DishRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class DishServiceImpl implements DishService {

    @Autowired
    private DishRepository dishRepository;

    @Override
    public List<Dish> getDishes() {
        return (List<Dish>) dishRepository.findAll();
    }

    @Override
    public Dish getDishById(Long id) {
        Optional<Dish> dish = dishRepository.findById(id);
        if(dish.isPresent()) {
            return dish.get();
        } else {
            throw new EntityNotFoundException(id, Dish.class);
        }
    }

    @Override
    public Dish addDish(Dish dish) {
        return dishRepository.save(dish);
    }

    @Override
    public Dish updateDish(Long id, Dish updatedDish) {
        Dish dish = getDishById(id);
        dish.update(updatedDish);
        return dishRepository.save(dish);
    }

    @Override
    public void deleteDish(Long id) {
        dishRepository.deleteById(id);
    }


    /*@Override
    public List<DishWithIngredientsDTO> getDishByIdWithIngredients(Long id) {
        return dishRepository.findDishByIdWithIngredients(id);
    }*/

    @Override
    public List<DishWithIngredientsDTO> getMinDish() {
        /*List<DishWithIngredientsDTO> entites = dishRepository.findMin();
        List<IngredientDTO> ingredientDTOs = new ArrayList<>();

        for(DishWithIngredientsDTO entity: entites) {
            ingredientDTOs.add(new IngredientDTO(rawDishesAndIngredient.getName(), rawDishesAndIngredient.getWeight()));
        }

        DishWithIngredientListDTO dishWithIngredientListDTO = new DishWithIngredientListDTO();
        dishWithIngredientListDTO.setDishname(rawDishesAndIngredients.get(0).getName());
        dishWithIngredientListDTO.setPrice(rawDishesAndIngredients.get(0).getPrice());
        dishWithIngredientListDTO.setCalories(rawDishesAndIngredients.get(0).getCalories());
        dishWithIngredientListDTO.setIngredients(ingredientDTOs);*/

        return dishRepository.findMin();
    }


}
