package com.fartech.myschedule.controller;
 
import com.fartech.myschedule.model.Seller;
import com.fartech.myschedule.repository.SellerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/")
public class SellerController {
    private final SellerRepository sellerRepository;

    @Autowired
    public SellerController(SellerRepository sellerRepository) {
        this.sellerRepository = sellerRepository;
    }

    @CrossOrigin
    @GetMapping("/allSellers")
    public List<Seller> getAllSellers() {
        System.out.println("All Seller is called ...");
        return sellerRepository.findAll(new Sort(Sort.Direction.ASC, "name"));
    }
    @CrossOrigin
    @PostMapping("/addSeller")
    public Seller addSeller(@Valid @RequestBody Seller seller) {
        System.out.println("Add Seller is called ...");
        return sellerRepository.save(seller);
    }
}
