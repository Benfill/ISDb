package io.benfill.isdb.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.benfill.isdb.dto.request.LoginDto;
import io.benfill.isdb.dto.request.UserDtoReq;
import io.benfill.isdb.service.IAuthService;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

	@Autowired
	private IAuthService authService;

	@PostMapping("/register")
	public ResponseEntity<?> register(@RequestBody @Valid UserDtoReq user) {
		return ResponseEntity.ok(authService.registerHandler(user));
	}

	@PostMapping("/login")
	public ResponseEntity<?> login(@RequestBody @Valid LoginDto body) {
		return ResponseEntity.ok(authService.loginHandler(body));
	}

}