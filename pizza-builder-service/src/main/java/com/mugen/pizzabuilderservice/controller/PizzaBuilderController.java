package com.mugen.pizzabuilderservice.controller;

import com.mugen.pizzabuilderservice.client.DoughClient;
import com.mugen.pizzabuilderservice.model.Dough;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class PizzaBuilderController {

    @Autowired
    private DoughClient doughClient;

    @GetMapping("/build-pizza")
    private String buildPizza(@PathVariable long id) {
        return "The dought of the pizza is " + this.doughClient.retrieveDough(id).getName();
    }

    @PostMapping("/add-dough")
    private String addDough(@RequestBody Dough dough) {
        this.doughClient.createDough(dough);
        return "Dough:" + dough.getName() + " added";
    }

}
