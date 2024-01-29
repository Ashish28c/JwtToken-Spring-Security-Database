package com.isource.JwtTokenwithDatabase.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.isource.JwtTokenwithDatabase.model.DAOUser;


@Repository
public interface UserDao extends CrudRepository<DAOUser, Integer>{
	DAOUser findByEmailID(String emailID);		
}
