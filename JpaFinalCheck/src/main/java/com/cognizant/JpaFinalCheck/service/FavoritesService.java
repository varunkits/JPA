package com.cognizant.JpaFinalCheck.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cognizant.JpaFinalCheck.entity.Favorites;
import com.cognizant.JpaFinalCheck.entity.Movie;
import com.cognizant.JpaFinalCheck.entity.User;
import com.cognizant.JpaFinalCheck.repository.FavoritesRepository;

@Service
public class FavoritesService {
	@Autowired
	FavoritesRepository favoritesRepository;
	@Autowired
	MovieService movieService;
	@Autowired
	UserService userService; 
	@Transactional
	public void addToFavorites(int movieId) {		
		User user = userService.getUser(1);
		Movie movie = movieService.getMovie(movieId);
		Favorites favorites = new Favorites();
		favorites.setUser(user);
		favorites.setMovie(movie);
		favoritesRepository.save(favorites);
	}

	@Transactional
	public List<Favorites> getFavorites(){
		return favoritesRepository.findById(1);
	}
	@Transactional
	public void deleteFav(int id) {
		favoritesRepository.delete(favoritesRepository.getOne(id));
	}
	
}
