package com.bokafood.tbbackend.service;


import com.bokafood.tbbackend.dto.statisticsDTO.AvgDeliveredPerSizeDTO;
import com.bokafood.tbbackend.dto.statisticsDTO.AvgDeliveredPerTypeDTO;
import com.bokafood.tbbackend.dto.statisticsDTO.TotalDeliveredPerSizeDTO;
import com.bokafood.tbbackend.dto.statisticsDTO.TotalDeliveredPerTypeDTO;
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
