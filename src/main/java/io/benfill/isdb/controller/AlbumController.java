package io.benfill.isdb.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
	public ResponseEntity<?> index(@RequestParam(defaultValue = "0", name = "page") Integer page) {
		return ResponseEntity.ok(service.getAll(page));
	}

	@GetMapping("/user/albums/{id}")
	public ResponseEntity<?> show(@PathVariable Long id) {
		return ResponseEntity.ok(service.getById(id));
	}

	@PostMapping("/admin/albums")
	public ResponseEntity<?> store(@RequestBody AlbumDtoReq dto) {
		return ResponseEntity.status(HttpStatus.CREATED).body(service.create(dto));
	}

	@PutMapping("/admin/albums/{id}")
	public ResponseEntity<?> update(@RequestBody AlbumDtoReq dto, @PathVariable Long id) {
		return ResponseEntity.ok(service.update(dto, id));
	}

	@DeleteMapping("/admin/albums")
	public ResponseEntity<?> delete(@PathVariable Long id) {
		service.delete(id);
		return ResponseEntity.ok(DeleteResp.builder().message("Album deleted successfully"));
	}
}
