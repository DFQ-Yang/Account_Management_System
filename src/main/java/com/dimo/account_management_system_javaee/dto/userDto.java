package com.dimo.account_management_system_javaee.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class userDto {
    private String username;
    private String password;
}
