package com.bokafood.tbbackend.repository;

import com.bokafood.tbbackend.entity.DishIngredient;
import com.bokafood.tbbackend.entity.DishIngredientId;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DishIngredientRepository extends CrudRepository<DishIngredient, DishIngredientId> {


    List<DishIngredient> findAllByDishId(Long id);

    @Query("DELETE FROM DishIngredient di WHERE di.dish.id = ?1")
    @Modifying
    @Transactional
    void deleteAllDishIngredientsByDishIdQuery(Long id);
}
