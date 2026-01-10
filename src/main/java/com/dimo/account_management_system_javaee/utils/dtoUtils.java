package com.dimo.account_management_system_javaee.utils;

import com.dimo.account_management_system_javaee.dto.accountDto;
import com.dimo.account_management_system_javaee.dto.userDto;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.servlet.http.HttpServletRequest;

import java.io.BufferedReader;
import java.io.IOException;

public class dtoUtils {
    public static userDto loadUserDto(HttpServletRequest req) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        StringBuilder sb = new StringBuilder();
        String line;
        BufferedReader br = req.getReader();

        while((line = br.readLine()) != null){
            sb.append(line);
        }

        userDto dto = mapper.readValue(sb.toString(), userDto.class);

        return dto;
    }

    public static accountDto loadAccountDto(HttpServletRequest req) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        StringBuilder sb = new StringBuilder();
        String line;
        BufferedReader br = req.getReader();

        while((line = br.readLine()) != null){
            sb.append(line);
        }

        accountDto dto = mapper.readValue(sb.toString(), accountDto.class);
        return dto;
    }
}
