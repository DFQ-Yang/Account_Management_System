package com.dimo.account_management_system_javaee.service.impl;

import com.dimo.account_management_system_javaee.dto.loginDto;
import com.dimo.account_management_system_javaee.mapper.LoginMapper;
import com.dimo.account_management_system_javaee.pojo.Result;
import com.dimo.account_management_system_javaee.service.LoginService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class LoginServiceImpl implements LoginService {
    private final LoginMapper loginMapper;
    private final ObjectMapper mapper;
    public LoginServiceImpl(LoginMapper loginMapper, ObjectMapper mapper){
        this.loginMapper = loginMapper;
        this.mapper = mapper;
    }
    @Override
    public void login(loginDto dto) throws RuntimeException, JsonProcessingException {
        if(dto.getUsername() == null | dto.getPassword() == null){
            Result result = new Result(404, "username or password cannot be empty", null);
            String json = mapper.writeValueAsString(result);
            throw new RuntimeException(json);
        }

        LoginMapper.login(dto);
    }
}
