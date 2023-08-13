package com.kushal.blogappapis.repositories;

import com.kushal.blogappapis.entity.Category;
import com.kushal.blogappapis.entity.Post;
import com.kushal.blogappapis.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PostRepo extends JpaRepository<Post, Integer> {
    List<Post> findByCategory(Category category);

    List<Post> findByUser(User user);
}
