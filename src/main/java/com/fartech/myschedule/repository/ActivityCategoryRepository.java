package com.fartech.myschedule.repository;

import com.fartech.myschedule.model.ActivityCategory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ActivityCategoryRepository extends JpaRepository<ActivityCategory, Integer> {
}
