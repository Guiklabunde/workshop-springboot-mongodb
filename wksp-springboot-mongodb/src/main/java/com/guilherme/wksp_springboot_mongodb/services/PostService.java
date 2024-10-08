package com.guilherme.wksp_springboot_mongodb.services;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.guilherme.wksp_springboot_mongodb.domain.Post;
import com.guilherme.wksp_springboot_mongodb.repository.PostRepository;
import com.guilherme.wksp_springboot_mongodb.services.exception.ObjectNotFoundException;

@Service
public class PostService {

    @Autowired
    private PostRepository repo;

    public List<Post> findAll() {
        return repo.findAll();
    }

    public Post findById(String id) {
        return repo.findById(id).orElseThrow(() ->
            new ObjectNotFoundException("Objeto não encontrado")
        );
    }

    public List<Post> findByTitle(String text) {
        return repo.searchTitle(text);
    }
    
    public List<Post> fullSearch(String text, Date minDate, Date maxDate) {
        maxDate = new Date(maxDate.getTime() + 24 * 60 * 60 * 1000);
        return repo.fullSearch(text, minDate, maxDate);
    }
}