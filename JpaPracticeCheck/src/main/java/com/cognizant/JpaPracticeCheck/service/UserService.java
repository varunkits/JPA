package com.cognizant.JpaPracticeCheck.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cognizant.JpaPracticeCheck.entity.User;
import com.cognizant.JpaPracticeCheck.repository.UserRepository;

@Service
public class UserService {

	@Autowired
	private UserRepository userRepository;
	
	@Transactional
	public User getUser(int id)
	{
		return userRepository.findById(id).get();
	}		
	
	
	@Transactional
	public void save(User user)
	{
		userRepository.save(user);
	}
}
