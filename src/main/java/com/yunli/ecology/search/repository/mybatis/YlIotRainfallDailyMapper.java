package com.yunli.ecology.search.repository.mybatis;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.yunli.ecology.search.schema.entity.YlIotRainfallDaily;
import com.yunli.ecology.search.schema.entity.YlIotRainfallDailyKey;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface YlIotRainfallDailyMapper extends BaseMapper<YlIotRainfallDaily> {
    int deleteByPrimaryKey(YlIotRainfallDailyKey key);

    int insertSelective(YlIotRainfallDaily record);

    Optional<YlIotRainfallDaily> selectByPrimaryKey(YlIotRainfallDailyKey key);

    int updateByPrimaryKeySelective(YlIotRainfallDaily record);

    int updateByPrimaryKey(YlIotRainfallDaily record);
}