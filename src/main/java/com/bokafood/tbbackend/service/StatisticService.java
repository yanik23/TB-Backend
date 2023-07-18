package com.bokafood.tbbackend.service;


import com.bokafood.tbbackend.dto.statistics.AvgDeliveredPerSizeDTO;
import com.bokafood.tbbackend.dto.statistics.AvgDeliveredPerTypeDTO;
import com.bokafood.tbbackend.dto.statistics.TotalDeliveredPerSizeDTO;
import com.bokafood.tbbackend.dto.statistics.TotalDeliveredPerTypeDTO;

import java.util.List;

public interface StatisticService {

    List<TotalDeliveredPerTypeDTO> getTotalDeliveredPerTypes();
    List<AvgDeliveredPerTypeDTO> getAvgDeliveredPerTypes();

    List<TotalDeliveredPerSizeDTO> getTotalDeliveredPerSizes();
    List<AvgDeliveredPerSizeDTO> getAvgDeliveredPerSizes();

}
