package com.example.receiver.rest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.receiver.domain.User;
import com.example.receiver.domain.UserIdRest;
import com.example.receiver.rest.repository.UserRestRepository;

@RestController
public class UserRestController {

	@Autowired
	UserRestRepository userRestRepository;

	@PostMapping("/rest/save")
	public Long saveUser(@RequestBody User user){
		System.out.println("user = " + user);
		return userRestRepository.save(user);
	}

	@GetMapping("/rest/users")
	public List<User> list(){
		return userRestRepository.findAll();
	}

	@GetMapping("/rest/users/{userId}")
	public User getUser(@PathVariable("userId") String userId){
		return userRestRepository.findById(Long.parseLong(userId));
	}

	@PostMapping("/rest/delete")
	public String deleteUser(@RequestBody UserIdRest id){
		return userRestRepository.delete(id.getId());
	}

	@PostMapping("/rest/update")
	public String updateUser(@RequestBody User user){
		return userRestRepository.update(user);
	}
}
