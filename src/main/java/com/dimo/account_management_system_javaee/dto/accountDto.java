package com.dimo.account_management_system_javaee.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class accountDto {
    private Integer user_id = null;
    private String url;
    private String comment = "";
    private String account;
    private String password;
}
