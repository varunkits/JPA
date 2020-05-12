package com.cognizant.ormlearn.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.cognizant.ormlearn.model.Stock;

@Repository
public interface StockRepository extends JpaRepository<Stock, Integer>{

	@Query(value="Select * from stock where st_code = 'FB' and Month(st_date) = 9",nativeQuery = true)
	List<Stock> findByFacebookSeptData();

	@Query(value="Select * from stock where st_code = 'GOOGL' and st_close >= 1250",nativeQuery = true)
	List<Stock> findGoogleStock1250();
}
