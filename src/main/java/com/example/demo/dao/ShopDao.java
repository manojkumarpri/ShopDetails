package com.example.demo.dao;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Shop;
import com.example.demo.repository.ShopRepository;

@Service
public class ShopDao {

	@Autowired
	ShopRepository shopRepository;
	
	/* To save Employee*/
	
	public Shop saveAll(Shop shp) {
		return shopRepository.save(shp);
	}
	
	/*Search all Employee*/
	
	public List<Shop> findAllById(){
		return shopRepository.findAll();
	}
	
	/*Get an Employee By id */
	
	public Shop findById(Long shp1id) {
		return shopRepository.findById(shp1id).orElse(null);
}

	/*Delete an Employee*/

	public void deleteAll(Shop shp1) {
		shopRepository.delete(shp1);
	}
}
