package com.dimo.account_management_system_javaee.mapper;

import com.dimo.account_management_system_javaee.dto.loginDto;
import com.dimo.account_management_system_javaee.pojo.User;

import java.io.IOException;
import java.sql.SQLException;

public interface LoginMapper {
    User findByUsername(String username) throws SQLException;

}
