package com.dimo.account_management_system_javaee.service;

import com.dimo.account_management_system_javaee.dto.accountDto;
import com.dimo.account_management_system_javaee.pojo.Result;

import java.sql.SQLException;

public interface AccountService {
    Result addAccount(String username, accountDto dto);
}
