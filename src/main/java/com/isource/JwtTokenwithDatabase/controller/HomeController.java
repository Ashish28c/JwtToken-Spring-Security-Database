package com.isource.JwtTokenwithDatabase.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.isource.JwtTokenwithDatabase.config.JwtTokenUtil;

@RestController
public class HomeController {
	private final String HEADER = "Authorization";
	private final String PREFIX = "Bearer ";
	
	@Autowired
	JwtTokenUtil JwtTokenUtil;
	@RequestMapping("account/checkTokenValidiy")
	public String checkTokenValidity(HttpServletRequest request) {
		String resString ="";
		//Boolean isTokenValidate = JwtTokenUtil.isTokenExpired(request.getHeader(HEADER).replace(PREFIX, ""));
		/*
		 * if(isTokenValidate) {
		 * resString="Token Validity Period is "+JwtTokenUtil.getExpirationDateFromToken
		 * (request.getHeader(HEADER).replace(PREFIX, "")); }else {
		 * resString="Token is Expired  "; }
		 */
		resString="Token Validity Period is "+JwtTokenUtil.getExpirationDateFromToken(request.getHeader(HEADER).replace(PREFIX, ""));
		return resString;
	}
}
