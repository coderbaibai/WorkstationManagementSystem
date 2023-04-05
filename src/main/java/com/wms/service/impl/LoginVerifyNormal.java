package com.wms.service.impl;

import com.wms.dao.impl.MysqlDao;
import com.wms.service.LoginVerify;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class LoginVerifyNormal implements LoginVerify {
    @Override
    public boolean verify(String userName,String password) {
        boolean isGet = false;
        try {
            Connection conn = new MysqlDao().getConnection();
            String sql = "select * from Account where userName=? AND password=?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1,userName);
            ps.setString(2,password);
            isGet = ps.executeQuery().next();
            ps.close();
            conn.close();
        } catch (SQLException e) {
            System.out.println("Login can't connect to database "+ e);
        }
        return isGet;
    }
}
