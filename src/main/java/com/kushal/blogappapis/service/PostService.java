package com.kushal.blogappapis.service;

import com.kushal.blogappapis.DTOs.PostDto;

import java.util.List;

public interface PostService {
    PostDto createPost(PostDto postDto, int userId, int categoryId);
    PostDto updatePost(PostDto postDto, int id);
    void deletePost(int id);
    PostDto findPostById(int id);
    List<PostDto> findPostByCategory(int categoryId);
    List<PostDto> findPostByUser(int userId);

}
