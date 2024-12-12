package io.benfill.isdb.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import io.benfill.isdb.dto.request.SongDtoReq;
import io.benfill.isdb.dto.response.SongDtoResp;
import io.benfill.isdb.exception.ResourceNotFoundException;
import io.benfill.isdb.mapper.SongMapper;
import io.benfill.isdb.model.Song;
import io.benfill.isdb.repository.SongRepository;
import io.benfill.isdb.service.ISongService;

@Service
public class SongService implements ISongService {

	@Autowired
	private SongRepository repository;
	private SongMapper mapper;

	@Override
	public Song getById(Long id) {
		return repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Song not found"));
	}

	@Override
	public List<SongDtoResp> getAll(Integer page) {
		int size = 3;
		Pageable pageable = PageRequest.of(page, size);
		List<Song> songs = repository.findAll(pageable).getContent();
		return mapper.entitiesToDtos(songs);
	}

	@Override
	public SongDtoResp getDetails(Long id) {
		return mapper.entityToDto(getById(id));
	}

	@Override
	public SongDtoResp create(SongDtoReq dto) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public SongDtoResp update(SongDtoReq dto, Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(Long id) {
		// TODO Auto-generated method stub

	}

	@Override
	public List<SongDtoResp> search(String query, Integer page) {
		if (query == null || query.trim().isEmpty()) {
			throw new IllegalArgumentException("Search query cannot be null or empty");
		}
		int size = 3;
		Pageable pageable = PageRequest.of(page, size);
		List<Song> songs = repository.findByTitleLike("%" + query + "%", pageable);
		return mapper.entitiesToDtos(songs);
	}

}
