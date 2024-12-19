package io.benfill.isdb.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import io.benfill.isdb.dto.request.UserDtoReq;
import io.benfill.isdb.dto.response.UserDtoResp;
import io.benfill.isdb.mapper.UserMapper;
import io.benfill.isdb.model.User;
import io.benfill.isdb.repository.UserRepository;
import io.benfill.isdb.service.IUserService;

@Service
public class UserService implements IUserService {

	@Autowired
	private UserRepository repository;

	@Autowired
	private UserMapper mapper;

	@Override
	public User getById(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<UserDtoResp> getAll(Integer page) {
		int size = 3;

		Pageable pageable = PageRequest.of(page, size);

		List<User> users = repository.findAll(pageable).getContent();
		return mapper.entitiesToDtos(users);
	}

	@Override
	public UserDtoResp getDetails(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public UserDtoResp create(UserDtoReq dto) {
		User user = mapper.DtoToentity(dto);

		return mapper.entityToDto(repository.save(user));
	}

	@Override
	public UserDtoResp update(UserDtoReq dto, String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(String id) {
		// TODO Auto-generated method stub

	}

}
