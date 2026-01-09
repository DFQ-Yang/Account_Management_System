package com.dimo.account_management_system_javaee.utils;

import com.dimo.account_management_system_javaee.pojo.Result;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;

import java.io.IOException;

@Slf4j
public class respUtils {
    public static HttpServletResponse get_resp(HttpServletResponse resp, Result res) throws IOException {
        log.info(res.getMsg());
        ObjectMapper objectMapper = new ObjectMapper();
        String json = objectMapper.writeValueAsString(res);
        resp.getWriter().write(json);
        return resp;
    }
}
