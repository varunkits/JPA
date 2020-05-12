package com.cognizant.JpaFinalCheck;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.cognizant.JpaFinalCheck.entity.Favorites;
import com.cognizant.JpaFinalCheck.entity.Movie;
import com.cognizant.JpaFinalCheck.service.FavoritesService;
import com.cognizant.JpaFinalCheck.service.MovieService;

@SpringBootApplication
public class JpaFinalCheckApplication {

	private static final Logger LOGGER = LoggerFactory.getLogger(JpaFinalCheckApplication.class);
	

	private static MovieService movieService;
	
	private static FavoritesService favoritesService;

	
	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(JpaFinalCheckApplication.class, args);
		movieService = context.getBean(MovieService.class);
		favoritesService = context.getBean(FavoritesService.class);
//		testGetMovieListAdmin();
//		testGetMovieListCustomer();
//		testEditMovie();
//		testAddToFav();

	}

	private static void testAddToFav() {
		LOGGER.info("Start ");
		favoritesService.addToFavorites(1);
		List<Favorites> favoritess = favoritesService.getFavorites();
		LOGGER.debug("Favorites:{}", favoritess);
		LOGGER.info("End ");
		
	}

	private static void testEditMovie() {
		LOGGER.info("Start");
		movieService.editMovie(new Movie());
		LOGGER.info("End");
		
	}

	private static void testGetMovieListCustomer() {
		LOGGER.info("Start");
		List<Movie> movieList = movieService.getMovieListCustomer();
		LOGGER.debug("Customer Movie List: {}", movieList);
		LOGGER.info("End");
		
	}

	private static void testGetMovieListAdmin() {
		LOGGER.info("Start");
		List<Movie> movieList = movieService.getMovieListAdmin();
		LOGGER.debug("Admin Movie List: {}", movieList);
		LOGGER.info("End");
	}


	
	
}
