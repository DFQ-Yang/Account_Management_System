package com.dimo.account_management_system_javaee.controller;

import com.dimo.account_management_system_javaee.dto.userDto;
import com.dimo.account_management_system_javaee.pojo.Result;
import com.dimo.account_management_system_javaee.service.LoginService;
import com.dimo.account_management_system_javaee.service.impl.LoginServiceImpl;
import com.dimo.account_management_system_javaee.utils.userDtoLoaderUtil;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.servlet.annotation.WebServlet;
import lombok.extern.slf4j.Slf4j;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;


@Slf4j
@WebServlet(urlPatterns = "/login")
public class LoginController extends HttpServlet {
    private final LoginService loginService = new LoginServiceImpl();
    private final ObjectMapper mapper = new ObjectMapper();


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        //Get dto from dtoLoader
        userDto dto = userDtoLoaderUtil.userDtoLoaderUtil(req);

        //Get result from service
        Result res = loginService.login(dto);

        //Pack result and transit to json, then return as response.
        String json = mapper.writeValueAsString(res);
        resp.getWriter().write(json);

        //log out info
        if(res.getCode() == 200) log.info("user: {} successfully log in", dto.getUsername());
        else log.info("Failed to login as {}", res.getMsg());

    }
}
