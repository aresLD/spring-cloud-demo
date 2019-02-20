package com.deepexi.a.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.deepexi.a.domain.eo.Component;
import com.deepexi.a.extension.ApplicationException;
import com.deepexi.a.mapper.ComponentMapper;
import com.deepexi.a.service.ComponentService;
import com.deepexi.util.pageHelper.PageBean;
import com.github.pagehelper.PageHelper;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by donh on 2018/11/6.
 */
@Service
public class ComponentServiceImpl extends ServiceImpl<ComponentMapper, Component> implements ComponentService {

    private static final Logger logger = LoggerFactory.getLogger(ComponentServiceImpl.class);

    @Override
    public PageBean getComponentList(Integer page, Integer size, String name,String type,String version) {
        //简单限流控制
        if(size>100){
            size = 100;
        }
        PageHelper.startPage(page, size);
        List<Component> userTasks = this.baseMapper.selectPageVo(name,type,version);
        return new PageBean<>(userTasks);
    }

    @Override
    public Integer createComponent(Component component) {
        if(StringUtils.isNotEmpty(component.getId())){
            throw new ApplicationException(HttpStatus.INTERNAL_SERVER_ERROR.value()+"","不能插入id");
        }
        return this.baseMapper.insert(component);
    }

    @Override
    public Integer updateComponent(Component component){
        Component componentOld = this.baseMapper.selectOneById(component.getId());
        if(componentOld == null){
            throw new ApplicationException(HttpStatus.INTERNAL_SERVER_ERROR.value()+"","数据不存在,无法更新");
        }
        return this.baseMapper.updateById(component);
    }

    @Override
    public Integer deleteComponentById(List<String> ids) {
        return this.baseMapper.deleteBatchIds(ids);
    }

    @Override
    public Component getComponentById(String id) {
        return baseMapper.selectOneById(id);
    }

}