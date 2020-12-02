package com.yunli.ecology.search.repository.mybatis;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.yunli.ecology.search.schema.entity.YlIotRiverwaterHourly;
import com.yunli.ecology.search.schema.entity.YlIotRiverwaterHourlyKey;
import org.springframework.stereotype.Repository;

@Repository
public interface YlIotRiverWaterHourlyMapper extends BaseMapper<YlIotRiverwaterHourly> {
    int deleteByPrimaryKey(YlIotRiverwaterHourlyKey key);

    int insertSelective(YlIotRiverwaterHourly record);

    YlIotRiverwaterHourly selectByPrimaryKey(YlIotRiverwaterHourlyKey key);

    int updateByPrimaryKeySelective(YlIotRiverwaterHourly record);

    int updateByPrimaryKey(YlIotRiverwaterHourly record);
}