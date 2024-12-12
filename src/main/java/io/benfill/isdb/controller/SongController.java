package io.benfill.isdb.controller;

import javax.validation.Valid;

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

import io.benfill.isdb.dto.request.SongDtoReq;
import io.benfill.isdb.dto.response.DeleteResp;
import io.benfill.isdb.service.ISongService;

@RestController
@RequestMapping("/api")
public class SongController {

	@Autowired
	private ISongService service;

	@GetMapping("/user/Songs")
	public ResponseEntity<?> index(@RequestParam(defaultValue = "0", name = "page") Integer page) {
		return ResponseEntity.ok(service.getAll(page));
	}

	@GetMapping("/user/songs/{id}")
	public ResponseEntity<?> show(@PathVariable Long id) {
		return ResponseEntity.ok(service.getDetails(id));
	}

	@PostMapping("/admin/songs")
	public ResponseEntity<?> store(@RequestBody @Valid SongDtoReq dto) {
		return ResponseEntity.status(HttpStatus.CREATED).body(service.create(dto));
	}

	@PutMapping("/admin/songs/{id}")
	public ResponseEntity<?> update(@RequestBody @Valid SongDtoReq dto, @PathVariable Long id) {
		return ResponseEntity.ok(service.update(dto, id));
	}

	@DeleteMapping("/admin/songs")
	public ResponseEntity<?> delete(@PathVariable Long id) {
		service.delete(id);
		return ResponseEntity.ok(DeleteResp.builder().message("Song deleted successfully"));
	}
}
