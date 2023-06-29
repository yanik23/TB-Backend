package com.bokafood.tbbackend.repository;

import com.bokafood.tbbackend.dto.DishWithIngredientsDTO;
import com.bokafood.tbbackend.entity.Dish;
import jakarta.persistence.*;
import org.hibernate.engine.spi.SessionLazyDelegator;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
//import org.springframework.stereotype.Repository;
import com.bokafood.tbbackend.dto.DishWithIngredientsDTO;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Optional;


/*@SqlResultSetMapping(
        name = "DishDetailsMapping",
        classes = @ConstructorResult(
                targetClass = DishWithIngredientsDTO.class,
                columns = {
                        @ColumnResult(name = "dishname"),
                        @ColumnResult(name = "price")
                }
        )
)
@NamedNativeQuery(name = "Dish.findMin", query = "SELECT d.name AS dishname, d.price AS price FROM Dish d", resultSetMapping = "DishDetailsMapping")*/
public interface DishRepository extends CrudRepository<Dish, Long> {

    /*@Query("SELECT new com.bokafood.tbbackend.dto.DishWithIngredientsDTO(d.name, d.price, d.calories, i.name, di.weight) " +
            "FROM Dish d " +
            "LEFT JOIN d.dishIngredients di " +
            "LEFT JOIN di.ingredient i ")
    List<DishWithIngredientsDTO> findMin();*/




    /*@Query("SELECT new com.bokafood.tbbackend.dto.DishWithIngredientListDTO(d.name, d.price, d.calories, " +
            " new com.bokaFood.tbbackend.dto.IngredientDTO(i.name, di.weight)) " +
            "FROM Dish d " +
            "LEFT JOIN d.dishIngredients di " +
            "LEFT JOIN di.ingredient i ")*/

    /*@Query("SELECT new com.bokafood.tbbackend.dto.DishWithIngredientsDTO(d.name, d.price, d.calories, i.name, di.weight) " +
            "FROM Dish d " +
            "LEFT JOIN d.dishIngredients di " +
            "LEFT JOIN di.ingredient i ")
    List<Dish> findMin();*/


}

    /*@NamedNativeQuery(name = "test", query = "SELECT d.name, d.price FROM Dish d")
    List<DishWithIngredientsDTO> getMinDish();*/

    //List<DishWithIngredientsDTO> findDishByIdWithIngredients(Long dishId);

    /*@Query(nativeQuery = true,
            value = "SELECT d.name, d.price, d.calories, i.name, di.weight " +
            "FROM Dish d " +
            "LEFT JOIN d.dishIngredients di ON d.id = di.dishId " +
            "LEFT JOIN di.ingredient i ON di.idIngredient = i.id" +
            "WHERE Dish.id = 1")*/

