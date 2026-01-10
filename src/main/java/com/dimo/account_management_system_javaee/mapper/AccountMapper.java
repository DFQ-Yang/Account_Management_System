package com.dimo.account_management_system_javaee.mapper;

import com.dimo.account_management_system_javaee.dto.accountDto;

public interface AccountMapper {
    void addAccount(accountDto dto);

    void deleteAccount(Integer index);
}
