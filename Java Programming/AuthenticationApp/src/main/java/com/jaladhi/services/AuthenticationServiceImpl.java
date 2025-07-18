package com.jaladhi.services;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import com.jaladhi.entity.Role;
import com.jaladhi.entity.User;
import com.jaladhi.model.LoginRequest;
import com.jaladhi.model.SignupRequest;
import com.jaladhi.model.JwtResponse;
import com.jaladhi.model.MessageResponse;
import com.jaladhi.repository.RoleRepository;
import com.jaladhi.repository.UserRepository;
import com.jaladhi.security.jwt.JwtUtils;
import com.jaladhi.security.services.UserDetailsImpl;
import com.jaladhi.util.Constants;
import com.jaladhi.util.RoleConstants;

@Service
public class AuthenticationServiceImpl implements AuthenticationService {	

	@Autowired
	JwtUtils jwtUtils;
	
	@Autowired
	PasswordEncoder encoder;
	
	@Autowired
	RoleRepository roleRepository;

	@Autowired
	UserRepository userRepository;
	
	@Autowired
	AuthenticationManager authenticationManager;

	@Override
	public ResponseEntity<?> authenticateUser(LoginRequest loginRequest) {
		
		Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(loginRequest.getUsername(), loginRequest.getPassword()));
		SecurityContextHolder.getContext().setAuthentication(authentication);
		String jwt = jwtUtils.generateJwtToken(authentication);
		UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();		
		List<String> roles = userDetails.getAuthorities().stream().map(item -> item.getAuthority()).collect(Collectors.toList());
		return ResponseEntity.ok(new JwtResponse(jwt, userDetails.getId(), userDetails.getUsername(), userDetails.getEmail(), roles));
	}

	@Override
	public ResponseEntity<?> registerUser(SignupRequest signUpRequest) {
		boolean userName = userRepository.existsByUsername(signUpRequest.getUsername());
		boolean email = userRepository.existsByEmail(signUpRequest.getEmail());
		if (userName) {
			return ResponseEntity.badRequest().body(new MessageResponse(Constants.USERNAME_ALREADY_TAKEN));
		} else if (email) {
			return ResponseEntity.badRequest().body(new MessageResponse(Constants.EMAIL_ALREADY_TAKEN));
		}
		User user = new User(signUpRequest.getUsername(), signUpRequest.getEmail(), encoder.encode(signUpRequest.getPassword()));
		Set<String> strRoles = signUpRequest.getRole();
		Set<Role> roles = new HashSet<>();
		checkRole(strRoles, roles);
		user.setRoles(roles);
		userRepository.save(user);
		return ResponseEntity.ok(new MessageResponse(Constants.SUCCESS_MESSAGE));
		
	}

	private void checkRole(Set<String> strRoles, Set<Role> roles) {
		if (strRoles == null) {
			Role userRole = roleRepository.findByName(RoleConstants.ROLE_USER).orElseThrow(() -> new RuntimeException(Constants.ROLE_NOT_FOUND));
			roles.add(userRole);
		} else {
			strRoles.forEach(role -> {
				switch (role) {
				case Constants.ADMIN:
					Role adminRole = roleRepository.findByName(RoleConstants.ROLE_ADMIN).orElseThrow(() -> new RuntimeException(Constants.ROLE_NOT_FOUND));
					roles.add(adminRole);
					break;
				case Constants.MOD:
					Role modRole = roleRepository.findByName(RoleConstants.ROLE_MODERATOR).orElseThrow(() -> new RuntimeException(Constants.ROLE_NOT_FOUND));
					roles.add(modRole);
					break;
				default:
					Role userRole = roleRepository.findByName(RoleConstants.ROLE_USER).orElseThrow(() -> new RuntimeException(Constants.ROLE_NOT_FOUND));
					roles.add(userRole);
				}
			});
		}
	}
	
}
