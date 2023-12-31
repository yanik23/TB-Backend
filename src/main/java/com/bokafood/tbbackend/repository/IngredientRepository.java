package com.bokafood.tbbackend.repository;

import com.bokafood.tbbackend.entity.Ingredient;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IngredientRepository extends CrudRepository<Ingredient, Long> {

}
