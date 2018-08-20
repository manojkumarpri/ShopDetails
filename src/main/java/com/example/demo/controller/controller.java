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

import com.example.demo.dao.dao;
import com.example.demo.model.model;
@CrossOrigin(origins="*")
@RestController
@RequestMapping("/cart")
public class controller {

	@Autowired
	dao dao;
	
	/*TO SAVE AN EMPLYEE*/
	@CrossOrigin(origins="*")
	@PostMapping("/create")
	public model createShop(@Valid @RequestBody  model shp) {
		return dao.saveAll(shp);
	}
	
	/*GET ALL EMPLYEE*/
	@GetMapping("/show")
	public List<model>getallShop(){
		return dao.findAllById();
	}
	
	/*GET EMPLYEE BY EMPLID*/
	@GetMapping("/show/{id}")
	public ResponseEntity<model> getEmployeeById(@PathVariable(value="id")Long shpid){
		
	model shp1 = dao.findById(shpid);
		
		if(shp1==null) {
			
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok().body(shp1);
	}
	/*UPDATE AN EMPLOYEE BY shpid*/
	@PutMapping("/create/{id}")
	public ResponseEntity<List<model>> updateProduct(@PathVariable(value="id")Long prodid,@Valid @RequestBody model prodDetails){
		model prod =  dao.findById(prodid);
		if(prod==null) {
			
			return ResponseEntity.notFound().build();
		}

		prod.setName(prodDetails.getName());
		prod.setImg(prodDetails.getImg());
		prod.setProdCategory(prodDetails.getProdCategory());
		prod.setShopCategory(prodDetails.getShopCategory());
		prod.setShortDesc(prodDetails.getShortDesc());
		prod.setLongDesc(prodDetails.getLongDesc());
		prod.setSize(prodDetails.getSize());
		prod.setQuantity(prodDetails.getQuantity());
		prod.setBrandName(prodDetails.getBrandName());
		prod.setSku(prodDetails.getSku());
		prod.setDiscount(prodDetails.getDiscount());
		prod.setPrice(prodDetails.getPrice());
		prod.setTax(prodDetails.getTax());
		prod.setProdId(prodDetails.getProdId());
		prod.setRating(prodDetails.getRating());
		prod.setTotal(prodDetails.getTotal());
		prod.setShopName(prodDetails.getShopName());
		prod.setCust_id(prodDetails.getCust_id());

		
		List<model> updateProduct=(List<model>) dao.saveAll(prod);
		return ResponseEntity.ok().body(updateProduct);
	}
	/*DELETE AN EMPLOYEE BY shp1id*/
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<model> deleteEmployee(@PathVariable(value="id")Long shp1id){
		model shp1 =  dao.findById(shp1id);
		if(shp1==null) {
			
			return ResponseEntity.notFound().build();
		}
		dao.deleteAll(shp1);
		
		return ResponseEntity.ok().build();
		
	}
	
}

