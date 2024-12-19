package io.benfill.isdb.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import io.benfill.isdb.service.impl.UserService;

@RestController
@RequestMapping("/api/admin/users")
public class UserController {

	@Autowired
	private UserService userService;

	@Secured("ADMIN")
	@GetMapping
	public ResponseEntity<?> index(@RequestParam(defaultValue = "0", name = "page") Integer page) {
		return ResponseEntity.ok(userService.getAll(page));
	}

}
