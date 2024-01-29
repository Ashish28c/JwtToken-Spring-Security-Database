package com.isource.JwtTokenwithDatabase.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.isource.JwtTokenwithDatabase.model.TenderDetailDTO;

@Component
@Transactional
public interface TenderDAO  extends CrudRepository<TenderDetailDTO, Integer>{

	
	 @Query(nativeQuery = true,value = "{call web_getTenderDataForApi(:emailID)}") 
	 List<TenderDetailDTO> getTenderDetails(@Param("emailID") String emailID);
		 
}
