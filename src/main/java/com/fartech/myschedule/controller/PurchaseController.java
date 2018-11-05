package com.fartech.myschedule.controller;

import com.fartech.myschedule.exception.ResourceNotFoundException;
import com.fartech.myschedule.model.Purchase;
import com.fartech.myschedule.repository.PurchaseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/")
public class PurchaseController {
    @Autowired
    PurchaseRepository purchaseRepository;

    // Get All Purchases
    @CrossOrigin
    @GetMapping("/allPurchases")
    public List<Purchase> getAllPurchases() {
        System.out.println("All Purchases is called ...");
//        return purchaseRepository.findAll();
        return purchaseRepository.findAll(new Sort(Sort.Direction.DESC, "date"));
    }

    // Create a new Purchase
    @CrossOrigin
    @PostMapping("/addPurchase")
    public Purchase addPurchase(@Valid @RequestBody Purchase purchase) {
        System.out.println("Add Purchases is called ...");
        return purchaseRepository.save(purchase);
//        return null;
    }

    // Get a Specific Purchase
    @GetMapping("/purchases/{id}")
    public Purchase getPurchaseById(@PathVariable(value = "id") int purchaseId) {
        return purchaseRepository.findById(purchaseId)
                .orElseThrow(() -> new ResourceNotFoundException("Purchase", "id", purchaseId));
    }

    // Update a Purchase
    @PutMapping("/purchases/{id}")
    public Purchase updatePurchase(@PathVariable(value = "id") int purchaseId,
                           @Valid @RequestBody Purchase purchaseDetails) {

        Purchase purchase = purchaseRepository.findById(purchaseId)
                .orElseThrow(() -> new ResourceNotFoundException("Purchase", "id", purchaseId));

//        purchase.setPurchaseId(purchaseDetails.getPurchaseId());
        purchase.setProductId(purchaseDetails.getProductId());
        purchase.setComment(purchaseDetails.getComment());
        purchase.setCategoryId(purchaseDetails.getCategoryId());
        purchase.setAmount(purchaseDetails.getAmount());
        purchase.setDate(purchaseDetails.getDate());
        purchase.setPrice(purchaseDetails.getPrice());
        purchase.setTodo(purchaseDetails.isTodo());
        purchase.setSellerId(purchaseDetails.getSellerId());

        return purchaseRepository.save(purchase);
    }

    // Delete a Purchase
    @DeleteMapping("/purchases/{id}")
    public ResponseEntity<?> deletePurchase(@PathVariable(value = "id") int purchaseId) {
        Purchase purchase = purchaseRepository.findById(purchaseId)
                .orElseThrow(() -> new ResourceNotFoundException("Purchase", "id", purchaseId));

        purchaseRepository.delete(purchase);

        return ResponseEntity.ok().build();
    }
}
