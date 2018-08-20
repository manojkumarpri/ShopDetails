package com.example.demo.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;


//import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.example.demo.model.Chennai;
import com.example.demo.repository.ChennaiRepository;
//import com.project.springrestapidemo.model.Employee;

@Service
public class ChennaiDAO {
	@Autowired
	ChennaiRepository chennaiRepository;
	
	public List<Chennai> findAllById(){
		return chennaiRepository.findAll();
	}
	 
	   /* public List<Chennai> findByNameEndsWith(String name) {

	        List<Chennai> names = (List<Chennai>) chennaiRepository.findByNameEndsWith(name);
	        return names;
	    }*/
	public List<Chennai> saveAll(Chennai product) {
		 chennaiRepository.save(product);
		 return chennaiRepository.findAll();
	}
	
	public Chennai findById(Long id) {
		return chennaiRepository.findById(id).orElse(null);
}
	
	public void deleteAll(Chennai product) {
		chennaiRepository.delete(product);
	}
	

}
