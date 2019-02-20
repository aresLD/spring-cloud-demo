package com.deepexi.a.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.deepexi.a.domain.eo.Component;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ComponentMapper extends BaseMapper<Component> {

    List<Component> selectPageVo(@Param("name") String name,@Param("type") String type,@Param("status") String status);

    Component selectOneById(String id);
}
