package com.dimo.account_management_system_javaee.controller;

import com.dimo.account_management_system_javaee.dto.userDto;
import com.dimo.account_management_system_javaee.pojo.Result;
import com.dimo.account_management_system_javaee.service.RegisterService;
import com.dimo.account_management_system_javaee.service.impl.RegisterServiceImpl;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;

import java.io.IOException;

import static com.dimo.account_management_system_javaee.utils.dtoUtils.loadUserDto;

@Slf4j
@WebServlet(urlPatterns = "/register")
public class RegisterController extends HttpServlet {
    private final RegisterService registerService = new RegisterServiceImpl();
    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ObjectMapper mapper = new ObjectMapper();

        //Get dto from dtoLoader
        userDto dto = loadUserDto(req);

        //Get result from service
        Result res = registerService.register(dto);

        //Write result into responce
        String json = mapper.writeValueAsString(res);
        resp.getWriter().write(json);

        //log out info
        if(res.getCode() == 200){
            log.info("register success");
        }
        else log.info("register failed as {}", res.getMsg());
    }
}
