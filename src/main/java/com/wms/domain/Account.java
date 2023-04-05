package com.wms.domain;

import java.lang.reflect.InvocationTargetException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Account {
    public Account(String userName, String password) {
        this.userName = userName;
        this.password = password;
    }
    public String getUserName() {
        return userName;
    }
    public String getPassword() {
        return password;
    }
    private final String userName;
    private final String password;
}
