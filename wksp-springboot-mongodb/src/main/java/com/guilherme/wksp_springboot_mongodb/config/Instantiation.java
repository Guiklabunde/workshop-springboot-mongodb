package com.guilherme.wksp_springboot_mongodb.config;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.TimeZone;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.guilherme.wksp_springboot_mongodb.domain.Post;
import com.guilherme.wksp_springboot_mongodb.domain.User;
import com.guilherme.wksp_springboot_mongodb.repository.PostRepository;
import com.guilherme.wksp_springboot_mongodb.repository.UserRepository;

@Configuration
public class Instantiation implements CommandLineRunner {

    @Autowired
    private UserRepository userRepository;
    
    @Autowired
    private PostRepository postRepository;
    
    @Override
    public void run(String... arg0) throws Exception {
        
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        sdf.setTimeZone(TimeZone.getTimeZone("GMT"));
        
        userRepository.deleteAll();
        postRepository.deleteAll();
        
        User maria = new User(null, "Maria Silva", "maria@gmail.com");
        User guilherme = new User(null, "Guilherme Andrei", "guiandrei17@gmail.com");
        User senna = new User(null, "Ayrton", "dobrasil@gmail.com");
        
        Post post1 = new Post(null, sdf.parse("21/03/2025"), "Partiu Las Vegas", "Vou para os EUA, abralho", guilherme);
        Post post2 = new Post(null, sdf.parse("17/11/2025"), "Partiu Paris", "Visitar a França com a muié, comemorar o niver.", guilherme);
        
        userRepository.saveAll(Arrays.asList(maria, guilherme, senna));
        postRepository.saveAll(Arrays.asList(post1, post2));
    }
}
