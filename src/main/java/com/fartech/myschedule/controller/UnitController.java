package com.fartech.myschedule.controller;

import com.fartech.myschedule.model.Seller;
import com.fartech.myschedule.model.Unit;
import com.fartech.myschedule.repository.SellerRepository;
import com.fartech.myschedule.repository.UnitRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/")
public class UnitController {
    private final UnitRepository unitRepository;

    @Autowired
    public UnitController(UnitRepository unitRepository) {
        this.unitRepository = unitRepository;
    }

    @CrossOrigin
    @GetMapping("/allUnits")
    public List<Unit> getAllUnits() {
        System.out.println("All Units is called ...");
        return unitRepository.findAll(new Sort(Sort.Direction.ASC, "unitId"));
    }

}
