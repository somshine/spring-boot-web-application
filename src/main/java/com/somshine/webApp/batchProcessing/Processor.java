package com.somshine.webApp.batchProcessing;

import java.util.Optional;

import org.springframework.batch.item.ItemProcessor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.somshine.webApp.model.User;
import com.somshine.webApp.repository.UserRepository;

@Component
public class Processor implements ItemProcessor<User, User> {
	@Autowired
	private UserRepository repo;
	
	@Override
	public User process(User user) {
		Optional<User> userFromDb = repo.findById(user.getId());
		if (userFromDb.isPresent()) {
			user.setFirstName(userFromDb.get().getFirstName());
			user.setMiddleName(userFromDb.get().getMiddleName());
			user.setLastName(userFromDb.get().getLastName());
			user.setMobileNo(userFromDb.get().getMobileNo());
			user.setEmailAddress(userFromDb.get().getEmailAddress());
		}
		return user;
	}
}
