package com.kushal.blogappapis.service;

import com.kushal.blogappapis.DTOs.CategoryDto;

import java.util.List;

public interface CategoryService {
    CategoryDto createCategory(CategoryDto categoryDto);
    CategoryDto updateCategory(CategoryDto categoryDto, int id);
    CategoryDto getCategoryById(int id);
    void deleteCategory(int id);
}
