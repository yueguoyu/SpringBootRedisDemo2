package com.ygy.service;

import com.ygy.mapper.SpringbootdbMapper;
import com.ygy.model.Springbootdb;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;

import java.util.concurrent.TimeUnit;


@org.springframework.stereotype.Service
public class DaoImpl implements Dao {
    private static final Logger LOGGER = LoggerFactory.getLogger(DaoImpl.class);
    @Autowired
    private SpringbootdbMapper mapper;
    @Autowired
    private RedisTemplate redisTemplate;
    @Override
    public Springbootdb findById(int id) {
        //从缓存中获取
        String key="id_"+id;
        ValueOperations<String,Springbootdb> operations
        =redisTemplate.opsForValue();
        //缓存存在
        boolean haskey=redisTemplate.hasKey(key);
        if (haskey){
            Springbootdb springbootdb=operations.get(key);
            LOGGER.info("serviceImpl.findById:从缓存中获取"+springbootdb.getName());
            return springbootdb;
        }
        //db中获取
        Springbootdb springbootdb= this.mapper.findById(id);
        //插入缓存
        operations.set(key,springbootdb,10, TimeUnit.SECONDS);
        return springbootdb;
    }

    @Override
    public int add(Springbootdb springbootdb) {
      return   this.mapper.insert(springbootdb);
    }

    @Override
    public int update(Springbootdb springbootdb) {
        int ret=this.mapper.updateByPrimaryKeySelective(springbootdb);
        //缓存存在  删除
        String key="id_"+springbootdb.getId();
        boolean haskey=redisTemplate.hasKey(key);
        if (haskey){
            redisTemplate.delete(key);
            LOGGER.info("serviceImpl.update():从缓存中删除"+springbootdb.getName());
        }
        return ret;
    }

    @Override
    public int delete(int id) {
        int ret=this.mapper.deleteByPrimaryKey(id);
        //缓存中删除
        String key="id_"+id;
        boolean haskey=redisTemplate.hasKey(key);
        if (haskey){
            redisTemplate.delete(key);
            LOGGER.info("serviceImpl.delete():从缓存中删除"+id);
        }
        return ret;
    }
}
