package com.example.demo.controller;

import java.util.Iterator;
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


//import com.example.demo.model.Foodie;
import com.example.demo.model.Users;

//import com.example.demo.dao.FoodieDAO;
import com.example.demo.dao.UsersDAO;


@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/users")
public class UsersController {
	
	@Autowired
	UsersDAO usersDAO;
	
	/*TO SAVE AN Users*/
	@CrossOrigin(origins = "*")
	@PostMapping("/user")
	public Users createFoods( @RequestBody  Users user) {
		return usersDAO.saveAll(user);
	}
	
	/*GET ALL FOODS*/
	@CrossOrigin(origins = "*")
	@GetMapping("/user")
	public List<Users>getallUsers(){
		return usersDAO.findAllById();
	}
	
	/*GET EMPLYEE BY ID*/
	@CrossOrigin(origins = "*")
	@GetMapping("/user/{uid}")
	public ResponseEntity<Users> getUserById(@PathVariable(value="uid")Long id){
		
		Users user = usersDAO.findById(id);
		
		if(user==null) {
			
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok().body(user);
	}
	/*UPDATE AN EMPLOYEE BY id*/
	@CrossOrigin(origins = "*")
	@PutMapping("/user/{id}")
	public ResponseEntity<Users> updateFood(@PathVariable(value="id")Long userid, @RequestBody Users userDetails){
		Users user =  usersDAO.findById(userid);
		if(user==null) {
			
			return ResponseEntity.notFound().build();
		}

		user.setName(userDetails.getName());
		user.setPassword(userDetails.getPassword());
		user.setEmail(userDetails.getEmail());
		user.setPhno(userDetails.getPhno());
		user.setAddress(userDetails.getAddress());
		user.setSecurityquestion(userDetails.getSecurityquestion());
		user.setSecurityanswer(userDetails.getSecurityanswer());
		//user.setZoom(userDetails.getZoom());
		//food.setBreakfast(userDetails.getBreakfast());

		 
		Users updateUser=usersDAO.saveAll(user);
		return ResponseEntity.ok().body(updateUser);
	}
	
	/*DELETE AN EMPLOYEE BY id*/
	@CrossOrigin(origins = "*")
	@DeleteMapping("/user/{id}")
	public ResponseEntity<Users> deleteUser(@PathVariable(value="id")Long id){
		Users user =  usersDAO.findById(id);
		if(user==null) {
			
			return ResponseEntity.notFound().build();
		}
		usersDAO.deleteAll(user);
		
		return ResponseEntity.ok().build();
		
	}
	
	 @PostMapping("/changePassword")
	    public int getFiltered(@Valid @RequestBody Pass pass ) {
		 
		 
//		 System.out.println("uid"+uid);
//		 String password=((Object) obj).password;
		 System.out.println(pass.toString());
        usersDAO.changePassword(pass.getPhno(),pass.getPassword());
		 return 0;
	    }
	 
	 public static class Pass{
		 private Long phno;
		 private String password;
		 public Pass(){}
		@Override
		public String toString() {
			return "Pass [phno=" + phno + ", password=" + password + "]";
		}
		public Long getPhno() {
			return phno;
		}
		public void setPhno(Long phno) {
			this.phno = phno;
		}
		public String getPassword() {
			return password;
		}
		public void setPassword(String password) {
			this.password = password;
		}
	 }



}
