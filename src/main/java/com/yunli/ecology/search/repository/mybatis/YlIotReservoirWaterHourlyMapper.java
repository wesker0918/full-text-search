package com.yunli.ecology.search.repository.mybatis;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.yunli.ecology.search.schema.entity.YlIotReservoirWaterHourly;
import com.yunli.ecology.search.schema.entity.YlIotReservoirWaterHourlyKey;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface YlIotReservoirWaterHourlyMapper extends BaseMapper<YlIotReservoirWaterHourly> {
    int deleteByPrimaryKey(YlIotReservoirWaterHourlyKey key);

    int insertSelective(YlIotReservoirWaterHourly record);

    Optional<YlIotReservoirWaterHourly> selectByPrimaryKey(YlIotReservoirWaterHourlyKey key);

    int updateByPrimaryKeySelective(YlIotReservoirWaterHourly record);

    int updateByPrimaryKey(YlIotReservoirWaterHourly record);
}