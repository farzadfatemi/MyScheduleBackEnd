package com.fartech.myschedule.repository;

import com.fartech.myschedule.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Integer> {
}
