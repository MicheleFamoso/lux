package com.lux.lux.controller;


import com.lux.lux.dto.PostDto;
import com.lux.lux.exception.NonTrovatoException;
import com.lux.lux.exception.ValidationException;
import com.lux.lux.model.Post;
import com.lux.lux.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.DefaultMessageSourceResolvable;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PostController {

    @Autowired
    private PostService postService;


    @PostMapping("/post")
    @ResponseStatus(HttpStatus.CREATED)
    public Post createPost(@RequestBody @Validated PostDto postDto, BindingResult bindingResult) throws ValidationException {
          if (bindingResult.hasErrors()){
            throw new ValidationException(bindingResult.getAllErrors().stream()
                    .map(DefaultMessageSourceResolvable::getDefaultMessage).reduce("",(e, c)->e+c));
        }
          return postService.savePost(postDto);
    }


    @GetMapping("/post")
    public List<Post> getPosts(){return postService.getAllPost();}

    @GetMapping("/post/{id}")
    public Post getPost(@PathVariable int id) throws NonTrovatoException {
        return postService.getPost(id);
    }

    @PutMapping("/post/{id}")
    public Post updatePost(@PathVariable int id,
                           @RequestBody @Validated PostDto postDto,
                           BindingResult bindingResult) throws ValidationException, NonTrovatoException {
          if (bindingResult.hasErrors()){
            throw new ValidationException(bindingResult.getAllErrors().stream()
                    .map(DefaultMessageSourceResolvable::getDefaultMessage).reduce("",(e, c)->e+c));
        }
          return postService.updatePost(id, postDto);
    }

    @DeleteMapping("post/{id}")
    public void deletePost(@PathVariable int id) throws NonTrovatoException {
        postService.deletePost(id);
    }

}
