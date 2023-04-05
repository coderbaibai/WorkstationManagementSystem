package com.wms.service;

@FunctionalInterface
public interface LoginVerify{
    boolean verify(String userName,String password);
}
