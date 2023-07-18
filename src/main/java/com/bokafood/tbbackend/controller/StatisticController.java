package com.bokafood.tbbackend.controller;


import com.bokafood.tbbackend.dto.statistics.AvgDeliveredPerSizeDTO;
import com.bokafood.tbbackend.dto.statistics.AvgDeliveredPerTypeDTO;
import com.bokafood.tbbackend.dto.statistics.TotalDeliveredPerSizeDTO;
import com.bokafood.tbbackend.dto.statistics.TotalDeliveredPerTypeDTO;
import com.bokafood.tbbackend.service.StatisticService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/statistics")
@Validated
public class StatisticController {

    @Autowired
    private StatisticService statisticService;

    @GetMapping("/total-quantities-delivered-per-type")
    public ResponseEntity<List<TotalDeliveredPerTypeDTO>> getTotalDeliveredPerTypes() {
        return new ResponseEntity<>(statisticService.getTotalDeliveredPerTypes(), HttpStatus.OK);
    }


    @GetMapping("/average-quantities-delivered-per-type")
    public ResponseEntity<List<AvgDeliveredPerTypeDTO>> getAvgDeliveredPerTypes() {
        return new ResponseEntity<>(statisticService.getAvgDeliveredPerTypes(), HttpStatus.OK);
    }


    @GetMapping("/total-quantities-delivered-per-size")
    public ResponseEntity<List<TotalDeliveredPerSizeDTO>> getTotalDeliveredPerSizes() {
        return new ResponseEntity<>(statisticService.getTotalDeliveredPerSizes(), HttpStatus.OK);
    }

    @GetMapping("/average-quantities-delivered-per-size")
    public ResponseEntity<List<AvgDeliveredPerSizeDTO>> getAvgDeliveredPerSizes() {
        return new ResponseEntity<>(statisticService.getAvgDeliveredPerSizes(), HttpStatus.OK);
    }



    //@GetMapping("/quantityDeliveredPerSize")

}
