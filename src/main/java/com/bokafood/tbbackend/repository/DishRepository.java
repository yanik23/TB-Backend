package com.bokafood.tbbackend.repository;

import com.bokafood.tbbackend.entity.Dish;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


/**
 * Dish repository class used for CRUD operations on the Dish entity.
 * Uses hibernate to access the database.
 *
 * @author Yanik Lange
 * @date 25.07.2023
 * @version 1.0
 */
@Repository
public interface DishRepository extends CrudRepository<Dish, Long> {

}


