package com.dimo.account_management_system_javaee.utils;

import com.dimo.account_management_system_javaee.dto.accountDto;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class accountUtils {
    public static void accountManipulates(String sql, accountDto dto){
        try(Connection conn = dbPoolInitializerUtil.getDataSource().getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);){
            ps.setInt(1, dto.getUser_id());
            ps.setString(2, dto.getUrl());
            ps.setString(3, dto.getComment());
            ps.setString(4, dto.getAccount());
            ps.setString(5, dto.getPassword());
            ps.execute();
        }
        catch (SQLException e){
            throw new RuntimeException("cannot get access with db", e);
        }
    }
}
