package com.bokafood.tbbackend.service;

import com.bokafood.tbbackend.dto.ingredients.IngredientDTO;
import com.bokafood.tbbackend.entity.Client;
import com.bokafood.tbbackend.entity.Ingredient;
import com.bokafood.tbbackend.exception.EntityNotFoundException;
import com.bokafood.tbbackend.repository.IngredientRepository;
import com.bokafood.tbbackend.utils.ClientMapper;
import com.bokafood.tbbackend.utils.IngredientMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class IngredientServiceImpl implements IngredientService {

    @Autowired
    private IngredientRepository ingredientRepository;

    @Override
    public List<IngredientDTO> getIngredients() {
        List<Ingredient> ingredients = (List<Ingredient>) ingredientRepository.findAll();
        return ingredients.stream().map(IngredientMapper::toDTO).toList();
    }

    @Override
    public IngredientDTO getIngredientById(Long id) {
        Optional<Ingredient> ingredient = ingredientRepository.findById(id);
        if(ingredient.isPresent()) {
            return IngredientMapper.toDTO(ingredient.get());
        } else {
            throw new EntityNotFoundException(id, Ingredient.class);
        }
    }

    @Override
    public IngredientDTO addIngredient(IngredientDTO ingredientDTO) {
        Ingredient ingredient = IngredientMapper.toIngredient(ingredientDTO);
        Ingredient savedIngredient = ingredientRepository.save(ingredient);
        return IngredientMapper.toDTO(savedIngredient);
    }


    @Override
    public IngredientDTO updateIngredient(Long id, IngredientDTO updatedIngredientDTO) {
        Ingredient ingredient = IngredientMapper.toIngredient(getIngredientById(id));
        update(ingredient, updatedIngredientDTO);
        Ingredient savedIngredient =  ingredientRepository.save(ingredient);
        return IngredientMapper.toDTO(savedIngredient);
    }

    @Override
    public void deleteIngredient(Long id) {
        ingredientRepository.deleteById(id);
    }

    private void update(Ingredient updatedIngredient, IngredientDTO ingredientDTO) {
        updatedIngredient.setName(ingredientDTO.getName());
        updatedIngredient.setCurrentType(ingredientDTO.getCurrentType());
        updatedIngredient.setDescription(ingredientDTO.getDescription());
        updatedIngredient.setSupplier(ingredientDTO.getSupplier());
    }
}
