package com.saas.admin.model.information;

import java.util.Date;

/*
 * 资讯实体类
 */
public class Information {
    private Integer id;

    private Integer templateType;

    private Integer contentType;

    private String title;

    private Integer attention;

    private Integer istop;

    private Integer isrecommend;

    private String publisher;

    private Integer publishType;

    private Date publishTime;

    private Integer isatlas;

    private Integer imgnum;

    private String videoUrl;

    private Integer isadvertising;

    private String advertisingUrl;

    private Date createTime;

    private Date updateTime;

    private Integer state;

    private Integer isvip;

    private Double sort;

    private Integer support;

    private Integer ispull;

    private Integer tjtop;

    private Integer dayattention;

    private String text;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getTemplateType() {
        return templateType;
    }

    public void setTemplateType(Integer templateType) {
        this.templateType = templateType;
    }

    public Integer getContentType() {
        return contentType;
    }

    public void setContentType(Integer contentType) {
        this.contentType = contentType;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title == null ? null : title.trim();
    }

    public Integer getAttention() {
        return attention;
    }

    public void setAttention(Integer attention) {
        this.attention = attention;
    }

    public Integer getIstop() {
        return istop;
    }

    public void setIstop(Integer istop) {
        this.istop = istop;
    }

    public Integer getIsrecommend() {
        return isrecommend;
    }

    public void setIsrecommend(Integer isrecommend) {
        this.isrecommend = isrecommend;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher == null ? null : publisher.trim();
    }

    public Integer getPublishType() {
        return publishType;
    }

    public void setPublishType(Integer publishType) {
        this.publishType = publishType;
    }

    public Date getPublishTime() {
        return publishTime;
    }

    public void setPublishTime(Date publishTime) {
        this.publishTime = publishTime;
    }

    public Integer getIsatlas() {
        return isatlas;
    }

    public void setIsatlas(Integer isatlas) {
        this.isatlas = isatlas;
    }

    public Integer getImgnum() {
        return imgnum;
    }

    public void setImgnum(Integer imgnum) {
        this.imgnum = imgnum;
    }

    public String getVideoUrl() {
        return videoUrl;
    }

    public void setVideoUrl(String videoUrl) {
        this.videoUrl = videoUrl == null ? null : videoUrl.trim();
    }

    public Integer getIsadvertising() {
        return isadvertising;
    }

    public void setIsadvertising(Integer isadvertising) {
        this.isadvertising = isadvertising;
    }

    public String getAdvertisingUrl() {
        return advertisingUrl;
    }

    public void setAdvertisingUrl(String advertisingUrl) {
        this.advertisingUrl = advertisingUrl == null ? null : advertisingUrl.trim();
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public Integer getIsvip() {
        return isvip;
    }

    public void setIsvip(Integer isvip) {
        this.isvip = isvip;
    }

    public Double getSort() {
        return sort;
    }

    public void setSort(Double sort) {
        this.sort = sort;
    }

    public Integer getSupport() {
        return support;
    }

    public void setSupport(Integer support) {
        this.support = support;
    }

    public Integer getIspull() {
        return ispull;
    }

    public void setIspull(Integer ispull) {
        this.ispull = ispull;
    }

    public Integer getTjtop() {
        return tjtop;
    }

    public void setTjtop(Integer tjtop) {
        this.tjtop = tjtop;
    }

    public Integer getDayattention() {
        return dayattention;
    }

    public void setDayattention(Integer dayattention) {
        this.dayattention = dayattention;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text == null ? null : text.trim();
    }
}