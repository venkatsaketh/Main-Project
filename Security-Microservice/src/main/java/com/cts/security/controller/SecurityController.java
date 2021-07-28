package com.cts.security.controller;

import com.cts.security.config.JwtTokenUtil;
import com.cts.security.exception.AuthorizationException;
import com.cts.security.model.JwtRequest;
import com.cts.security.model.JwtResponse;
import com.cts.security.service.JwtUserDetailsService;
import io.jsonwebtoken.ExpiredJwtException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping("/auth")
public class SecurityController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtTokenUtil jwtTokenUtil;

    @Autowired
    private JwtUserDetailsService userDetailsService;

    @PostMapping(value = "/authenticate")
    public ResponseEntity<?> createAuthenticationToken(@RequestBody JwtRequest authenticationRequest)
            throws AuthorizationException {
    	System.out.println(authenticationRequest.getUserName());
        authenticate(authenticationRequest.getUserName(), authenticationRequest.getPassword());
        System.out.println(authenticationRequest.getUserName());
        final UserDetails userDetails = userDetailsService.loadUserByUsername(authenticationRequest.getUserName());
        final String token = jwtTokenUtil.generateToken(userDetails);
        return ResponseEntity.ok(new JwtResponse(token));
    }

    private Authentication authenticate(String userName, String password) throws AuthorizationException {
        try {
            return authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(userName, password));
        } catch (DisabledException e) {
            throw new AuthorizationException("USER_DISABLED");
        } catch (BadCredentialsException e) {
            e.printStackTrace();
            throw new AuthorizationException("INVALID_CREDENTIALS");
        }
    }

    @PostMapping("/authorize")
    boolean authorizeRequest(@RequestHeader(value = "Authorization") String requestTokenHeader) {
        String jwtToken;
        Long userId = null;
        System.out.println(requestTokenHeader);
        if (requestTokenHeader != null && requestTokenHeader.startsWith("Bearer ")) {
            jwtToken = requestTokenHeader.substring(7);
            try {
                userId = jwtTokenUtil.getUserIdFromToken(jwtToken);
            } catch (IllegalArgumentException | ExpiredJwtException e) {
                return false;
            }
        }
        return userId != null;
    }

}
