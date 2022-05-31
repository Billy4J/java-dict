package com.afterAll.mybatis.mapper;

import com.afterAll.mybatis.entity.User;
import org.apache.ibatis.annotations.Param;

import java.sql.Date;
import java.util.Map;


/**
 * mapper接口参数获取
 */
public interface ParamMapper {

    User getUserOne(int id);

    User getUserTwo(int id, String name);

    User getUserMap(Map<String, Integer> map);

    User getUserObject(User user);

    User getUserParam(@Param(value = "paramName") int id, Date birth);
}
