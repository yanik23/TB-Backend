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
import java.util.stream.Collectors;

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
    public Dish updateDish(Long id, Dish dish) {
        Dish updatedDish = getDishById(id);
        update(updatedDish,dish);
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
    public List<DishWithIngredientListDTO> getMinDish() {
        List<Dish> dishes = (List<Dish>) dishRepository.findAll();
        List<DishWithIngredientListDTO> minDishInfos = dishes.stream().map((elem) -> {
            DishWithIngredientListDTO minDishInfo = new DishWithIngredientListDTO();
            minDishInfo.setDishname(elem.getName());
            minDishInfo.setPrice(elem.getPrice());
            minDishInfo.setCalories(elem.getCalories());
            minDishInfo.setIngredients(elem.getDishIngredients().stream().map((elem1) -> {
                IngredientDTO ingredientDTO = new IngredientDTO();
                ingredientDTO.setIngredientName(elem1.getIngredient().getName());
                ingredientDTO.setWeight(elem1.getWeight());
                return ingredientDTO;
            }).collect(Collectors.toList()));
            return minDishInfo;
        }).toList();
        /*.forEachOrdered((minDishInfo) -> {
            minDishInfos.add(minDishInfo);
        });*/
        return minDishInfos;
    }

    private Dish update(Dish updatedDish, Dish dish) {
        updatedDish.setName(dish.getName());
        updatedDish.setDescription(dish.getDescription());
        updatedDish.setCurrentType(dish.getCurrentType());
        updatedDish.setCurrentSize(dish.getCurrentSize());
        updatedDish.setPrice(dish.getPrice());
        updatedDish.setAvailable(dish.isAvailable());
        updatedDish.setCalories(dish.getCalories());
        updatedDish.setFats(dish.getFats());
        updatedDish.setSaturatedFats(dish.getSaturatedFats());
        updatedDish.setSodium(dish.getSodium());
        updatedDish.setCarbohydrates(dish.getCarbohydrates());
        updatedDish.setFibers(dish.getFibers());
        updatedDish.setSugars(dish.getSugars());
        updatedDish.setProteins(dish.getProteins());
        updatedDish.setCalcium(dish.getCalcium());
        updatedDish.setIron(dish.getIron());
        updatedDish.setPotassium(dish.getPotassium());
        return updatedDish;
    }

}
