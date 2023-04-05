package com.wms.dao.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class MysqlDAO {
    MysqlDAO(){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            System.out.println("can't connect to mysql driver"+ e);
        }
    }
    public Connection getConnection(String databaseName,String parameters){
        try {
            return DriverManager.getConnection(baseUrl+databaseName+parameters,userName,password);
        } catch (SQLException e) {
            System.out.println("can't connect to mysql "+ e);
            return null;
        }
    }
    public Connection getConnection(String databaseName){
        try {
            return DriverManager.getConnection(baseUrl+databaseName+this.parameters,userName,password);
        } catch (SQLException e) {
            System.out.println("can't connect to mysql "+ e);
            return null;
        }
    }
    private final String baseUrl = "jdbc:mysql://localhost:3306/";
    private final String userName = "root";
    private final String password = "135792";
    private final String parameters = "?useSSL=false";
}
