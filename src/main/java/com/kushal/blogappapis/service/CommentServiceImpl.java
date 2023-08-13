package com.kushal.blogappapis.service;

import com.kushal.blogappapis.DTOs.CommentDto;
import com.kushal.blogappapis.entity.Comment;
import com.kushal.blogappapis.entity.Post;
import com.kushal.blogappapis.exception.ResourceNotFoundException;
import com.kushal.blogappapis.repositories.CommentRepo;
import com.kushal.blogappapis.repositories.PostRepo;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CommentServiceImpl implements CommentService {
    @Autowired
    private CommentRepo commentRepo;
    @Autowired
    private PostRepo postRepo;
    @Autowired
    private ModelMapper modelMapper;
    @Override
    public CommentDto crateComment(CommentDto commentDto, int postId) {
        Post post = (Post) postRepo.findById(postId).orElseThrow(() -> new ResourceNotFoundException("Post", "id", postId));
        Comment comment = modelMapper.map(commentDto, Comment.class);
        comment.setPost(post);
        Comment savedComment = commentRepo.save(comment);
        return modelMapper.map(savedComment, CommentDto.class);
    }

    @Override
    public void deleteComment(int commentId) {
        Comment comment = (Comment) commentRepo.findById(commentId).orElseThrow(() -> new ResourceNotFoundException("Comment", "id", commentId));
        commentRepo.delete(comment);
    }
}
