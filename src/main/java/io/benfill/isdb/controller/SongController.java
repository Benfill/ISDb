package io.benfill.isdb.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import io.benfill.isdb.dto.request.SongDtoReq;
import io.benfill.isdb.dto.response.DeleteResp;
import io.benfill.isdb.service.ISongService;

@RestController
@RequestMapping("/api")
public class SongController {

	@Autowired
	private ISongService service;

	@GetMapping("/user/songs")
	@PreAuthorize("hasAuthority('ROLE_USER')")
	public ResponseEntity<?> index(@RequestParam(defaultValue = "0", name = "page") Integer page) {
		return ResponseEntity.ok(service.getAll(page));
	}

	@GetMapping("/user/songs/{id}")
	@PreAuthorize("hasAuthority('ROLE_USER')")
	public ResponseEntity<?> show(@PathVariable String id) {
		return ResponseEntity.ok(service.getDetails(id));
	}

	@PostMapping("/admin/songs")
	@PreAuthorize("hasAuthority('ROLE_ADMIN')")
	public ResponseEntity<?> store(@RequestBody @Valid SongDtoReq dto) {
		return ResponseEntity.status(HttpStatus.CREATED).body(service.create(dto));
	}

	@PutMapping("/admin/songs/{id}")
	@PreAuthorize("hasAuthority('ROLE_ADMIN')")
	public ResponseEntity<?> update(@RequestBody @Valid SongDtoReq dto, @PathVariable String id) {
		return ResponseEntity.ok(service.update(dto, id));
	}

	@DeleteMapping("/admin/songs")
	@PreAuthorize("hasAuthority('ROLE_ADMIN')")
	public ResponseEntity<?> delete(@PathVariable String id) {
		service.delete(id);
		return ResponseEntity.ok(DeleteResp.builder().message("Song deleted successfully"));
	}

	@GetMapping("/user/songs/search")
	@PreAuthorize("hasAuthority('ROLE_USER')")
	public ResponseEntity<?> searchBy(@RequestParam(name = "q") String query,
			@RequestParam(defaultValue = "0", name = "page") Integer page) {
		return ResponseEntity.ok(service.search(query, page));
	}
}
