package com.fartech.myschedule.controller;

import com.fartech.myschedule.model.Category;
import com.fartech.myschedule.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/")
public class CategoryController {
    private final CategoryRepository categoryRepository;

    @Autowired
    public CategoryController(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @CrossOrigin
    @GetMapping("/allCategories")
    public List<Category> getAllCategories() {
        System.out.println("All Categories is called ...");
        return categoryRepository.findAll(new Sort(Sort.Direction.ASC, "categoryId"));
    }
    // Create a new Category
    @CrossOrigin
    @PostMapping("/addCategory")
    public Category addCategory(@Valid @RequestBody Category category) {
        System.out.println("Add Category is called ..." +category.toString());
        return categoryRepository.save(category);
    }
}
