package com.lux.lux.service;

import com.lux.lux.dto.PostDto;
import com.lux.lux.exception.NonTrovatoException;
import com.lux.lux.model.Post;
import com.lux.lux.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostService {

    @Autowired
    private PostRepository postRepository;

    public Post savePost(PostDto postDto){
        Post post = new Post();
        post.setData(postDto.getData());
        post.setTitolo(postDto.getTitolo());
        post.setPrimaImmagine(postDto.getPrimaImmagine());
        post.setSecondaImmagine(postDto.getSecondaImmagine());
        post.setTerzaImmagine(postDto.getTerzaImmagine());
        post.setDimensione(postDto.getDimensione());
        post.setDescrizione(postDto.getDescrizione());
        return postRepository.save(post);
    }

    public List<Post> getAllPost(){
        return postRepository.findAllByOrderByIdDesc();
    }

    public Post getPost(int id) throws NonTrovatoException {
        return postRepository.findById(id).orElseThrow(()-> new NonTrovatoException("Post non trovato"));
    }

    public Post updatePost(int id, PostDto postDto) throws NonTrovatoException {
        Post post = getPost(id);
        post.setData(postDto.getData());
        post.setTitolo(postDto.getTitolo());
        post.setPrimaImmagine(postDto.getPrimaImmagine());
        post.setSecondaImmagine(postDto.getSecondaImmagine());
        post.setTerzaImmagine(postDto.getTerzaImmagine());
        post.setDimensione(postDto.getDimensione());
        post.setDescrizione(postDto.getDescrizione());
        return postRepository.save(post);
    }

    public void deletePost(int id) throws NonTrovatoException {
        Post post = getPost(id);
        postRepository.delete(post);
    }

}
