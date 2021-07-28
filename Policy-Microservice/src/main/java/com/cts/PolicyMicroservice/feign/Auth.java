package com.cts.PolicyMicroservice.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;

@FeignClient(url="http://localhost:8081/auth",name="Authorization")
public interface Auth 
{
	@PostMapping("/authorize")
    boolean authorizeRequest(@RequestHeader(value = "Authorization") String requestTokenHeader);
}
