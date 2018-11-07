package com.fartech.myschedule.controller;

import com.fartech.myschedule.model.Manufacturer;
import com.fartech.myschedule.repository.ManufacturerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/")
public class ManufacturerController {
    private final ManufacturerRepository manufacturerRepository;

    @Autowired
    public ManufacturerController(ManufacturerRepository manufacturerRepository) {
        this.manufacturerRepository = manufacturerRepository;
    }

    @CrossOrigin
    @GetMapping("/allManufacturers")
    public List<Manufacturer> getAllManufacturers() {
        System.out.println("All Manufacturers is called ...");
        return manufacturerRepository.findAll(new Sort(Sort.Direction.ASC, "manufacturerId"));
    }
    @CrossOrigin
    @PostMapping("/addManufacturer")
    public Manufacturer addManufacturer(@Valid @RequestBody Manufacturer manufacturer) {
        System.out.println("Add Manufacturer is called ...");
        return manufacturerRepository.save(manufacturer);
    }
}
