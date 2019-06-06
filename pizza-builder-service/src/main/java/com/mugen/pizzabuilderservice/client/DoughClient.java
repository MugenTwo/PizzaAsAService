package com.mugen.pizzabuilderservice.client;

import com.mugen.pizzabuilderservice.model.Dough;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@FeignClient("dough-service")
public interface DoughClient {

    @RequestMapping(method = RequestMethod.GET, value = "/doughs")
    List<Dough> retrieveAllDoughs();

    @RequestMapping(method = RequestMethod.POST, value = "/doughs")
    public Dough createDough(@RequestBody Dough dough);

    // TODO: Always put the path variable name
    @RequestMapping(method = RequestMethod.GET, value = "/doughs/{id}")
    public Dough retrieveDough(@PathVariable("id") long id);

    @RequestMapping(method = RequestMethod.PUT, value = "/doughs/{id}")
    public Dough replaceDough(@RequestBody Dough updatedDough, @PathVariable("id") Long id);

    @RequestMapping(method = RequestMethod.DELETE, value = "/doughs/{id}")
    public ResponseEntity<?> deleteDough(@PathVariable("id") Long id);

}
