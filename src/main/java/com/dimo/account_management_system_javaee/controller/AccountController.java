package com.dimo.account_management_system_javaee.controller;

import com.dimo.account_management_system_javaee.dto.accountDto;
import com.dimo.account_management_system_javaee.pojo.Result;
import com.dimo.account_management_system_javaee.service.AccountService;
import com.dimo.account_management_system_javaee.service.impl.AccountServiceImpl;
import com.dimo.account_management_system_javaee.utils.accountDtoLoaderUtil;
import com.dimo.account_management_system_javaee.utils.jwtUtil;
import com.dimo.account_management_system_javaee.utils.respUtils;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.jsonwebtoken.Claims;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;

import java.io.IOException;

@Slf4j
@WebServlet(urlPatterns = "/account")
public class AccountController extends HttpServlet {
    private final AccountService accountService = new AccountServiceImpl();
    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //get username from jwt
        String jwt = jwtUtil.loadJwt(req);
        Claims claims = jwtUtil.parseJwt(jwt);
        String username = claims.get("username").toString();

        //get dto from request
        accountDto dto = accountDtoLoaderUtil.loadAccount(req);

        //trans dto and username to service
        Result res = accountService.addAccount(username, dto);

        resp = respUtils.get_resp(resp, res);

    }
}
