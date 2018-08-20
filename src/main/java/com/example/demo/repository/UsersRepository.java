package com.example.demo.repository;


import org.springframework.data.jpa.repository.JpaRepository;

//import com.example.demo.model.Foodie;
import com.example.demo.model.Users;
import org.springframework.stereotype.Repository;


@SuppressWarnings("unused")
public interface UsersRepository extends JpaRepository<Users, Long>,UsersRepositoryCustom{

}
