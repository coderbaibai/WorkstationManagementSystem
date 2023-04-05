package com.wms.dao.impl;

import com.alibaba.druid.pool.DruidDataSourceFactory;
import com.wms.dao.Dao;
import org.junit.Test;

import javax.sql.DataSource;
import java.io.InputStream;
import java.sql.Connection;
import java.util.Properties;


public class MysqlDao implements Dao {
    @Override
    public Connection getConnection() {
        Connection result = null;
        Properties pro = new Properties();
        InputStream is = this.getClass().getClassLoader().getResourceAsStream("druid/SeatManagement.properties");
        try {
            pro.load(is);
            DataSource ds = DruidDataSourceFactory.createDataSource(pro);
            result = ds.getConnection();
        } catch (Exception e) {
            System.out.println("can not connect to database");
        }
        return result;
    }
    @Test
    public void test(){
        Properties pro = new Properties();
        InputStream is = this.getClass().getClassLoader().getResourceAsStream("druid/SeatManagement.properties");
        try {
            pro.load(is);
            DataSource ds = DruidDataSourceFactory.createDataSource(pro);
            Connection result  = ds.getConnection();
        } catch (Exception e) {
            System.out.println("can not connect to database");
        }
    }
}
