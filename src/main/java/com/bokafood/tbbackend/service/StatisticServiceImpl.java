package com.bokafood.tbbackend.service;


import com.bokafood.tbbackend.dto.statistics.AvgDeliveredPerSizeDTO;
import com.bokafood.tbbackend.dto.statistics.AvgDeliveredPerTypeDTO;
import com.bokafood.tbbackend.dto.statistics.TotalDeliveredPerSizeDTO;
import com.bokafood.tbbackend.dto.statistics.TotalDeliveredPerTypeDTO;
import com.bokafood.tbbackend.repository.StatisticRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StatisticServiceImpl implements StatisticService {



    @Autowired
    private StatisticRepository statisticRepository;

    @Override
    public List<TotalDeliveredPerTypeDTO> getTotalDeliveredPerTypes() {
        return statisticRepository.getTotalDeliveredPerTypes();
    }

    @Override
    public List<AvgDeliveredPerTypeDTO> getAvgDeliveredPerTypes() {
        return statisticRepository.getAvgDeliveredPerTypes();
    }

    @Override
    public List<TotalDeliveredPerSizeDTO> getTotalDeliveredPerSizes() {
        return statisticRepository.getTotalDeliveredPerSizes();
    }

    @Override
    public List<AvgDeliveredPerSizeDTO> getAvgDeliveredPerSizes() {
        return statisticRepository.getAvgDeliveredPerSizes();
    }


}
