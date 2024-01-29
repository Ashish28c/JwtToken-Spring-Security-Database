package com.isource.JwtTokenwithDatabase.controller;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.isource.JwtTokenwithDatabase.config.JwtTokenUtil;
import com.isource.JwtTokenwithDatabase.dao.CommanDAO;
import com.isource.JwtTokenwithDatabase.dao.TenderDAO;
import com.isource.JwtTokenwithDatabase.dao.TenderDocumentDAO;
import com.isource.JwtTokenwithDatabase.model.TenderDetailDTO;
import com.isource.JwtTokenwithDatabase.model.TenderDocumentDTO;

@RestController
public class TenderController {

	private final String HEADER = "Authorization";
	private final String PREFIX = "Bearer ";
	@Autowired
	JwtTokenUtil JwtTokenUtil;
	
	@Autowired
	TenderDAO tenderdao;
	
	@Autowired
	TenderDocumentDAO tenderDocumentDAO;
	
	@Autowired
	CommanDAO commanDAO;
	
	@RequestMapping(value = { "/tender/getAllTenderDocuments"}, method = RequestMethod.GET)
	public String getAllTenderDocuments(HttpServletRequest request) {
		String jwtToken = request.getHeader(HEADER).replace(PREFIX, "");
		String emailID = JwtTokenUtil.getUsernameFromToken(jwtToken);
		List<TenderDocumentDTO> TenderDocumentDetailsList=tenderDocumentDAO.getTenderDocumentDetails(emailID);
		long userID=commanDAO.getTenderCreatedDate(TenderDocumentDetailsList);
		commanDAO.zipSqlScript(userID);
		commanDAO.uploadDocuments(userID);
		
		return "hello";
	}
	
	@RequestMapping(value = { "/tender/getTenderDocuments/{tenderid}"}, method = RequestMethod.GET)
	public String test(@PathVariable("tenderid") String tenderId) {
		System.out.println(tenderId);
		return "hello";
	}
	
	@RequestMapping(value="/tender/getTenderDetails", produces=MediaType.APPLICATION_JSON_VALUE)
	public Map<String, Object>  getTenderData(HttpServletRequest request) {
		String emailID = JwtTokenUtil.getUsernameFromToken(request.getHeader(HEADER).replace(PREFIX, ""));
		List<TenderDetailDTO> TenderDetailList =tenderdao.getTenderDetails(emailID.trim().toString());
		
		Map<String, Object> result = new HashMap();
		List dataList=new LinkedList();
		long TenderCount =0;
		
		for (TenderDetailDTO TenderDetailLists : TenderDetailList) {
			TenderCount=TenderDetailLists.getTotalTendercnt();
			Map<String, Object> data = new HashMap();
			data.put("TenderID", TenderDetailLists.getTenderId());
			data.put("ReferenceNo", TenderDetailLists.getReferenceNo());
			data.put("RequirementWorkBrief", TenderDetailLists.getRequirementWorkBrief());
			data.put("Description", TenderDetailLists.getTenderDetailWorkDescription());
			data.put("TenderingAutority", TenderDetailLists.getTenderingAutority());
			data.put("PrequalificationCriteria", TenderDetailLists.getPrequalificationCriteria());
			data.put("TenderEstimatedCost", TenderDetailLists.getTenderEstimatedCost());
			data.put("EarnestMoneyDeposite", TenderDetailLists.getEarnestMoneyDeposite());
			data.put("DocumentFees", TenderDetailLists.getDocumentFees());
			data.put("SubmissionEndDate", TenderDetailLists.getSubmissionEndDate());
			data.put("TenderOpeningDate", TenderDetailLists.getTenderOpeningDate());
			data.put("ContactAddress", TenderDetailLists.getContactAddress());
			data.put("ContactPerson", TenderDetailLists.getContactPerson());
			data.put("CurrencyName", TenderDetailLists.getCurrencyName());
			data.put("StartDateOfDocCollection", TenderDetailLists.getStartDateOfDocCollection());
			data.put("LastDateOfDocCollection", TenderDetailLists.getLastDateOfDocCollection());
			data.put("PreBidMeetingDate", TenderDetailLists.getPreBidMeetingDate());
			data.put("Website", TenderDetailLists.getWebsite());
			data.put("Sitelocation", TenderDetailLists.getSitelocation());
			data.put("Keywords", TenderDetailLists.getKeywords());
			data.put("CreatedDate", TenderDetailLists.getCreatedDate());
			dataList.add(data);
		}
		result.put("TotalRecords", TenderCount);
		result.put("Data",  dataList);
		return result;
	}
}
