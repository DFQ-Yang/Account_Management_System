package com.dimo.account_management_system_javaee.mapper.impl;

import com.dimo.account_management_system_javaee.dto.accountDto;
import com.dimo.account_management_system_javaee.mapper.AccountMapper;
import com.dimo.account_management_system_javaee.utils.accountUtils;
import com.dimo.account_management_system_javaee.utils.dbPoolInitializerUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;


public class AccountMapperImpl implements AccountMapper {
    @Override
    public void addAccount(accountDto dto){
        String sql = "INSERT into ams.accounts values(null, ?, ?, ?, ?, ?)";

        accountUtils.accountManipulates(sql, dto);
    }

    @Override
    public void deleteAccount(Integer index) {
        String sql = "DELETE from ams.accounts where id = ?";

        try(Connection conn = dbPoolInitializerUtil.getDataSource().getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);){
            ps.setInt(1, index);
            ps.execute();
        }
        catch (SQLException e){
            throw new RuntimeException("cannot get access with db", e);
        }
    }
}
