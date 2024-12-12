package io.benfill.isdb.service;

import java.util.List;

import org.springframework.stereotype.Service;

import io.benfill.isdb.dto.request.SongDtoReq;
import io.benfill.isdb.dto.response.SongDtoResp;
import io.benfill.isdb.model.Song;

@Service
public interface ISongService {

	Song getById(Long id);

	List<SongDtoResp> getAll(Integer page);

	SongDtoResp getDetails(Long id);

	SongDtoResp create(SongDtoReq dto);

	SongDtoResp update(SongDtoReq dto, Long id);

	void delete(Long id);

}
