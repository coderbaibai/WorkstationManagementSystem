package com.wms.service.impl;

import com.wms.dao.impl.MysqlDao;
import com.wms.service.EnrollVerify;
import com.wms.service.LoginVerify;
import com.wms.utils.impl.EncryptionMd5;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class LoginVerifyNormal implements LoginVerify {
    @Override
    public boolean verify(String userName,String password) {
        boolean isGet = false;
        password = new EncryptionMd5().encrypt(password);
        String sql = "select * from Account where userName=? AND password=?";
        Connection conn = new MysqlDao().getConnection();
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1,userName);
            ps.setString(2,password);
            isGet = ps.executeQuery().next();
            ps.close();
            conn.close();
        } catch (SQLException e) {
            try {
                conn.close();
            } catch (SQLException ex) {
                System.out.println("No need to close"+ e);
            }
            System.out.println("Login can't connect to database "+ e);
        }
        return isGet;
    }
}
