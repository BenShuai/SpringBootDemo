package com.it.sun.entity;

public class SysConfig {
    private Long id;

    private String paramKey;

    private String paramValue;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getParamKey() {
        return paramKey;
    }

    public void setParamKey(String paramKey) {
        this.paramKey = paramKey == null ? null : paramKey.trim();
    }

    public String getParamValue() {
        return paramValue;
    }

    public void setParamValue(String paramValue) {
        this.paramValue = paramValue == null ? null : paramValue.trim();
    }

    public SysConfig() {
    }

    public SysConfig(Long id, String paramKey, String paramValue) {
        this.id = id;
        this.paramKey = paramKey;
        this.paramValue = paramValue;
    }
}