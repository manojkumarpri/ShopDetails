package com.example.demo.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


import com.example.demo.model.Chennai;
import com.example.demo.dao.ChennaiDAO;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/textile")
public class ChennaiController {
	
	@Autowired
	ChennaiDAO productDao;
	
	/*TO SAVE AN product*/
	/*@GetMapping("/Product")
	public List<Chennai> getProduct() {
		
		 return productDao.findAllById();
	}*/
	
	@PostMapping("/Chennai")
	public List<Chennai> createProduct(@Valid @RequestBody  Chennai prod) {
		 productDao.saveAll(prod);
		 return productDao.findAllById();
	}
	
	/*GET ALL products*/
	/*@GetMapping("/showNamesEnding")
    public String findCitiesNameEndsWith(Model model, @RequestParam String name) {
        
        List<Chennai> names = (List<Chennai>) productDao.findByNameEndsWith(name);
        
        model.addAttribute("names", names);
        
        return "showCities";
	}
	*/
	@GetMapping("/Chennai")
	public List<Chennai>getallFoods(){
		return productDao.findAllById();
	}
	
	/*GET product BY ID*/
	
	@GetMapping("/Chennai/{id}")
	public ResponseEntity<Chennai> getProductById(@PathVariable(value="id")Long id){
		
		Chennai prod = productDao.findById(id);
		
		if(prod==null) {
			
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok().body(prod);
	}
	/*UPDATE AN product BY productid*/

	@PutMapping("/Chennai/{id}")
	public ResponseEntity<List<Chennai>> updateProduct(@PathVariable(value="id")Long prodid,@Valid @RequestBody Chennai prodDetails){
		Chennai prod =  productDao.findById(prodid);
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
		
		prod.setBrandName(prodDetails.getBrandName());
		prod.setSku(prodDetails.getSku());
		prod.setDiscount(prodDetails.getDiscount());
		prod.setPrice(prodDetails.getPrice());
		prod.setTax(prodDetails.getTax());
		prod.setProdId(prodDetails.getProdId());
		prod.setRating(prodDetails.getRating());
		prod.setTotal(prodDetails.getTotal());
		prod.setShopName(prodDetails.getShopName());
		prod.setAvailable(prodDetails.getAvailable());
		
		//food.setBreakfast(foodDetails.getBreakfast());

		 
		List<Chennai> updateProduct=productDao.saveAll(prod);
		return ResponseEntity.ok().body(updateProduct);
	}
	
	/*DELETE AN product BY productid*/
	
	@DeleteMapping("/Chennai/{id}")
	public ResponseEntity<Chennai> deleteProduct(@PathVariable(value="id")Long id){
		Chennai prod =  productDao.findById(id);
		if(prod==null) {
			
			return ResponseEntity.notFound().build();
		}
		productDao.deleteAll(prod);
		
		return ResponseEntity.ok().build();
		
	}


}
