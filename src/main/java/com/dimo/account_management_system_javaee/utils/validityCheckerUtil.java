package com.dimo.account_management_system_javaee.utils;

import com.dimo.account_management_system_javaee.dto.accountDto;
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

    public static Result accountValidityChecker(accountDto dto){
        Result result = new Result(200, "input valid", null);
        //Check validity of username and password input
        if(dto.getUrl() == null | dto.getAccount() == null | dto.getPassword() == null){
            result = new Result(406, "url or account or password cannot be empty", null);
            return result;
        }
        if(dto.getUrl().isBlank() | dto.getPassword().isBlank() | dto.getAccount().isBlank()){
            result = new Result(406, "url or password or account cannot be empty", null);
            return result;
        }
        return result;
    }
}
