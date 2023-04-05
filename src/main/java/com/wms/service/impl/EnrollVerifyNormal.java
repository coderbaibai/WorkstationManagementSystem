package com.wms.service.impl;

import com.wms.dao.impl.MysqlDao;
import com.wms.service.EnrollVerify;
import com.wms.utils.impl.EncryptionMd5;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class EnrollVerifyNormal implements EnrollVerify {
    public boolean enroll(String userName,String password){
        if(!userName.matches("^[a-zA-Z0-9]{1,10}$")||!password.matches("^[a-zA-Z0-9]{1,20}$")){
            return false;
        }
        else{
            password = new EncryptionMd5().encrypt(password);
            String sql = "INSERT INTO Account(userName,password) VALUES(?,?);";
            Connection conn = new MysqlDao().getConnection();
            try {
                PreparedStatement pstmt = conn.prepareStatement(sql);
                pstmt.setString(1,userName);
                pstmt.setString(2,password);
                pstmt.executeUpdate();
                pstmt.close();
                conn.close();
            } catch (SQLException e) {
                try {
                    conn.close();
                } catch (SQLException ex) {
                    System.out.println("No need to close"+ e);
                    return false;
                }
                System.out.println("enroll can't connect to database"+ e);
                return false;
            }
        }
        return true;
    }
}
