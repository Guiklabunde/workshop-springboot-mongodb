package com.guilherme.wksp_springboot_mongodb.resources;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.guilherme.wksp_springboot_mongodb.domain.User;

@RestController
@RequestMapping(value = "/users")
public class UserResource {
    
    @GetMapping
    public ResponseEntity<List<User>> findAll() {
        User maria = new User(null, "Maria Silva", "maria@gmail.com");
        User guilherme = new User(null, "Guilherme Klabunde", "guiandrei17@gmail.com");
        
        List<User> list = new ArrayList<>();
        list.addAll(Arrays.asList(maria, guilherme));
        
        return ResponseEntity.ok().body(list);
    	}
}