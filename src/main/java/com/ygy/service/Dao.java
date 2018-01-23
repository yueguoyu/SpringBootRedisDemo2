package com.ygy.service;

import com.ygy.model.Springbootdb;

public interface Dao {
    public Springbootdb findById(int id);
    public int add(Springbootdb springbootdb);
    public int update(Springbootdb springbootdb);
    public int delete(int id);
}
