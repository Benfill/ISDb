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

import io.benfill.isdb.dto.request.AlbumDtoReq;
import io.benfill.isdb.dto.response.DeleteResp;
import io.benfill.isdb.service.IAlbumService;

@RestController
@RequestMapping("/api")
public class AlbumController {
	@Autowired
	private IAlbumService service;

	@GetMapping("/user/albums")
	@PreAuthorize("hasAuthority('ROLE_USER')")
	public ResponseEntity<?> index(@RequestParam(defaultValue = "0", name = "page") Integer page) {
		return ResponseEntity.ok(service.getAll(page));
	}

	@GetMapping("/user/albums/{id}")
	@PreAuthorize("hasAuthority('ROLE_USER')")
	public ResponseEntity<?> show(@PathVariable String id) {
		return ResponseEntity.ok(service.getDetails(id));
	}

	@PostMapping("/admin/albums")
	@PreAuthorize("hasAuthority('ROLE_ADMIN')")
	public ResponseEntity<?> store(@RequestBody @Valid AlbumDtoReq dto) {
		return ResponseEntity.status(HttpStatus.CREATED).body(service.create(dto));
	}

	@PutMapping("/admin/albums/{id}")
	@PreAuthorize("hasAuthority('ROLE_ADMIN')")
	public ResponseEntity<?> update(@RequestBody @Valid AlbumDtoReq dto, @PathVariable String id) {
		return ResponseEntity.ok(service.update(dto, id));
	}

	@DeleteMapping("/admin/albums")
	@PreAuthorize("hasAuthority('ROLE_ADMIN')")
	public ResponseEntity<?> delete(@PathVariable String id) {
		service.delete(id);
		return ResponseEntity.ok(DeleteResp.builder().message("Album deleted successfully"));
	}

	@GetMapping("/user/albums/search")
	@PreAuthorize("hasAuthority('ROLE_USER')")
	public ResponseEntity<?> searchBy(@RequestParam(name = "q") String query,
			@RequestParam(defaultValue = "title", name = "type") String type,
			@RequestParam(defaultValue = "0", name = "page") Integer page) {
		return ResponseEntity.ok(service.search(query, type, page));
	}

	@GetMapping("/user/albums/sort")
	@PreAuthorize("hasAuthority('ROLE_USER')")
	public ResponseEntity<?> sortByYear(@RequestParam(name = "year") Integer year,
			@RequestParam(defaultValue = "0", name = "page") Integer page) {
		return ResponseEntity.ok(service.sort(year, page));
	}

}
