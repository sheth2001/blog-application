package com.kushal.blogappapis.service;

import com.kushal.blogappapis.DTOs.CategoryDto;
import com.kushal.blogappapis.entity.Category;
import com.kushal.blogappapis.exception.ResourceNotFoundException;
import com.kushal.blogappapis.repositories.CategoryRepo;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService{
    @Autowired
    private CategoryRepo categoryRepo;
    @Autowired
    private ModelMapper modelMapper;
    @Override
    public CategoryDto createCategory(CategoryDto categoryDto) {
        Category category = modelMapper.map(categoryDto, Category.class);
        category = categoryRepo.save(category);

        return modelMapper.map(category, CategoryDto.class);
    }

    @Override
    public CategoryDto updateCategory(CategoryDto categoryDto, int id) {
        Category category = (Category) categoryRepo.findById(id).orElseThrow(() -> new ResourceNotFoundException("Category", "id", id));
        category.setCategoryTitle(categoryDto.getCategoryTitle());
        category.setCategoryDescription(categoryDto.getCategoryDescription());
        return modelMapper.map(categoryRepo.save(category), CategoryDto.class);
    }

    @Override
    public CategoryDto getCategoryById(int id) {
        Category category = (Category) categoryRepo.findById(id).orElseThrow(() -> new ResourceNotFoundException("Category", "id", id));
        return modelMapper.map(category, CategoryDto.class);
    }

    @Override
    public void deleteCategory(int id) {
        categoryRepo.deleteById(id);
    }
}
