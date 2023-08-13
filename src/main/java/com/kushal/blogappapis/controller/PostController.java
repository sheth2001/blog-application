package com.kushal.blogappapis.controller;

import com.kushal.blogappapis.DTOs.PostDto;
import com.kushal.blogappapis.service.FileService;
import com.kushal.blogappapis.service.PostService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/post")
public class PostController {
    @Value("${project.image}")
    private String path;
    @Autowired
    private PostService postService;
    @Autowired
    private ModelMapper modelMapper;
    @Autowired
    private FileService fileService;

    public PostController() {
    }

    @PostMapping("/user/{userId}/category/{categoryId}")
    public ResponseEntity<PostDto> createPost(@RequestBody PostDto postDto, @PathVariable int userId, @PathVariable int categoryId) {
         return new ResponseEntity<>(postService.createPost(postDto, userId, categoryId), HttpStatus.CREATED);
    }

    @GetMapping("/user/{id}")
    public ResponseEntity<List<PostDto>> findByUser(@PathVariable int id) {
        return new ResponseEntity<>(postService.findPostByUser(id), HttpStatus.OK);
    }
    @GetMapping("/category/{id}")
    public ResponseEntity<List<PostDto>> findByCategory(@PathVariable int id) {
        return new ResponseEntity<>(postService.findPostByCategory(id), HttpStatus.OK);
    }
    @GetMapping("{id}")
    public ResponseEntity<PostDto> findPostById(@PathVariable int id) {
        return new ResponseEntity<>(postService.findPostById(id), HttpStatus.OK);
    }
    @PostMapping("/image/upload/{postId}")
    public ResponseEntity<PostDto> uploadImage(
            @RequestParam("image")MultipartFile image, @PathVariable int postId) throws IOException {
        PostDto postDto = postService.findPostById(postId);
        String fileName = fileService.uploadImage(path, image);

        postDto.setImageName(fileName);
        postService.updatePost(postDto, postId);

        return new ResponseEntity<>(postDto, HttpStatus.OK);
    }
}
