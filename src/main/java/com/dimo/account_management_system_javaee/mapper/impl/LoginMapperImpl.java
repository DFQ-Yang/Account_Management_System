package com.dimo.account_management_system_javaee.mapper.impl;

import com.dimo.account_management_system_javaee.mapper.LoginMapper;
import com.dimo.account_management_system_javaee.pojo.User;
import com.dimo.account_management_system_javaee.utils.dbPoolInitializerUtil;
import lombok.extern.slf4j.Slf4j;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

@Slf4j
public class LoginMapperImpl implements LoginMapper {
    @Override
    public User findByUsername(String username) throws SQLException {
        String sql = "SELECT id, username, password FROM ams.user where username = ?";

        //try gets connection to the db pool
        try(Connection conn = dbPoolInitializerUtil.getDataSource().getConnection();
            PreparedStatement ps = conn.prepareStatement(sql)){

            //insert username to sql and execute
            ps.setString(1, username);
            ResultSet res = ps.executeQuery();

            //If exits, pack data into User and return.
            if(res.next()){
                User user = new User();
                user.setId(res.getInt("id"));
                user.setUsername(res.getString("username"));
                user.setPassword(res.getString("password"));
                return user;
            }
        }
        //If it cannot get connects to the db, throws exception
        catch (SQLException e){
            throw new SQLException("cannot get connection to the db");
        }
        //If not cannot find specific user, then return nothing.
        return null;
    }
}
