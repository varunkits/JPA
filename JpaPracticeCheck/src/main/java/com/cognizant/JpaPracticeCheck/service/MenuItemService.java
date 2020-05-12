package com.cognizant.JpaPracticeCheck.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cognizant.JpaPracticeCheck.entity.MenuItem;
import com.cognizant.JpaPracticeCheck.repository.MenuItemRepository;

@Service
@Transactional
public class MenuItemService {

	@Autowired
	private MenuItemRepository menuItemRepository;
	
	@Transactional
	public List<MenuItem> getMenuItemListAdmin()
	{
		return menuItemRepository.findAll();
	}
	
	@Transactional
	public List<MenuItem> getMenuItemListCustomer()
	{
		return menuItemRepository.findMenuItemListCustomer();
	}
	
	@Transactional
	public MenuItem getMenuItem(int id)
	{
		return menuItemRepository.findById(id).get();
	}
	
	@Transactional
	public void modifyMenuItem(MenuItem menuItem)
	{
		menuItemRepository.save(menuItem);
	}
}
