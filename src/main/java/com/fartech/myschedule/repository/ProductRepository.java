package com.fartech.myschedule.repository;

import com.fartech.myschedule.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Integer> {
}
