package com.fartech.myschedule.controller;

import com.fartech.myschedule.model.Unit;
import com.fartech.myschedule.model.Unit;
import com.fartech.myschedule.repository.UnitRepository;
import com.fartech.myschedule.repository.UnitRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
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
    @CrossOrigin
    @PostMapping("/addUnit")
    public Unit addUnit(@Valid @RequestBody Unit unit) {
        System.out.println("Add Unit is called ...");
        return unitRepository.save(unit);
    }
}
