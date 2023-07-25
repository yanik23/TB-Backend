package com.bokafood.tbbackend.repository;

import com.bokafood.tbbackend.entity.DishIngredient;
import com.bokafood.tbbackend.entity.DishIngredientId;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import java.util.List;


/**
 * DishIngredient repository class used for CRUD operations on the DishIngredient entity.
 * Uses hibernate to access the database.
 *
 * @author Yanik Lange
 * @date 25.07.2023
 * @version 1.0
 */
@Repository
public interface DishIngredientRepository extends CrudRepository<DishIngredient, DishIngredientId> {


    List<DishIngredient> findAllByDishId(Long id);

    @Query("DELETE FROM DishIngredient di WHERE di.dish.id = ?1")
    @Modifying
    @Transactional
    void deleteAllDishIngredientsByDishIdQuery(Long id);
}
