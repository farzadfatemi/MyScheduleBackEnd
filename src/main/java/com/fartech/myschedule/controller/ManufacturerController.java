package com.fartech.myschedule.controller;

import com.fartech.myschedule.model.Manufacturer;
import com.fartech.myschedule.repository.ManufacturerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

}
