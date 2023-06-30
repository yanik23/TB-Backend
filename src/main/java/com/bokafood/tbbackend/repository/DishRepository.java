package com.bokafood.tbbackend.repository;

import com.bokafood.tbbackend.entity.Dish;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DishRepository extends CrudRepository<Dish, Long> {



}


