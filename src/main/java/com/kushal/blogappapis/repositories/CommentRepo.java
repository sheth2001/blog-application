package com.kushal.blogappapis.repositories;


import com.kushal.blogappapis.entity.Category;
import com.kushal.blogappapis.entity.Comment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CommentRepo extends JpaRepository<Comment, Integer> {
}
