package com.dimo.account_management_system_javaee.controller;

import com.dimo.account_management_system_javaee.dto.loginDto;
import com.dimo.account_management_system_javaee.pojo.Result;
import com.dimo.account_management_system_javaee.service.LoginService;
import com.dimo.account_management_system_javaee.utils.jwtUtil;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.jsonwebtoken.Claims;
import jakarta.servlet.annotation.WebServlet;
import lombok.extern.slf4j.Slf4j;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;


@Slf4j
@WebServlet(urlPatterns = "/login")
public class LoginController extends HttpServlet {
    private final LoginService loginService;
    private final ObjectMapper mapper = new ObjectMapper();

    public LoginController(LoginService loginService){
        this.loginService = loginService;
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        StringBuilder sb = new StringBuilder();
        String line;
        BufferedReader br = req.getReader();

        while ((line = br.readLine()) != null) {
            sb.append(line);
        }

        //?????
        loginDto dto = mapper.readValue(sb.toString(), loginDto.class);

        //????
        loginService.login(dto);

        //????
        Map<String, Object> claims = new HashMap<>();
        claims.put("username", dto.getUsername());
        String jwt = jwtUtil.buildJwt(claims);

        //?????????
        Result result = new Result(200, "", jwt);
        String json = mapper.writeValueAsString(result);
        resp.getWriter().write(json);

        log.info("user: {} successfully log in", dto.getUsername());

    }
}
