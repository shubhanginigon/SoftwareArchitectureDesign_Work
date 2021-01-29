package com.example.demo.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import com.example.demo.model.User;

public interface UserDao extends CrudRepository<User, Integer> {
	List<User> findByNationality(String nationality);
	List<User> findByUidGreaterThan(int uid);
	
	@Query("from User where nationality = ?1 order by name")
	List<User> findByNationalitySorted(String nationality);
}
