package com.example.blog.blog.controller;

import com.example.blog.blog.entity.Comment;
import com.example.blog.blog.entity.Post;
import com.example.blog.blog.repository.CommentRepository;
import com.example.blog.blog.repository.PostRepository;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/v1/comment")
@Data

public class CommentController {

@Autowired
    private CommentRepository commentRepository;
    private PostRepository postRepository;

    public CommentController(CommentRepository commentRepository, PostRepository postRepository) {
        this.commentRepository = commentRepository;
        this.postRepository = postRepository;
    }

    @PostMapping    // this method same as update method of crud operation (PutMapping)
    public ResponseEntity<Comment>postcomment(@RequestBody Comment comment, @RequestParam long postId){

Optional<Post> oppost = postRepository.findById(postId);

        Post posts = oppost.get();
        comment.setPost(posts);
        System.out.println("Gaurav");
        Comment savedComment = commentRepository.save(comment);
        return new ResponseEntity<>(savedComment,HttpStatus.OK);


    }


}
