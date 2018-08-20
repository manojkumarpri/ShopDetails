package com.example.demo.repository;

import java.util.List;

import org.json.JSONObject;

import com.example.demo.model.Users;

public interface UsersRepositoryCustom {
	
	int resetPassword(Long id,String password);

}
