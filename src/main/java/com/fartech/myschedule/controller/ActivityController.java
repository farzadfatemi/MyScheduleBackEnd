package com.fartech.myschedule.controller;

import com.fartech.myschedule.model.Activity;
import com.fartech.myschedule.model.ActivityCategory;
import com.fartech.myschedule.model.Category;
import com.fartech.myschedule.repository.ActivityCategoryRepository;
import com.fartech.myschedule.repository.ActivityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/")
public class ActivityController {
    private final ActivityRepository activityRepository;
    private final ActivityCategoryRepository actCategoryRepository;

    @Autowired
    public ActivityController(ActivityRepository activityRepository,ActivityCategoryRepository actCategoryRepository) {
        this.activityRepository = activityRepository;
        this.actCategoryRepository = actCategoryRepository;
    }

    @CrossOrigin
    @GetMapping("/allActivities")
    public List<Activity> getAllActivities() {
        System.out.println("All Activities is called ...");
        return activityRepository.findAll(new Sort(Sort.Direction.ASC, "activityId"));
    }

    @CrossOrigin
    @GetMapping("/allActivityCat")
    public List<ActivityCategory> getAllActivityCat() {
        System.out.println("All Activity Categories is called ...");
        return actCategoryRepository.findAll(new Sort(Sort.Direction.ASC, "categoryId"));
    }
    // Create a new Activity
    @CrossOrigin
    @PostMapping("/addActivity")
    public Activity addActivity(@Valid @RequestBody Activity activity) {
        System.out.println("Add Activity is called ...");
//        return activityRepository.save(activity);
        return null;
    }
}
