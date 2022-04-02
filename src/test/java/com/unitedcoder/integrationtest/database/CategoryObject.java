package com.unitedcoder.integrationtest.database;

public class CategoryObject {
    private String catName;
    private String catDesc;
    private int catParentId;
    private int catImage;
    private double perShip;
    private double itemShip;
    private double itemIntShip;
    private double perIntShip;
    private int hide;
    private String seoMetaTitle;
    private String seoMetaDescription;
    private String seoMetaKeywords;
    private int priority;
    private int status;

    public CategoryObject(String catName, String catDesc, int catParentId, int catImage, double perShip, double itemShip, double itemIntShip, double perIntShip, int hide, String seoMetaTitle, String seoMetaDescription, String seoMetaKeywords, int priority, int status) {
        this.catName = catName;
        this.catDesc = catDesc;
        this.catParentId = catParentId;
        this.catImage = catImage;
        this.perShip = perShip;
        this.itemShip = itemShip;
        this.itemIntShip = itemIntShip;
        this.perIntShip = perIntShip;
        this.hide = hide;
        this.seoMetaTitle = seoMetaTitle;
        this.seoMetaDescription = seoMetaDescription;
        this.seoMetaKeywords = seoMetaKeywords;
        this.priority = priority;
        this.status = status;
    }

    public String getCatName() {
        return catName;
    }

    public String getCatDesc() {
        return catDesc;
    }

    public int getCatParentId() {
        return catParentId;
    }

    public int getCatImage() {
        return catImage;
    }

    public double getPerShip() {
        return perShip;
    }

    public double getItemShip() {
        return itemShip;
    }

    public double getItemIntShip() {
        return itemIntShip;
    }

    public double getPerIntShip() {
        return perIntShip;
    }

    public int getHide() {
        return hide;
    }

    public String getSeoMetaTitle() {
        return seoMetaTitle;
    }

    public String getSeoMetaDescription() {
        return seoMetaDescription;
    }

    public String getSeoMetaKeywords() {
        return seoMetaKeywords;
    }

    public int getPriority() {
        return priority;
    }

    public int getStatus() {
        return status;
    }

    @Override
    public String toString() {
        return "CategoryObject{" +
                "catName='" + catName + '\'' +
                ", catDesc='" + catDesc + '\'' +
                ", catParentId=" + catParentId +
                ", catImage=" + catImage +
                ", perShip=" + perShip +
                ", itemShip=" + itemShip +
                ", itemIntShip=" + itemIntShip +
                ", perIntShip=" + perIntShip +
                ", hide=" + hide +
                ", seoMetaTitle='" + seoMetaTitle + '\'' +
                ", seoMetaDescription='" + seoMetaDescription + '\'' +
                ", seoMetaKeywords='" + seoMetaKeywords + '\'' +
                ", priority=" + priority +
                ", status=" + status +
                '}';
    }
}
