package com.kushal.blogappapis.DTOs;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PostDto {
    private int postId;
    private String title;
    private String content;
    private String imageName;
    private Date addDate;
    private CategoryDto categoryDto;
    private UserDto userDto;
    private Set<CommentDto> comments = new HashSet<>();

    public void setUserDto(UserDto userDto) {
        this.userDto = userDto;
    }

    public int getPostId() {
        return postId;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getAddDate() {
        return addDate;
    }

    public void setAddDate(Date addDate) {
        this.addDate = addDate;
    }

    public CategoryDto getCategoryDto() {
        return categoryDto;
    }

    public UserDto getUserDto() {
        return userDto;
    }

    public Set<CommentDto> getComments() {
        return comments;
    }

    public void setComments(Set<CommentDto> comments) {
        this.comments = comments;
    }

    public void setCategoryDto(CategoryDto categoryDto) {
        this.categoryDto = categoryDto;
    }

    public String getTitle() {
        return this.title;
    }

    public String getContent() {
        return this.content;
    }

    public String getImageName() {
        return this.imageName;
    }

    public void setImageName(String fileName) {
        this.imageName = fileName;
    }

    public void setPostId(int i) {
        this.postId = i;
    }
}
