package com.bokafood.tbbackend.repository;


import com.bokafood.tbbackend.dto.statistics.QuantityDeliveredPerTypeDTO;
import com.bokafood.tbbackend.entity.DeliveryDish;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StatisticRepository extends CrudRepository<DeliveryDish, Long> {


    @Query("SELECT " +
            "   new com.bokafood.tbbackend.dto.statistics.QuantityDeliveredPerTypeDTO(d.currentType, SUM(dd.quantityDelivered)) " +
            "FROM DeliveryDish dd " +
            "JOIN Dish d ON dd.dish.id = d.id " +
            "JOIN Delivery del ON dd.delivery.id = del.id " +
            //"WHERE d.currentType = com.bokafood.tbbackend.entity.Dish$DishType.MEAT " +
            "WHERE d.currentType = 'VEGETARIAN' " +
            "GROUP BY d.currentType")
    List<QuantityDeliveredPerTypeDTO> getQuantityDeliveredPerTypes();
}
