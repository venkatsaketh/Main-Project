package com.cts.PolicyMicroservice;

import static org.junit.Assert.assertNotNull;

import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class PolicyMicroserviceApplicationTests {

	
	@Mock
	PolicyMicroserviceApplication  app;
	@Test
	void contextLoads() 
	{
		assertNotNull(app);
	}

}
