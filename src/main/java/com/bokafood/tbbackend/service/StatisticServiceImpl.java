package com.bokafood.tbbackend.service;


import com.bokafood.tbbackend.dto.statistics.QuantityDeliveredPerTypeDTO;
import com.bokafood.tbbackend.repository.StatisticRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StatisticServiceImpl implements StatisticService {



    @Autowired
    private StatisticRepository statisticRepository;

    @Override
    public List<QuantityDeliveredPerTypeDTO> getQuantityDeliveredPerTypes() {
        return statisticRepository.getQuantityDeliveredPerTypes();
    }


}
