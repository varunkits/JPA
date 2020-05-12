package com.cognizant.JpaFinalCheck.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cognizant.JpaFinalCheck.entity.User;
import com.cognizant.JpaFinalCheck.repository.UserRepository;

@Service
public class UserService{

	@Autowired
	UserRepository userRepository;
	@Transactional
	public User getUser(int userId) {
		return userRepository.getOne(userId);
	}

}
