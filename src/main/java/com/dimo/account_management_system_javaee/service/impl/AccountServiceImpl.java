package com.dimo.account_management_system_javaee.service.impl;

import com.dimo.account_management_system_javaee.dto.accountDto;
import com.dimo.account_management_system_javaee.mapper.AccountMapper;
import com.dimo.account_management_system_javaee.mapper.UserMapper;
import com.dimo.account_management_system_javaee.mapper.impl.AccountMapperImpl;
import com.dimo.account_management_system_javaee.mapper.impl.UserMapperImpl;
import com.dimo.account_management_system_javaee.pojo.Result;
import com.dimo.account_management_system_javaee.service.AccountService;
import com.dimo.account_management_system_javaee.utils.validityCheckerUtil;

import java.sql.SQLException;

public class AccountServiceImpl implements AccountService {
    private final AccountMapper accountMapper = new AccountMapperImpl();
    private final UserMapper userMapper = new UserMapperImpl();
    @Override
    public Result addAccount(String username, accountDto dto) {
        //check validity of accountDto
        Result result = validityCheckerUtil.accountValidityChecker(dto);
        if(result.getCode() != 200) return result;

        try {
            //get user_id by username
            int user_id = userMapper.findByUsername(username).getId();
            dto.setUser_id(user_id);

            //trans username and dto to mapper
            accountMapper.addAccount(dto);
        }
        catch (SQLException e){
            return new Result(500, "cannot access to the database", null);
        }

        return new Result(200, "add account successfully", null);
    }

    @Override
    public Result deleteAccount(Integer index) {
        //Before you delete you have to check if the index exist, so that the result will change
        //but you haven't finished the post request, so you would like to implement it later when you finished.

        //trans username and dto to mapper
        accountMapper.deleteAccount(index);



        return new Result(200, "delete account successfully", null);
    }
}
