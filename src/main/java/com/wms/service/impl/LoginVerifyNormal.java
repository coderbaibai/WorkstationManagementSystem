package com.wms.service.impl;

import com.wms.service.LoginVerify;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class LoginVerifyWithUserNameAndPassword implements LoginVerify {
    @Override
    public boolean verify(String userName,String password) {
        boolean isGet = false;
        try {
            Connection conn = new MysqlDAO().getConnection("SeatManagement");
            String sql = "select * from Account where userName=? AND password=?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1,Account.this.userName);
            ps.setString(2,Account.this.password);
            isGet = ps.executeQuery().next();
            ps.close();
            conn.close();
        } catch (SQLException e) {
            System.out.println("Login can't connect to database "+ e);
        }
        return isGet;
    }
}
