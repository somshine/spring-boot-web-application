package com.somshine.webApp.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.somshine.webApp.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
	User findByUsername(String username);
	
	@Query("Select u from User u where u.firstName like %:firstName% OR lastName like %:lastName%")
	List<User> findBySearch(String firstName, String lastName);
}