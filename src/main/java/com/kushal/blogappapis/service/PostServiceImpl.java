package com.kushal.blogappapis.service;

import com.kushal.blogappapis.DTOs.CategoryDto;
import com.kushal.blogappapis.DTOs.PostDto;
import com.kushal.blogappapis.DTOs.UserDto;
import com.kushal.blogappapis.entity.Category;
import com.kushal.blogappapis.entity.Post;
import com.kushal.blogappapis.entity.User;
import com.kushal.blogappapis.exception.ResourceNotFoundException;
import com.kushal.blogappapis.repositories.CategoryRepo;
import com.kushal.blogappapis.repositories.PostRepo;
import com.kushal.blogappapis.repositories.UserRepo;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class PostServiceImpl implements PostService{
    @Autowired
    private PostRepo postRepo;
    @Autowired
    private UserRepo userRepo;
    @Autowired
    private CategoryRepo categoryRepo;
    @Autowired
    private ModelMapper modelMapper;
    @Override
    public PostDto createPost(PostDto postDto, int userId, int categoryId) {
        User user = (User) userRepo.findById(userId).orElseThrow(() -> new ResourceNotFoundException("User", "id", userId));
        Category category = (Category) categoryRepo.findById(categoryId).orElseThrow(() -> new ResourceNotFoundException("Category", "id", categoryId));
        Post post = new Post();
        post.setTitle(postDto.getTitle());
        post.setContent(postDto.getContent());
        post.setImageName("default.png");
        post.setAddDate(new Date());
        post.setUser(user);
        post.setCategory(category);
        Post post1 = postRepo.save(post);
        PostDto postDto1 = modelMapper.map(post1, PostDto.class);
        postDto1.setUserDto(modelMapper.map(post1.getUser(), UserDto.class));
        postDto1.setCategoryDto(modelMapper.map(post1.getCategory(), CategoryDto.class));
        return postDto1;
    }

    @Override
    public PostDto updatePost(PostDto postDto, int id) {
        Post post = (Post) postRepo.findById(id).orElseThrow(() -> new ResourceNotFoundException("Post", "id", id));
        post.setTitle(postDto.getTitle());
        post.setContent(postDto.getContent());
        post.setImageName(postDto.getImageName());

        PostDto postDto1 = modelMapper.map(postRepo.save(post), PostDto.class);
        postDto1.setCategoryDto(modelMapper.map(post.getCategory(), CategoryDto.class));
        postDto1.setUserDto(modelMapper.map(post.getUser(), UserDto.class));

        return postDto1;
    }

    @Override
    public void deletePost(int id) {
        postRepo.deleteById(id);
    }

    @Override
    public PostDto findPostById(int id) {
        Post post = (Post) postRepo.findById(id).orElseThrow(() -> new ResourceNotFoundException("Post", "id", id));
        PostDto postDto = modelMapper.map(post, PostDto.class);
        postDto.setCategoryDto(modelMapper.map(post.getCategory(), CategoryDto.class));
        postDto.setUserDto(modelMapper.map(post.getUser(), UserDto.class));
        return postDto;
    }

    @Override
    public List<PostDto> findPostByCategory(int categoryId) {

        Category category = (Category) categoryRepo.findById(categoryId).orElseThrow(() -> new ResourceNotFoundException("Category", "id", categoryId));
        List<Post> postList= postRepo.findByCategory(category);

        List<PostDto> postDtoList = postList.stream().map(post -> modelMapper.map(post, PostDto.class)).collect(Collectors.toList());
        for(int i = 0; i < postList.size(); i++) {
            postDtoList.get(i).setUserDto(modelMapper.map(postList.get(i).getUser(), UserDto.class));
            postDtoList.get(i).setCategoryDto(modelMapper.map(postList.get(i).getCategory(), CategoryDto.class));
        }
        return postDtoList;
    }

    @Override
    public List<PostDto> findPostByUser(int userId) {
        User user = (User) userRepo.findById(userId).orElseThrow(() -> new ResourceNotFoundException("User", "id", userId));
        List<Post> postList = postRepo.findByUser(user);
        List<PostDto> postDtoList = postList.stream().map(post -> modelMapper.map(post, PostDto.class)).collect(Collectors.toList());
        for(int i = 0; i < postList.size(); i++) {
            postDtoList.get(i).setUserDto(modelMapper.map(postList.get(i).getUser(), UserDto.class));
            postDtoList.get(i).setCategoryDto(modelMapper.map(postList.get(i).getCategory(), CategoryDto.class));
        }
        return postDtoList;
    }
}
