package com.kushal.blogappapis.controller;

import com.kushal.blogappapis.DTOs.CategoryDto;
import com.kushal.blogappapis.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/category")
public class CategoryController {
    @Autowired
    private CategoryService categoryService;

    @PutMapping("/update/{id}")
    public ResponseEntity<CategoryDto> updateCategory(@RequestBody CategoryDto categoryDto, @PathVariable String id) {
        return ResponseEntity.ok(categoryService.updateCategory(categoryDto, Integer.parseInt(id)));
    }
    @GetMapping("{id}")
    public ResponseEntity<CategoryDto> getById(@PathVariable int id) {
        return ResponseEntity.ok(categoryService.getCategoryById(id));
    }
    @PostMapping("/create")
    public ResponseEntity<CategoryDto> createCategory(@RequestBody CategoryDto categoryDto){
        return ResponseEntity.ok(categoryService.createCategory(categoryDto));
    }

}
