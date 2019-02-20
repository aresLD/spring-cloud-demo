package com.deepexi.a.service;

import com.deepexi.a.domain.eo.Component;
import com.deepexi.util.pageHelper.PageBean;

import java.util.List;

/**
 * Created by liudong on 2019-02-20 10:45
 */
public interface ComponentService {
    PageBean getComponentList(Integer page, Integer size, String name,String type,String status);

    Integer createComponent(Component component);

    Integer updateComponent(Component component);

    Integer deleteComponentById(List<String> ids);

    Component getComponentById(String id);
}