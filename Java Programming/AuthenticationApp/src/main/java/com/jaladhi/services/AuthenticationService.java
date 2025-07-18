package com.jaladhi.services;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.jaladhi.model.LoginRequest;
import com.jaladhi.model.SignupRequest;

@Service
public interface AuthenticationService {

	public ResponseEntity<?> authenticateUser(LoginRequest loginRequest);
	
	public ResponseEntity<?> registerUser(SignupRequest signUpRequest);
	
}
