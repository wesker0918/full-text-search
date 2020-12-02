package com.yunli.ecology.search.repository.mybatis;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.yunli.ecology.search.schema.entity.YlIotSoilMonth3Period;
import com.yunli.ecology.search.schema.entity.YlIotSoilMonth3PeriodKey;
import org.springframework.stereotype.Repository;

@Repository
public interface YlIotSoilMonth3PeriodMapper extends BaseMapper<YlIotSoilMonth3Period> {
    int deleteByPrimaryKey(YlIotSoilMonth3PeriodKey key);

    int insertSelective(YlIotSoilMonth3Period record);

    YlIotSoilMonth3Period selectByPrimaryKey(YlIotSoilMonth3PeriodKey key);

    int updateByPrimaryKeySelective(YlIotSoilMonth3Period record);

    int updateByPrimaryKey(YlIotSoilMonth3Period record);
}