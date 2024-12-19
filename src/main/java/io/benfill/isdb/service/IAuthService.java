package io.benfill.isdb.service;

import org.springframework.web.bind.annotation.RequestBody;

import io.benfill.isdb.dto.request.LoginDto;
import io.benfill.isdb.dto.request.UserDtoReq;
import io.benfill.isdb.dto.response.UserDtoResp;
import io.benfill.isdb.model.AuthToken;

public interface IAuthService {
	UserDtoResp registerHandler(UserDtoReq user);

	public AuthToken loginHandler(@RequestBody LoginDto body);
}
