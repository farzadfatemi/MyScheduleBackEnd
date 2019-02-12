package com.fartech.myschedule.controller;

import com.fartech.myschedule.model.Activity;
import com.fartech.myschedule.model.ActivityCategory;
import com.fartech.myschedule.repository.ActivityCategoryRepository;
import com.fartech.myschedule.repository.ActivityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

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
        List<Activity> test = activityRepository.findAll(new Sort(Sort.Direction.ASC, "activityId"));
        System.out.println(test);
        return test;
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
        System.out.println("Add Activity is called ..."+ activity.toString());
        return activityRepository.save(activity);
//        return null;
    }

    // Remove a new Activity
    @CrossOrigin
    @PostMapping(value = "/deleteActivity")
    @ResponseStatus(value = HttpStatus.OK)
    public String deleteUser(@Valid @RequestBody Integer idx, final RedirectAttributes redirectAttributes) {

        System.out.println("Delete activity with Id : "+idx);

        redirectAttributes.addFlashAttribute("css", "Success");
        redirectAttributes.addFlashAttribute("msg", "The user is deleted");

        activityRepository.deleteById(idx);
        return String.valueOf(redirectAttributes);
    }
}
