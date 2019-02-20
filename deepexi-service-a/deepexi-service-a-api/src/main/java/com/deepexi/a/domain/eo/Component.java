package com.deepexi.a.domain.eo;

import com.baomidou.mybatisplus.annotation.TableName;

/**
 * Created by liudong on 2019-02-20 10:42
 */
@TableName("component")
public class Component extends SuperEntity{
    /**
     * 组件名称,普通索引(索引命中率较高)
     */
    private String name;
    /**
     * 分类,无索引(低命中)
     */
    private String type;
    /**
     * 版本,无索引
     */
    private String version;
    /**
     * 状态,无索引
     */
    private String status;

    public Component() {
    }

    public Component(String name, String type, String version, String status) {
        this.name = name;
        this.type = type;
        this.version = version;
        this.status = status;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getName() {
        return name;
    }

    public String getType() {
        return type;
    }

    public String getVersion() {
        return version;
    }

    public String getStatus() {
        return status;
    }

    @Override
    public String toString() {
        return "Component{" +
                "name='" + name + '\'' +
                ", type='" + type + '\'' +
                ", version='" + version + '\'' +
                ", status='" + status + '\'' +
                '}';
    }

}