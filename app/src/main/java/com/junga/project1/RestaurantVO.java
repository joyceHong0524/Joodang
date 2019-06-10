package com.junga.project1;

import java.io.Serializable;

public class RestaurantVO implements Serializable {

    private String areaName;


    //This is for recyclerView Cards

    private int drawable;
    private String name;
    private String attr;
    private String star;
    private String dongName;
    private String closeTime;


    // This is for Place information Page

    private String resAddress;
    private String resPrice;
    private String resOpenClose;
    private String resDescription;
    private double longitude;
    private double latitude;


    public RestaurantVO(String areaName, int drawable, String name, String attr, String star, String dongName, String closeTime, String resAddress, String resPrice, String resOpenClose, String resDescription, double latitude, double longitude) {
        this.areaName = areaName;
        this.drawable = drawable;
        this.name = name;
        this.attr = attr;
        this.star = star;
        this.dongName = dongName;
        this.closeTime = closeTime;

        this.resAddress = resAddress;
        this.resPrice = resPrice;
        this.resOpenClose = resOpenClose;
        this.resDescription = resDescription;
        this.longitude = longitude;
        this.latitude = latitude;
    }

    public int getDrawable() {
        return drawable;
    }

    public void setDrawable(int drawable) {
        this.drawable = drawable;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAttr() {
        return attr;
    }

    public void setAttr(String attr) {
        this.attr = attr;
    }

    public String getStar() {
        return star;
    }

    public void setStar(String star) {
        this.star = star;
    }

    public String getDongName() {
        return dongName;
    }

    public void setDongName(String dongName) {
        this.dongName = dongName;
    }

    public String getCloseTime() {
        return closeTime;
    }

    public void setCloseTime(String closeTime) {
        this.closeTime = closeTime;
    }

    public String getAreaName() {
        return areaName;
    }

    public void setAreaName(String areaName) {
        this.areaName = areaName;
    }


    public String getResAddress() {
        return resAddress;
    }

    public void setResAddress(String resAddress) {
        this.resAddress = resAddress;
    }

    public String getResPrice() {
        return resPrice;
    }

    public void setResPrice(String resPrice) {
        this.resPrice = resPrice;
    }

    public String getResOpenClose() {
        return resOpenClose;
    }

    public void setResOpenClose(String resOpenClose) {
        this.resOpenClose = resOpenClose;
    }

    public String getResDescription() {
        return resDescription;
    }

    public void setResDescription(String resDescription) {
        this.resDescription = resDescription;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(float longitude) {
        this.longitude = longitude;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(float latitude) {
        this.latitude = latitude;
    }
}
