package com.bokafood.tbbackend.service;


import com.bokafood.tbbackend.dto.statisticsDTO.AvgDeliveredPerSizeDTO;
import com.bokafood.tbbackend.dto.statisticsDTO.AvgDeliveredPerTypeDTO;
import com.bokafood.tbbackend.dto.statisticsDTO.TotalDeliveredPerSizeDTO;
import com.bokafood.tbbackend.dto.statisticsDTO.TotalDeliveredPerTypeDTO;
import java.util.List;

/**
 * StatisticService is an interface that provides methods to manage statistics.
 * Implementation of this interface is in StatisticServiceImpl class.
 *
 * @author Yanik Lange
 * @date 25.07.2023
 * @version 1.0
 */
public interface StatisticService {

    /**
     * Method to get the total and average delivered dishes per type.
     * @return List<TotalDeliveredPerTypeDTO> of all dishes per type.
     */
    List<TotalDeliveredPerTypeDTO> getTotalDeliveredPerTypes();

    /**
     * Method to get the total and average delivered dishes per type.
     * @return List<AvgDeliveredPerTypeDTO> of all dishes per type.
     */
    List<AvgDeliveredPerTypeDTO> getAvgDeliveredPerTypes();

    /**
     * Method to get the total and average delivered dishes per size.
     * @return List<TotalDeliveredPerSizeDTO> of all dishes per size.
     */
    List<TotalDeliveredPerSizeDTO> getTotalDeliveredPerSizes();

    /**
     * Method to get the total and average delivered dishes per size.
     * @return List<AvgDeliveredPerSizeDTO> of all dishes per size.
     */
    List<AvgDeliveredPerSizeDTO> getAvgDeliveredPerSizes();

}
