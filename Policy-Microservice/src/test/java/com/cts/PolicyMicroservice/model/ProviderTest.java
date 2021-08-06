package com.cts.PolicyMicroservice.model;

import static org.junit.Assert.assertNull;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.Test;

public class ProviderTest 
{

	 Provider pr = new Provider();
	 
	 @Test
	 public void testGetterSetterForId()
	 {
		 pr.setPr_id(1);
		 assertEquals(1,pr.getPr_id());
	 }
	 
	 @Test
	 public void testGetterSetterForName()
	 {
		 pr.setName("Rainbow");
		 assertEquals("Rainbow",pr.getName());
	 }
	 
	 @Test
	 public void testGetterSetterForLocation()
	 {
		 pr.setLocation("Hyd");
		 assertEquals("Hyd",pr.getLocation());
	 }
	 
	 @Test
	 public void testGetterSetterForPolicy()
	 {
		 pr.setPolicyList(null);
		 assertNull(pr.getPolicyList());
	 }
}
