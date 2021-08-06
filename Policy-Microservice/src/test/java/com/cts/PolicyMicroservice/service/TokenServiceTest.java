package com.cts.PolicyMicroservice.service;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import com.cts.PolicyMicroservice.feign.Auth;


@RunWith(SpringRunner.class)
@ContextConfiguration
public class TokenServiceTest 
{
	@Mock
	private Auth authorizationClient;
	
	@InjectMocks
	private TokenService  tk;
	
	@Test
	public void testGetValidity()
	{
		when(authorizationClient.authorizeRequest("token")).thenReturn(true);
		assertEquals(true,tk.getValidity("token"));
	}
	
	@Test
	public void testGetValidityIfFalse()
	{
		when(authorizationClient.authorizeRequest("token")).thenReturn(false);
		assertEquals(false,tk.getValidity("token"));
	}
}
