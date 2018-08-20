package com.example.demo.dao;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;


//import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Users;
//import com.example.demo.repository.FoodieRepository;
import com.example.demo.repository.UsersRepository;

@Service
public class UsersDAO {
	
	@Autowired
	UsersRepository usersRepository;
	
	public List<Users> findAllById(){
		return usersRepository.findAll();
	}
	
	public Users saveAll(Users user) {
		return usersRepository.save(user);
	}
	
	public Users findById(Long id) {
		return usersRepository.findById(id).orElse(null);
}
	
	public void deleteAll(Users user) {
		usersRepository.delete(user);
	}
	
	public int changePassword(Long uid,String password) {
		return usersRepository.resetPassword(uid,password);


}
}