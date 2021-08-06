package com.cts.PolicyMicroservice.model;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.Test;

public class PolicyTest 
{

	Policy p = new Policy();
	
	@Test
	public void testNoArgConst()
	{
		assertNotNull(p);
	}
	
	@Test 
	public void testAllArgConst()
	{
		Policy py = new Policy(1,"ag",50000,12);
		assertEquals(1,py.getP_id());
	}
	
	@Test
	public void testGetterSetterForId()
	{
		p.setP_id(2);
		assertEquals(2,p.getP_id());
	}
	
	@Test
	public void testGetterSetterForBenefits()
	{
		p.setBenefits("asd");
		assertEquals("asd",p.getBenefits());
	}
	
	@Test
	public void testGetterSetterForPremium()
	{
		p.setPremium(200);
		assertEquals(200,p.getPremium());
	}
	
	@Test
	public void testGetterSetterForTenure()
	{
		p.setTenure(12);
		assertEquals(12,p.getTenure());
	}
	
	@Test
	public void testGetterSetterForProvider()
	{
		p.setProviderList(null);;
		assertNull(p.getProviderList());
	}
	
}
