package com.isource.JwtTokenwithDatabase.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.isource.JwtTokenwithDatabase.model.TenderDocumentDTO;

public interface TenderDocumentDAO extends CrudRepository<TenderDocumentDTO, Integer>{

	@Query(nativeQuery = true,value = "{call web_getTenderDocumentForApi(:emailID)}") 
	 List<TenderDocumentDTO> getTenderDocumentDetails(@Param("emailID") String emailID);
}
