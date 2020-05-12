package com.cognizant.JpaPracticeCheck.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cognizant.JpaPracticeCheck.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer>{

}
