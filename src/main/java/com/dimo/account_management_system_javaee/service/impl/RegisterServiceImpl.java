package com.dimo.account_management_system_javaee.service.impl;

import com.dimo.account_management_system_javaee.dto.userDto;
import com.dimo.account_management_system_javaee.mapper.UserMapper;
import com.dimo.account_management_system_javaee.mapper.impl.UserMapperImpl;
import com.dimo.account_management_system_javaee.pojo.Result;
import com.dimo.account_management_system_javaee.pojo.User;
import com.dimo.account_management_system_javaee.service.RegisterService;
import com.dimo.account_management_system_javaee.utils.validityCheckerUtil;

import java.sql.SQLException;

public class RegisterServiceImpl implements RegisterService {
    private final UserMapper userMapper = new UserMapperImpl();
    @Override
    public Result register(userDto dto) {
        User user = new User();

        //Check validity of input
        Result result = validityCheckerUtil.userValidityChecker(dto);
        if(result.getCode() != 200)return result;

        //Check if username is used
        try{
            user = userMapper.findByUsername(dto.getUsername());
        }
        catch (SQLException e){
            return new Result(500, "assessing database failed", null);
        }
        if(user != null) return new Result(401, "username is already used", null);

        //Register
        try{
            userMapper.registerByUsername(dto);
        }
        catch (SQLException e){
            return new Result(500, "assessing database failed", null);
        }

        //register success
        return new Result(200, "register success", null);
    }
}
