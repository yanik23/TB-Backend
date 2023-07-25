package com.bokafood.tbbackend.service;


import com.bokafood.tbbackend.dto.statisticsDTO.AvgDeliveredPerSizeDTO;
import com.bokafood.tbbackend.dto.statisticsDTO.AvgDeliveredPerTypeDTO;
import com.bokafood.tbbackend.dto.statisticsDTO.TotalDeliveredPerSizeDTO;
import com.bokafood.tbbackend.dto.statisticsDTO.TotalDeliveredPerTypeDTO;
import java.util.List;

public interface StatisticService {

    List<TotalDeliveredPerTypeDTO> getTotalDeliveredPerTypes();
    List<AvgDeliveredPerTypeDTO> getAvgDeliveredPerTypes();

    List<TotalDeliveredPerSizeDTO> getTotalDeliveredPerSizes();
    List<AvgDeliveredPerSizeDTO> getAvgDeliveredPerSizes();

}
