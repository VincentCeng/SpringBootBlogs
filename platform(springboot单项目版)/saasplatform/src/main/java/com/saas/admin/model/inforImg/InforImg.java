package com.saas.admin.model.inforImg;

public class InforImg {
    private Integer id;

    private Integer infoId;

    private String img;

    private String imgUrl;

    private String imgtext;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getInfoId() {
        return infoId;
    }

    public void setInfoId(Integer infoId) {
        this.infoId = infoId;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img == null ? null : img.trim();
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl == null ? null : imgUrl.trim();
    }

    public String getImgtext() {
        return imgtext;
    }

    public void setImgtext(String imgtext) {
        this.imgtext = imgtext == null ? null : imgtext.trim();
    }
}