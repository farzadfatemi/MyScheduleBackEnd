package com.fartech.myschedule.repository;

import com.fartech.myschedule.model.Purchase;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Collection;

public interface PurchaseRepository extends JpaRepository<Purchase, Integer> {

}
