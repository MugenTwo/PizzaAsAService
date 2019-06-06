package com.mugen.doughservice.controller;

import com.mugen.doughservice.dao.DoughRepository;
import com.mugen.doughservice.exception.ResourceField;
import com.mugen.doughservice.exception.ResourceNotFoundException;
import com.mugen.doughservice.model.Dough;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;

@RestController
public class DoughController {

    private static final String RESOURCE_NAME = Dough.class.getName();

    @Autowired
    private DoughRepository doughRepository;

    @GetMapping("/doughs")
    public List<Dough> retrieveAllDoughs() {
        return this.doughRepository.findAll();
    }

    @PostMapping("/doughs")
    public Dough createDough(@RequestBody Dough dough) {
        return this.doughRepository.save(dough);
    }

    @GetMapping("/doughs/{id}")
    public Dough retrieveDough(@PathVariable long id) {
        return this.doughRepository.findById(id)
                .orElseThrow(() -> {
                    ResourceField idField = new ResourceField("id", id);
                    List<ResourceField> filteredFields = Collections.singletonList(idField);
                    throw new ResourceNotFoundException(RESOURCE_NAME, filteredFields);
                });
    }

    @PutMapping("/doughs/{id}")
    public Dough replaceDough(@RequestBody Dough updatedDough, @PathVariable Long id) {
        return this.doughRepository.findById(id)
                .map(dought -> {
                    Dough doughtToUpdate = updatedDough.toBuilder()
                            .id(dought.getId())
                            .build();
                    return this.doughRepository.save(doughtToUpdate);
                })
                .orElseThrow(() -> {
                    ResourceField idField = new ResourceField("id", id);
                    List<ResourceField> filteredFields = Collections.singletonList(idField);
                    throw new ResourceNotFoundException(RESOURCE_NAME, filteredFields);
                });
    }

    @DeleteMapping("/doughs/{id}")
    public ResponseEntity<?> deleteDough(@PathVariable Long id) {
        Dough dough = this.doughRepository.findById(id)
                .orElseThrow(() -> {
                    ResourceField idField = new ResourceField("id", id);
                    List<ResourceField> filteredFields = Collections.singletonList(idField);
                    throw new ResourceNotFoundException(RESOURCE_NAME, filteredFields);
                });

        this.doughRepository.delete(dough);

        return ResponseEntity.ok().build();
    }

}
