package com.somshine.webApp.controller;

import java.util.List;

import javax.ws.rs.QueryParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.somshine.webApp.model.User;
import com.somshine.webApp.repository.UserRepository;

@RestController
@RequestMapping("/users")
@CrossOrigin(origins = {"http://localhost:3000", "http://localhost:4200"})
public class UserController {
	@Autowired
	private UserRepository userRepository;
	
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public List<User> getUsers() {
		return userRepository.findAll();
	}
	
	@RequestMapping(value = "/get/{id}", method = RequestMethod.GET)
	public User getUser(@PathVariable Long id) {
		return userRepository.findById(id).orElse(null);
	}
	
	@RequestMapping(value = "/update", method = RequestMethod.PUT)
	public User updateUser(@RequestBody User user) {
		User savedUser = userRepository.getOne(user.getId());
		savedUser.setFirstName(user.getFirstName());
		savedUser.setLastName(user.getLastName());
		savedUser.setMobileNo(user.getMobileNo());
		return userRepository.save(savedUser);
	}
	
	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public User addUser(@RequestBody User user) {
		User newUser = new User();
		newUser.setShoppeId(1);
		newUser.setFirstName(user.getFirstName());
		newUser.setLastName(user.getLastName());
		newUser.setMobileNo(user.getMobileNo());
		newUser.setPassword("454654sdf");
		newUser.setUsername("5345345435");
		return userRepository.save(newUser);
	}
	
	@RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
	public void deleteUser(@PathVariable Long id) {
		User savedUser = userRepository.getOne(id);
		userRepository.delete(savedUser);
	}
	
	@RequestMapping(value = "/search", method = RequestMethod.GET)
	public List<User> searchUser(@RequestParam String name) {
		return userRepository.findBySearch(name, name);
	}
}
