package com.dimo.account_management_system_javaee.service.impl;

import com.dimo.account_management_system_javaee.dto.userDto;
import com.dimo.account_management_system_javaee.mapper.UserMapper;
import com.dimo.account_management_system_javaee.mapper.impl.UserMapperImpl;
import com.dimo.account_management_system_javaee.pojo.Result;
import com.dimo.account_management_system_javaee.pojo.User;
import com.dimo.account_management_system_javaee.service.LoginService;
import com.dimo.account_management_system_javaee.utils.jwtUtil;
import com.dimo.account_management_system_javaee.utils.validityCheckerUtil;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

public class LoginServiceImpl implements LoginService {
    private final UserMapper loginMapper = new UserMapperImpl();
    private final ObjectMapper mapper = new ObjectMapper();

    @Override
    public Result login(userDto dto) throws RuntimeException, JsonProcessingException {
        User user = new User();

        //Check username and password are valid.
        Result res = validityCheckerUtil.userValidityChecker(dto);
        if(res.getCode() != 200)return res;

        //Get result from mapper
        try{
            user = loginMapper.findByUsername(dto.getUsername());
        }
        catch (SQLException e){
            return new Result(500, "cannot get access with database", null);
        }

        //Check identity exist and correct.
        if(user == null) return new Result(401, "username or password is incorrect", null);
        if(!user.getPassword().equals(dto.getPassword())) return new Result(401, "username or password is incorrect", null);

        //generate jwt
        Map<String, Object> claims = new HashMap<>();
        claims.put("username", dto.getUsername());
        String jwt = jwtUtil.buildJwt(claims);

        return new Result(200, "login success", jwt);
    }
}
