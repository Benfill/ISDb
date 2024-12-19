package io.benfill.isdb.service;

import java.util.List;

import org.springframework.stereotype.Service;

import io.benfill.isdb.dto.request.UserDtoReq;
import io.benfill.isdb.dto.response.UserDtoResp;
import io.benfill.isdb.model.User;

@Service
public interface IUserService {
	User getById(String id);

	List<UserDtoResp> getAll(Integer page);

	UserDtoResp getDetails(String id);

	UserDtoResp create(UserDtoReq dto);

	UserDtoResp update(UserDtoReq dto, String id);

	void delete(String id);

}
