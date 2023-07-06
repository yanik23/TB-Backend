package com.bokafood.tbbackend.service;


import com.bokafood.tbbackend.dto.dishes.DishDTO;
import com.bokafood.tbbackend.dto.dishes.DishLightDTO;
import com.bokafood.tbbackend.dto.dishes.DishWithIngredientListDTO;
import com.bokafood.tbbackend.entity.Dish;
import com.bokafood.tbbackend.exception.EntityNotFoundException;
import com.bokafood.tbbackend.repository.DishRepository;
import com.bokafood.tbbackend.utils.DishMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.*;

@Service
public class DishServiceImpl implements DishService {

    @Autowired
    private DishRepository dishRepository;

    @Override
    public List<DishLightDTO> getDishes() {
        List<Dish> dishes = (List<Dish>) dishRepository.findAll();
        return dishes.stream().map(DishMapper::toLightDTO).toList();
    }

    @Override
    public DishDTO getDishById(Long id) {
        Optional<Dish> dish = dishRepository.findById(id);
        if(dish.isPresent()) {
            return DishMapper.toDTO(dish.get());
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
        return DishMapper.toDTO(savedDish);
    }

    @Override
    public DishDTO updateDish(Long id, DishDTO updatedDishDTO) {
        Dish dish = DishMapper.toDish(getDishById(id));
        update(dish, updatedDishDTO);
        Dish savedDish = dishRepository.save(dish);
        return DishMapper.toDTO(savedDish);
    }

    @Override
    public void deleteDish(Long id) {
        dishRepository.deleteById(id);
    }


    @Override
    public List<DishWithIngredientListDTO> getDishesWithIngredients() {
        List<Dish> dishes = (List<Dish>) dishRepository.findAll();
        return dishes.stream().map(DishMapper::toDishWithIngredientListDTO).toList();
    }


    private void update(Dish dish, DishDTO updatedDishDTO) {
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
    }




}
