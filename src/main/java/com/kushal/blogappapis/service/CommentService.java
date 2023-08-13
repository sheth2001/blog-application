package com.kushal.blogappapis.service;

import com.kushal.blogappapis.DTOs.CommentDto;

public interface CommentService {
    CommentDto crateComment(CommentDto commentDto, int postId);
    void deleteComment(int commentId);
}
