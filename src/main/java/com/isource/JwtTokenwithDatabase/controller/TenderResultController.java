package com.isource.JwtTokenwithDatabase.controller;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.isource.JwtTokenwithDatabase.config.JwtTokenUtil;
import com.isource.JwtTokenwithDatabase.dao.TenderResultDAO;
import com.isource.JwtTokenwithDatabase.model.TenderDetailDTO;
import com.isource.JwtTokenwithDatabase.model.TenderResultDetailDTO;

@RestController
public class TenderResultController {

	private final String HEADER = "Authorization";
	private final String PREFIX = "Bearer ";
	
	@Autowired
	JwtTokenUtil JwtTokenUtil;
	
	@Autowired
	TenderResultDAO tenderResultdao;

	@RequestMapping(value="/tenderResult/getTenderResultDetails", produces=MediaType.APPLICATION_JSON_VALUE)
	public Map<String, Object>  getTenderResultDetails(HttpServletRequest request) {
		String jwtToken = request.getHeader(HEADER).replace(PREFIX, "");
		String emailID = JwtTokenUtil.getUsernameFromToken(jwtToken);
		System.out.println(emailID);
		List<TenderResultDetailDTO> TenderResultDetailList =tenderResultdao.getTenderResultDetails(emailID.trim().toString());
		
		Map<String, Object> json = new HashMap();
		List a=new LinkedList();
		long TenderCount =0;
		
		for (TenderResultDetailDTO TenderResultDetailLists : TenderResultDetailList) {
			
			  TenderCount=TenderResultDetailLists.getTenderResultCount(); 
			  Map<String, Object> json1 = new HashMap();
			  json1.put("TenderResultId", TenderResultDetailLists.getTenderResultId()); 
			  json1.put("ReferenceNo", TenderResultDetailLists.getReferenceNo()); 
			  json1.put("TenderingAutority", TenderResultDetailLists.getTenderingAutority()); 
			  json1.put("RequirementWorkBrief", TenderResultDetailLists.getRequirementWorkBrief()); 
			  json1.put("webSite", TenderResultDetailLists.getWebsite());
			  
			  json1.put("sitelocation", TenderResultDetailLists.getSitelocation()); 
			  
			  json1.put("qualifiedBidder", TenderResultDetailLists.getQualifiedBidder()); 
			  json1.put("SubmissionEndDate",TenderResultDetailLists.getSubmissionEndDate());
			  
			  json1.put("contractValue", TenderResultDetailLists.getContractValue()); 
			  json1.put("ContractDate", TenderResultDetailLists.getContractDate());
			  json1.put("endSubmissionDate", TenderResultDetailLists.getEndSubmissionDate()); 
			  
			  json1.put("contractValue",TenderResultDetailLists.getContractValue()); 
			  json1.put("CurrencyName", TenderResultDetailLists.getCurrencyName()); 
			  
			  json1.put("contractorName", TenderResultDetailLists.getCurrencyName());
			  
			  json1.put("contractorPhoneNo", TenderResultDetailLists.getContractorPhoneNo());
			  json1.put("contractorEmailId", TenderResultDetailLists.getContractorEmailId());
			  json1.put("Keywords", TenderResultDetailLists.getKeywords());			 
			a.add(json1);
		}
		json.put("TotalRecords", TenderCount);
	    json.put("Data",  a);
		return json;
	}
}
