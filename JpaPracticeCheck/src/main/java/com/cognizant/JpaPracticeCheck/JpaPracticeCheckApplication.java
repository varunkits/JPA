package com.cognizant.JpaPracticeCheck;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.cognizant.JpaPracticeCheck.entity.MenuItem;
import com.cognizant.JpaPracticeCheck.entity.User;
import com.cognizant.JpaPracticeCheck.service.MenuItemService;
import com.cognizant.JpaPracticeCheck.service.UserService;

@SpringBootApplication
public class JpaPracticeCheckApplication {

	private static final Logger LOGGER = LoggerFactory.getLogger(JpaPracticeCheckApplication.class);
	
	private static MenuItemService menuItemService;
	
	private static UserService userService;
	
	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(JpaPracticeCheckApplication.class, args);
		menuItemService = context.getBean(MenuItemService.class);
		userService = context.getBean(UserService.class);
		//testGetMenuItemListCustomer();
		//testGetMenuItemListAdmin();
		//testEditMenuItem();
		//testAddtoCart();
		//testGetCart();
		testGetMovieListAdmin();
		testGetMovieListCustomer();
		testEditMovie();
		testAddToFav();
	}

	private static void testAddToFav() {
		// TODO Auto-generated method stub
		
	}

	private static void testEditMovie() {
		// TODO Auto-generated method stub
		
	}

	private static void testGetMovieListCustomer() {
		
	}

	private static void testGetMovieListAdmin() {
		
		
	}

	private static void testGetCart() {
		LOGGER.info("Inside testGetCart");
		User user = userService.getUser(101);
		LOGGER.debug("Cart={}",user.getMenuItemList());
		
	}

	private static void testAddtoCart() {

		
		LOGGER.info("Inside testAddtoCart");
		MenuItem menuItem = menuItemService.getMenuItem(2);
		User user = userService.getUser(101);
		LOGGER.debug("user={}",user);
		user.getMenuItemList().add(menuItem);
		userService.save(user);
		
		
	}

	private static void testEditMenuItem() {
		LOGGER.info("Inside testEditMenuItem()");
		
		MenuItem menuItem = menuItemService.getMenuItem(1);
		LOGGER.debug("menuItemBefore={}",menuItem);
		
		
		menuItem.setName("Sandwich");
		menuItemService.modifyMenuItem(menuItem);
		
		LOGGER.debug("menuItemAfter={}",menuItemService.getMenuItem(1));
		LOGGER.info("End testEditMenuItem()");
		
	}

	private static void testGetMenuItemListAdmin() {
		LOGGER.info("Inside testGetMenuItemListAdmin()");
		LOGGER.debug("menuItemList={}",menuItemService.getMenuItemListAdmin());
		LOGGER.info("End testGetMenuItemListAdmin()");
		
	}

	private static void testGetMenuItemListCustomer() {
		LOGGER.info("Inside testGetMenuItemListCustomer()");
		LOGGER.debug("menuItemList={}",menuItemService.getMenuItemListCustomer());
		LOGGER.info("End testGetMenuItemListCustomer()");
		
	}

	
	
}
