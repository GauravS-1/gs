package com.example.blog.blog.controller;

import com.example.blog.blog.entity.Post;
import com.example.blog.blog.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/post")
public class PostController {

    @Autowired
    private PostRepository postRepository;


    @PostMapping
    public ResponseEntity<Post> addpost(@RequestBody Post post){
        Post saved = postRepository.save(post);
        return new ResponseEntity<>(saved, HttpStatus.CREATED);


    }


}
