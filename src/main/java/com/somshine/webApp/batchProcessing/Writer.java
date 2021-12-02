package com.somshine.webApp.batchProcessing;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.batch.item.ItemWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.somshine.webApp.model.User;
import com.somshine.webApp.repository.UserRepository;

@Component
public class Writer implements ItemWriter<User>{
	
	@Autowired
	private UserRepository repo;

	@Override
	@Transactional
	public void write(List<? extends User> users) throws Exception {
		repo.saveAll(users);
	}
	
}
