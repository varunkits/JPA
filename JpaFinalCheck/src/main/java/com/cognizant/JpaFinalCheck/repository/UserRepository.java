package com.cognizant.JpaFinalCheck.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cognizant.JpaFinalCheck.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

}
