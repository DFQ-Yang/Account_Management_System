package com.dimo.account_management_system_javaee.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Accounts {
    private Integer id;
    private Integer user_id;
    private String url;
    private String comment;
    private String account;
    private String password;
}
