package com.bokafood.tbbackend.repository;


import com.bokafood.tbbackend.dto.statisticsDTO.AvgDeliveredPerSizeDTO;
import com.bokafood.tbbackend.dto.statisticsDTO.AvgDeliveredPerTypeDTO;
import com.bokafood.tbbackend.dto.statisticsDTO.TotalDeliveredPerSizeDTO;
import com.bokafood.tbbackend.dto.statisticsDTO.TotalDeliveredPerTypeDTO;
import com.bokafood.tbbackend.entity.DeliveryDish;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface StatisticRepository extends CrudRepository<DeliveryDish, Long> {


    @Query("SELECT " +
            "new com.bokafood.tbbackend.dto.statisticsDTO.TotalDeliveredPerTypeDTO(d.currentType, SUM(dd.quantityDelivered)) " +
            "FROM DeliveryDish dd " +
            "JOIN Dish d ON dd.dish.id = d.id " +
            "GROUP BY d.currentType")
    List<TotalDeliveredPerTypeDTO> getTotalDeliveredPerTypes();

    @Query("SELECT " +
            "new com.bokafood.tbbackend.dto.statisticsDTO.AvgDeliveredPerTypeDTO(d.currentType, AVG(dd.quantityDelivered)) " +
            "FROM DeliveryDish dd " +
            "JOIN Dish d ON dd.dish.id = d.id " +
            "GROUP BY d.currentType")
    List<AvgDeliveredPerTypeDTO> getAvgDeliveredPerTypes();

    @Query("SELECT " +
            "new com.bokafood.tbbackend.dto.statisticsDTO.TotalDeliveredPerSizeDTO(d.currentSize, SUM(dd.quantityDelivered)) " +
            "FROM DeliveryDish dd " +
            "JOIN Dish d ON dd.dish.id = d.id " +
            "GROUP BY d.currentSize")
    List<TotalDeliveredPerSizeDTO> getTotalDeliveredPerSizes();

    @Query("SELECT " +
            "new com.bokafood.tbbackend.dto.statisticsDTO.AvgDeliveredPerSizeDTO(d.currentSize, AVG(dd.quantityDelivered)) " +
            "FROM DeliveryDish dd " +
            "JOIN Dish d ON dd.dish.id = d.id " +
            "GROUP BY d.currentSize")
    List<AvgDeliveredPerSizeDTO> getAvgDeliveredPerSizes();

}
