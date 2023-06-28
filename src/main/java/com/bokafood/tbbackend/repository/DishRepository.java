package com.bokafood.tbbackend.repository;

import com.bokafood.tbbackend.entity.Dish;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

@Repository
public interface DishRepository extends CrudRepository<Dish, Long> {
    /*@Query("SELECT Dish.name, Dish.currentType, Dish.currentSize, Dish.price, Dish.calories, Ingredient.name, DishIngredient.weight " +
            "FROM Dish d" +
            "LEFT JOIN DishIngredient ON Dish.id = DishIngredient.dish.id " +
            "LEFT JOIN Ingredient ON DishIngredient.ingredient.id = Ingredient.id " +
            "WHERE Dish.id = :id"
    )*/
    @Query("SELECT d.name, d.currentType, d.currentSize, d.price, d.calories, i.name, di.weight " +
            "FROM Dish d " +
            "LEFT JOIN d.dishIngredients di " +
            "LEFT JOIN di.ingredient i " +
            "WHERE d.id = :id"
    )
    List<Collection> findDishByIdWithIngredients(@Param("id") Long id);
}
