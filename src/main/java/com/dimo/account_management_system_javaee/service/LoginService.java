package com.dimo.account_management_system_javaee.service;

import com.dimo.account_management_system_javaee.dto.loginDto;
import com.fasterxml.jackson.core.JsonProcessingException;

public interface LoginService {


    void login(loginDto dto) throws JsonProcessingException;
}
