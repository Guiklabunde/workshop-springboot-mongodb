package com.guilherme.wksp_springboot_mongodb.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.guilherme.wksp_springboot_mongodb.domain.User;
import com.guilherme.wksp_springboot_mongodb.repository.UserRepository;
import com.guilherme.wksp_springboot_mongodb.services.exception.ObjectNotFoundException;

@Service
public class UserService {
	
	@Autowired
	private UserRepository repo;
	
	public List<User> findAll() {
		return repo.findAll();
	}
	
	public User findById(String id) {
		User user = repo.findById(id).orElse(null); // Alterado para usar findById
		if (user == null) {
			throw new ObjectNotFoundException("Objeto não encontrado");
		}
		return user;
	}
}
