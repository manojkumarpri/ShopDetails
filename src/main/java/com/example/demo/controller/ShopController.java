package com.example.demo.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dao.ShopDao;
import com.example.demo.model.Shop;
@CrossOrigin(origins="*")
@RestController
@RequestMapping("/commerce")
public class ShopController {

	@Autowired
	ShopDao shopDao;
	
	/*TO SAVE AN EMPLYEE*/
	@PostMapping("/shope")
	public Shop createShop(@Valid @RequestBody  Shop shp) {
		return shopDao.saveAll(shp);
	}
	
	/*GET ALL EMPLYEE*/
	@GetMapping("/shope")
	public List<Shop>getallShop(){
		return shopDao.findAllById();
	}
	
	/*GET EMPLYEE BY EMPLID*/
	@GetMapping("/shope/{id}")
	public ResponseEntity<Shop> getEmployeeById(@PathVariable(value="id")Long shpid){
		
	Shop shp1 = shopDao.findById(shpid);
		
		if(shp1==null) {
			
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok().body(shp1);
	}
	/*UPDATE AN EMPLOYEE BY shpid*/
	@PutMapping("/shope/{id}")
	public ResponseEntity<Shop> updateEmployee(@PathVariable(value="id")Long shp1id,@Valid @RequestBody Shop shpDetails){
		Shop shp1 =  shopDao.findById(shp1id);
		if(shp1==null) {
			
			return ResponseEntity.notFound().build();
		}

		shp1.setShopname(shpDetails.getShopname());
		shp1.setContactno(shpDetails.getContactno());
		shp1.setAddress(shpDetails.getAddress());
		shp1.setLatitude(shpDetails.getLatitude());
		shp1.setLongitude(shpDetails.getLongitude());
		shp1.setEmail(shpDetails.getEmail());
		shp1.setUrl(shpDetails.getUrl());
		shp1.setUrl1(shpDetails.getUrl1());


		 
		Shop updateEmployee=shopDao.saveAll(shp1);
		return ResponseEntity.ok().body(updateEmployee);
	}
	
	/*DELETE AN EMPLOYEE BY shp1id*/
	@DeleteMapping("/shope/{id}")
	public ResponseEntity<Shop> deleteEmployee(@PathVariable(value="id")Long shp1id){
		Shop shp1 =  shopDao.findById(shp1id);
		if(shp1==null) {
			
			return ResponseEntity.notFound().build();
		}
		shopDao.deleteAll(shp1);
		
		return ResponseEntity.ok().build();
		
	}
	
}

