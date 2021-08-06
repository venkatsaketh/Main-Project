package com.cts.PolicyMicroservice.model;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.Test;

public class MemberTest 
{
   Member m = new Member();
   
   @Test
   public void testGetterSetterForId()
   {
	 m.setMemberId(3);
	 assertEquals(3,m.getMemberId());
   }
   
   @Test
   public void testGetterSetterForFirstName()
   {
	   m.setFirstName("tony");
	   assertEquals("tony",m.getFirstName());
   }
   
   @Test
   public void testGetterSetterForLastName()
   {
	   m.setLastName("Stark");
	   assertEquals("Stark",m.getLastName());
    }
   
   @Test
   public void testGetterSetterForAge()
   {
	   m.setAge(21);
	   assertEquals(21,m.getAge());
   }
   
   @Test
   public void testGetterSetterForGender()
   {
	   m.setGender("Male");
	   assertEquals("Male",m.getGender());
   }
   
   @Test
   public void testGetterSetterForAddress()
   {
	   m.setAddress("Manhattan");
	   assertEquals("Manhattan",m.getAddress());
   }
}
