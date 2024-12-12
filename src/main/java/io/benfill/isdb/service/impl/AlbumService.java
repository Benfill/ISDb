package io.benfill.isdb.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import io.benfill.isdb.dto.request.AlbumDtoReq;
import io.benfill.isdb.dto.response.AlbumDtoResp;
import io.benfill.isdb.exception.ResourceNotFoundException;
import io.benfill.isdb.exception.SearchTypeException;
import io.benfill.isdb.mapper.AlbumMapper;
import io.benfill.isdb.model.Album;
import io.benfill.isdb.repository.AlbumRepository;
import io.benfill.isdb.service.IAlbumService;

@Service
public class AlbumService implements IAlbumService {

	@Autowired
	private AlbumRepository repository;

	@Autowired
	private AlbumMapper mapper;

	@Override
	public Album getById(long id) {
		return repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Album not found"));
	}

	@Override
	public List<AlbumDtoResp> getAll(Integer page) {
		int size = 3;
		Pageable pageable = PageRequest.of(page, size);
		List<Album> albums = repository.findAll(pageable).getContent();
		return mapper.entitiesToDtos(albums);
	}

	@Override
	public AlbumDtoResp getDetails(Long id) {
		return mapper.entityToDto(getById(id));
	}

	@Override
	public AlbumDtoResp create(AlbumDtoReq dto) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public AlbumDtoResp update(AlbumDtoReq dto, Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(Long id) {
		// TODO Auto-generated method stub

	}

	@Override
	public List<AlbumDtoResp> search(String query, String type, Integer page) {
		if (query == null || query.trim().isEmpty()) {
			throw new IllegalArgumentException("Search query cannot be null or empty");
		}
		List<Album> albums = null;
		int size = 3;
		Pageable pageable = PageRequest.of(page, size);

		if (type.equalsIgnoreCase("title")) {
			albums = repository.findByTitleLike("%" + query + "%", pageable);
		} else if (type.equalsIgnoreCase("artist")) {
			albums = repository.findByArtistLike("%" + query + "%", pageable);
		} else {
			throw new SearchTypeException("type is incorrect");
		}

		return mapper.entitiesToDtos(albums);
	}

}
