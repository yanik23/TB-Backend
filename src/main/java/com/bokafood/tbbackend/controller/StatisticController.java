package com.bokafood.tbbackend.controller;


import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/statistics")
@Validated
public class StatisticController {


    @GetMapping("/quantityDeliveredPerType")
    public String getQuantityDeliveredPerType() {
        return "quantityDeliveredPerType";
    }


    //@GetMapping("/quantityDeliveredPerSize")

}
