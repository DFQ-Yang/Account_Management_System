package com.dimo.account_management_system_javaee.utils;

import com.dimo.account_management_system_javaee.dto.userDto;
import com.dimo.account_management_system_javaee.pojo.Result;

public class validityCheckerUtil {
    public static Result userValidityChecker(userDto dto){
        //Check validity of username and password input
        if(dto.getUsername() == null | dto.getPassword() == null){
            Result result = new Result(406, "username or password cannot be empty", null);
            return result;
        }
        if(dto.getUsername().isBlank() | dto.getPassword().isBlank()){
            Result result = new Result(406, "username or password cannot be empty", null);
            return result;
        }
        return new Result(200, "input valid", null);
    }
}
