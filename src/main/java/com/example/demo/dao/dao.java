package com.example.demo.dao;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.model;
import com.example.demo.repository.repository;

@Service
public class dao {

	@Autowired
	repository shopRepository;
	
	/* To save Employee*/
	
	public model saveAll(model shp) {
		return shopRepository.save(shp);
	}
	
	/*Search all Employee*/
	
	public List<model> findAllById(){
		return shopRepository.findAll();
	}
	
	/*Get an Employee By id */
	
	public model findById(Long shp1id) {
		return shopRepository.findById(shp1id).orElse(null);
}

	/*Delete an Employee*/

	public void deleteAll(model shp1) {
		shopRepository.delete(shp1);
	}
}
