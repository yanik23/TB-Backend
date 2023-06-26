package com.bokafood.tbbackend.service;

import com.bokafood.tbbackend.entity.DishIngredient;
import com.bokafood.tbbackend.exception.EntityNotFoundException;
import com.bokafood.tbbackend.repository.DishIngredientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DishIngredientServiceImpl implements  DishIngredientService {

    @Autowired
    private DishIngredientRepository dishIngredientRepository;

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
    public DishIngredient addDishIngredient(DishIngredient dishIngredient) {
        return dishIngredientRepository.save(dishIngredient);
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
