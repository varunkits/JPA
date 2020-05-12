package com.cognizant.ormlearn.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.cognizant.ormlearn.model.Country;

@Repository
public interface CountryRepository extends JpaRepository<Country, String> {
	
	@Query(value="Select * from country where co_name like '%ou%' order by co_name",nativeQuery = true)
	List<Country> findByNameContaining(String country);
	
	List<Country> findByNameStartingWith(String country);
}
