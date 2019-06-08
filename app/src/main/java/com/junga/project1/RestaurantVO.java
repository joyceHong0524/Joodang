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

    public String getAreaName(){
        return areaName;
    }

    public void setAreaName(String areaName){
        this.areaName = areaName;
    }

    public RestaurantVO(String areaName,int drawable, String name, String attr, String star, String dongName, String closeTime) {
        this.areaName = areaName;
        this.drawable = drawable;
        this.name = name;
        this.attr = attr;
        this.star = star;
        this.dongName = dongName;
        this.closeTime = closeTime;
    }


//This is for Place information Page

}
