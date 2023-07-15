package com.bokafood.tbbackend.controller;


import com.bokafood.tbbackend.dto.statistics.QuantityDeliveredPerTypeDTO;
import com.bokafood.tbbackend.service.StatisticService;
import org.springframework.beans.factory.annotation.Autowired;
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

    @GetMapping
    public ResponseEntity<List<QuantityDeliveredPerTypeDTO>> getQuantityDeliveredPerTypes() {
        return new ResponseEntity<>(statisticService.getQuantityDeliveredPerTypes(), org.springframework.http.HttpStatus.OK);
    }


    //@GetMapping("/quantityDeliveredPerSize")

}
