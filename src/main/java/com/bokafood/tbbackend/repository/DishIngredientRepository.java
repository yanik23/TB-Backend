package com.bokafood.tbbackend.repository;

import com.bokafood.tbbackend.entity.DishIngredient;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DishIngredientRepository extends CrudRepository<DishIngredient, Long> {
}
