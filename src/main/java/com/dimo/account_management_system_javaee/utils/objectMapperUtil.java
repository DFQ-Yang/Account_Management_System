package com.dimo.account_management_system_javaee.utils;

import com.fasterxml.jackson.databind.ObjectMapper;

public class objectMapperUtil {
    public static ObjectMapper get_objectMapper(){
        return new ObjectMapper();
    }
}
