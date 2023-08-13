package com.kushal.blogappapis.controller;

import com.kushal.blogappapis.DTOs.CommentDto;
import com.kushal.blogappapis.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/comment")
public class CommentController {
    @Autowired
    private CommentService commentService;

    @PostMapping("/post/{postId}")
    public ResponseEntity<CommentDto> createComment(@RequestBody CommentDto commentDto, @PathVariable int postId) {
        return new ResponseEntity<>(commentService.crateComment(commentDto, postId), HttpStatus.CREATED);
    }
}
