package com.kushal.blogappapis.entity;

import lombok.Data;
import javax.persistence.*;

@Entity
@Data
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String content;
    @ManyToOne
    private Post post;

}
