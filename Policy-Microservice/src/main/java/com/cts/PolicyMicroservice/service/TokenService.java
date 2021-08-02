package com.cts.PolicyMicroservice.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cts.PolicyMicroservice.feign.Auth;

@Service
public class TokenService 
{

	@Autowired
	private Auth authorizationClient;
	
	public boolean getValidity(String token)
	{
		return authorizationClient.authorizeRequest(token);
	}
}
