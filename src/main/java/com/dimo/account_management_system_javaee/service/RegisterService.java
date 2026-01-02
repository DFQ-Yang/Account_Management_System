package com.dimo.account_management_system_javaee.service;

import com.dimo.account_management_system_javaee.dto.userDto;
import com.dimo.account_management_system_javaee.pojo.Result;

public interface RegisterService {
    Result register(userDto dto);
}
