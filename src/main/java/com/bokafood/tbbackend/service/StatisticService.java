package com.bokafood.tbbackend.service;


import com.bokafood.tbbackend.dto.statistics.QuantityDeliveredPerTypeDTO;

import java.util.List;

public interface StatisticService {

    List<QuantityDeliveredPerTypeDTO> getQuantityDeliveredPerTypes();

}
