package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.demo.model.Chennai;
import org.springframework.stereotype.Repository;

//import org.springframework.stereotype.Repository;


@SuppressWarnings("unused")
public interface ChennaiRepository extends JpaRepository<Chennai, Long>{

/*	@Query("select c from City c where c.name like %?1")
	List<Chennai> findByNameEndsWith(String chars);
*/

}
