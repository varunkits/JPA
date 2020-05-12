package com.cognizant.ormlearn.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cognizant.ormlearn.model.Country;
import com.cognizant.ormlearn.repository.CountryRepository;
import com.cognizant.ormlearn.service.exception.CountryNotFoundException;

@Service
@Transactional
public class CountryService {

	@Autowired
	private CountryRepository countryRepository;

	public List<Country> getAllCountries() {
		
		return countryRepository.findAll();
	}
	
	@Transactional
	public Country findCountryByCode(String countryCode) throws CountryNotFoundException
	{
		Optional<Country> result = countryRepository.findById(countryCode);
		
		if(!result.isPresent())
			throw new CountryNotFoundException("country not found !!");
		
		return result.get();
	}
	
	@Transactional
	public void addCountry(Country country)
	{
		countryRepository.save(country);
	}
	
	@Transactional
	public void updateCountry(Country country) throws CountryNotFoundException
	{
		Optional<Country> result = countryRepository.findById(country.getCode());
		if(!result.isPresent())
			throw new CountryNotFoundException("country not found !!");
		
		Country country2 = result.get();
		country2.setName(country.getName());
		countryRepository.save(country2);
	}
	
	@Transactional
	public void deleteCountry(String countryCode)
	{
		countryRepository.deleteById(countryCode);
	}
	
	public List<Country> searchCountry(String country)
	{
		return countryRepository.findByNameContaining(country);
	}
	public List<Country> searchCountryFirst(String country)
	{
		return countryRepository.findByNameStartingWith(country);
	}
}
