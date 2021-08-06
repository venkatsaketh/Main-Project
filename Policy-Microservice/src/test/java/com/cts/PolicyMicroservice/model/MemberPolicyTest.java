package com.cts.PolicyMicroservice.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.Date;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@ContextConfiguration
public class MemberPolicyTest 
{

	MemberPolicy mp = new MemberPolicy();
	
	 @Test
	 public void testNoArgConst()
	 {
		 assertNotNull(mp);
	 }
	 
	 @Test
	 public void testAllArgConst()
	 {
		 MemberPolicy x = new MemberPolicy(1,1,2,new Date(),12,"asd",10000);
		 assertEquals(1,x.getMp_id());
		 assertEquals(2,x.getM_id());
	 }
	 
	 @Test 
	 public void testGetterSetterForId()
	 {
		 mp.setMp_id(1);
		 assertEquals(1,mp.getMp_id());
	 }
	 
	 @Test
	 public void testGetterSetterForMId()
	 {
		 mp.setM_id(2);
		 assertEquals(2,mp.getM_id());
	 }
	 
	 @Test
	 public void testGetterSetterForPId()
	 {
		 mp.setP_id(3);
		 assertEquals(3,mp.getP_id());
	 }
	 
	 @Test
	 public void testGetterSetterForDate()
	 {
		 Date x = new Date("14/12/1999");
		 mp.setSub_date(x);
		 assertEquals(x,mp.getSub_date());
	 }
	 
	 @Test
	public void testGetterSetterForBenefits()
	{
		mp.setBenefits("asd");
		assertEquals("asd",mp.getBenefits());
	}
	 
	 @Test
	public void testGetterSetterForTenure()
	{
		mp.setTenure(12);
		assertEquals(12,mp.getTenure());
	}
	 
	 
	 @Test
	 public void testGetterSetterForAmount()
	 {
		 mp.setAmount_for_benifits(1000);
		 assertEquals(1000,mp.getAmount_for_benifits());
	 }
}
