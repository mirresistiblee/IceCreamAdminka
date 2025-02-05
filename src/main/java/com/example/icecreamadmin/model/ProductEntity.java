package com.example.icecreamadmin.model;

import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public class ProductEntity {
    private String title;
    private String shortInfo;
    private String description;
    private double price;
    private String currency;
    private double oldPrice;
    private String sku;
    private boolean outOfStock;
    private boolean featured;
    private String categories;
    private String imageUrl;
    private String id;

    // Constructor

    public ProductEntity(String title, String shortInfo, String description, Double price, String currency, Double oldPrice, String sku, Boolean outOfStock, Boolean featured, String categories, String imageUrl) {
        this.title = title;
        this.shortInfo = shortInfo;
        this.description = description;
        this.price = price;
        this.currency = currency;
        this.oldPrice = oldPrice;
        this.sku = sku;
        this.outOfStock = outOfStock;
        this.featured = featured;
        this.categories = categories;
        this.imageUrl = imageUrl;
        this.id = id;
    }

    public ProductEntity() {

    }

    // Getters and setters
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getShortInfo() {
        return shortInfo;
    }

    public void setShortInfo(String shortInfo) {
        this.shortInfo = shortInfo;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public double getOldPrice() {
        return oldPrice;
    }

    public void setOldPrice(double oldPrice) {
        this.oldPrice = oldPrice;
    }

    public String getSku() {
        return sku;
    }

    public void setSku(String sku) {
        this.sku = sku;
    }

    public boolean isOutOfStock() {
        return outOfStock;
    }

    public void setOutOfStock(boolean outOfStock) {
        this.outOfStock = outOfStock;
    }

    public boolean isFeatured() {
        return featured;
    }

    public void setFeatured(boolean featured) {
        this.featured = featured;
    }

    public String getCategories() {
        return categories;
    }

    public void setCategories(String categories) {
        this.categories = categories;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
