package com.dimo.account_management_system;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.server.servlet.context.ServletComponentScan;

@SpringBootApplication
@ServletComponentScan
public class AccountManagementSystemApplication {

    public static void main(String[] args) {
        SpringApplication.run(AccountManagementSystemApplication.class, args);
    }

}
