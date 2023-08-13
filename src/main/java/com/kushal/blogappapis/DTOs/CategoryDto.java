package com.kushal.blogappapis.DTOs;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CategoryDto {
    private int id;
    @NotEmpty
    private String categoryTitle;
    @NotEmpty
    private String categoryDescription;

    public String getCategoryTitle() {
        return this.categoryTitle;
    }

    public String getCategoryDescription() {
        return this.categoryDescription;
    }
}
