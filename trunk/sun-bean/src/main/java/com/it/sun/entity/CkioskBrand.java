package com.it.sun.entity;

public class CkioskBrand {
    private Integer ckioskBrandid;

    private String ckioskBrandguid;

    private String project;

    private String name;

    private String firstletter;

    private String introduction;

    private String logo;

    private String image;

    private String businessscope;

    private String percapitaconsumption;

    private String businesshours;

    private String contactnumber;

    private String contact;

    private String fax;

    private String site;

    private String email;

    private String wechat;

    private String qrcode;

    private String qrcodeimage;

    private String other;

    private Boolean showsds;

    private Integer order;

    private String lan;

    public Integer getCkioskBrandid() {
        return ckioskBrandid;
    }

    public void setCkioskBrandid(Integer ckioskBrandid) {
        this.ckioskBrandid = ckioskBrandid;
    }

    public String getCkioskBrandguid() {
        return ckioskBrandguid;
    }

    public void setCkioskBrandguid(String ckioskBrandguid) {
        this.ckioskBrandguid = ckioskBrandguid == null ? null : ckioskBrandguid.trim();
    }

    public String getProject() {
        return project;
    }

    public void setProject(String project) {
        this.project = project == null ? null : project.trim();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getFirstletter() {
        return firstletter;
    }

    public void setFirstletter(String firstletter) {
        this.firstletter = firstletter == null ? null : firstletter.trim();
    }

    public String getIntroduction() {
        return introduction;
    }

    public void setIntroduction(String introduction) {
        this.introduction = introduction == null ? null : introduction.trim();
    }

    public String getLogo() {
        return logo;
    }

    public void setLogo(String logo) {
        this.logo = logo == null ? null : logo.trim();
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image == null ? null : image.trim();
    }

    public String getBusinessscope() {
        return businessscope;
    }

    public void setBusinessscope(String businessscope) {
        this.businessscope = businessscope == null ? null : businessscope.trim();
    }

    public String getPercapitaconsumption() {
        return percapitaconsumption;
    }

    public void setPercapitaconsumption(String percapitaconsumption) {
        this.percapitaconsumption = percapitaconsumption == null ? null : percapitaconsumption.trim();
    }

    public String getBusinesshours() {
        return businesshours;
    }

    public void setBusinesshours(String businesshours) {
        this.businesshours = businesshours == null ? null : businesshours.trim();
    }

    public String getContactnumber() {
        return contactnumber;
    }

    public void setContactnumber(String contactnumber) {
        this.contactnumber = contactnumber == null ? null : contactnumber.trim();
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact == null ? null : contact.trim();
    }

    public String getFax() {
        return fax;
    }

    public void setFax(String fax) {
        this.fax = fax == null ? null : fax.trim();
    }

    public String getSite() {
        return site;
    }

    public void setSite(String site) {
        this.site = site == null ? null : site.trim();
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email == null ? null : email.trim();
    }

    public String getWechat() {
        return wechat;
    }

    public void setWechat(String wechat) {
        this.wechat = wechat == null ? null : wechat.trim();
    }

    public String getQrcode() {
        return qrcode;
    }

    public void setQrcode(String qrcode) {
        this.qrcode = qrcode == null ? null : qrcode.trim();
    }

    public String getQrcodeimage() {
        return qrcodeimage;
    }

    public void setQrcodeimage(String qrcodeimage) {
        this.qrcodeimage = qrcodeimage == null ? null : qrcodeimage.trim();
    }

    public String getOther() {
        return other;
    }

    public void setOther(String other) {
        this.other = other == null ? null : other.trim();
    }

    public Boolean getShowsds() {
        return showsds;
    }

    public void setShowsds(Boolean showsds) {
        this.showsds = showsds;
    }

    public Integer getOrder() {
        return order;
    }

    public void setOrder(Integer order) {
        this.order = order;
    }

    public String getLan() {
        return lan;
    }

    public void setLan(String lan) {
        this.lan = lan == null ? null : lan.trim();
    }
}