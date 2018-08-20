package com.example.demo.repository;


import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import com.example.demo.model.Users;

@Repository
@Transactional(readOnly = false)
public class UsersRepositoryImpl implements UsersRepositoryCustom{
	
	
	@PersistenceContext
    EntityManager entityManager;

	@Override
	public int resetPassword(Long uid,String password) {
		Query query = entityManager.createNamedQuery("updateUserPassword", Users.class);
		query.setParameter(1, password);
        query.setParameter(2, uid + "%");
        return query.executeUpdate();
				
	}

}
