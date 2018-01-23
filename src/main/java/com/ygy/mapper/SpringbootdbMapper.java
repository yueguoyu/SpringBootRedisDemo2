package com.ygy.mapper;

import com.ygy.model.Springbootdb;
import com.ygy.model.SpringbootdbExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SpringbootdbMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table springbootDB
     *
     * @mbggenerated
     */
    int countByExample(SpringbootdbExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table springbootDB
     *
     * @mbggenerated
     */
    int deleteByExample(SpringbootdbExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table springbootDB
     *
     * @mbggenerated
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table springbootDB
     *
     * @mbggenerated
     */
    int insert(Springbootdb record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table springbootDB
     *
     * @mbggenerated
     */
    int insertSelective(Springbootdb record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table springbootDB
     *
     * @mbggenerated
     */
    List<Springbootdb> selectByExample(SpringbootdbExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table springbootDB
     *
     * @mbggenerated
     */
    Springbootdb selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table springbootDB
     *
     * @mbggenerated
     */
    int updateByExampleSelective(@Param("record") Springbootdb record, @Param("example") SpringbootdbExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table springbootDB
     *
     * @mbggenerated
     */
    int updateByExample(@Param("record") Springbootdb record, @Param("example") SpringbootdbExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table springbootDB
     *
     * @mbggenerated
     */
    int updateByPrimaryKeySelective(Springbootdb record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table springbootDB
     *
     * @mbggenerated
     */
    int updateByPrimaryKey(Springbootdb record);
    Springbootdb findById(int id);
}