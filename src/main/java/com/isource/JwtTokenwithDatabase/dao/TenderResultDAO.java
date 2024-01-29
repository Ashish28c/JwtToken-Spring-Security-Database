package com.isource.JwtTokenwithDatabase.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.isource.JwtTokenwithDatabase.model.TenderResultDetailDTO;

public interface TenderResultDAO extends CrudRepository<TenderResultDetailDTO, Integer>{

	 @Query(nativeQuery = true,value = "{call web_getTenderResultDetailForApi(:emailID)}") 
	 List<TenderResultDetailDTO> getTenderResultDetails(@Param("emailID") String emailID);
}
