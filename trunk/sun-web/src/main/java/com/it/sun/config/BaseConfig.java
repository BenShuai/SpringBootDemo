package com.example.demo.config;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "ty.fy")
public class BaseConfig {
    private String url;//连接的富友的根地址
    private String mchnt_cd;     //商户代码
    private String ver;//富友接口固定的文档版本号
    private String page_notify_url;//金账户要调用的一个根地址

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getMchnt_cd() {
        return mchnt_cd;
    }

    public void setMchnt_cd(String mchnt_cd) {
        this.mchnt_cd = mchnt_cd;
    }

    public String getVer() {
        return ver;
    }

    public void setVer(String ver) {
        this.ver = ver;
    }

    public String getPage_notify_url() {
        return page_notify_url;
    }

    public void setPage_notify_url(String page_notify_url) {
        this.page_notify_url = page_notify_url;
    }
}
