package com.bokafood.tbbackend.service;

import com.bokafood.tbbackend.entity.Ingredient;
import com.bokafood.tbbackend.exception.EntityNotFoundException;
import com.bokafood.tbbackend.repository.IngredientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class IngredientServiceImpl implements IngredientService {

    @Autowired
    private IngredientRepository ingredientRepository;

    @Override
    public List<Ingredient> getIngredients() {
        return (List<Ingredient>) ingredientRepository.findAll();
    }

    @Override
    public Ingredient getIngredientById(Long id) {
        Optional<Ingredient> ingredient = ingredientRepository.findById(id);
        if(ingredient.isPresent()) {
            return ingredient.get();
        } else {
            throw new EntityNotFoundException(id, Ingredient.class);
        }
    }

    @Override
    public Ingredient addIngredient(Ingredient ingredient) {
        return ingredientRepository.save(ingredient);
    }

    @Override
    public Ingredient updateIngredient(Long id, Ingredient updatedIngredient) {
        Ingredient ingredient = getIngredientById(id);
        ingredient.update(updatedIngredient);
        return ingredientRepository.save(ingredient);
    }

    @Override
    public void deleteIngredient(Long id) {
        ingredientRepository.deleteById(id);
    }
}
