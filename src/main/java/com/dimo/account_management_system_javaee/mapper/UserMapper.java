package com.dimo.account_management_system_javaee.mapper;

import com.dimo.account_management_system_javaee.dto.userDto;
import com.dimo.account_management_system_javaee.pojo.User;

import java.sql.SQLException;

public interface UserMapper {
    User findByUsername(String username) throws SQLException;

    void registerByUsername(userDto dto)throws SQLException;
}
