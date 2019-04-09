package com.felixtechlabs.restorantapplication.model;

public class Menu {

    public String title;
    public String description;
    public String imgUrl;
    public String menuId;
    public String type;
    public int price;
    public int quantity;
    public int total;
    public boolean isAvailable=true;
    public boolean selected=true;

    public Menu() {
    }

    public Menu(String title, String description, String imgUrl, String menuId, String type, int price, int quantity, int total, boolean isAvailable,boolean selected) {
        this.title = title;
        this.description = description;
        this.imgUrl = imgUrl;
        this.menuId = menuId;
        this.type = type;
        this.price = price;
        this.quantity = quantity;
        this.total = total;
        this.isAvailable = isAvailable;
        this.selected = selected;}


    public boolean isSelected() {
        return selected;
    }

    public void setSelected(boolean selected) {
        this.selected = selected;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    public String getMenuId() {
        return menuId;
    }

    public void setMenuId(String menuId) {
        this.menuId = menuId;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public void setAvailable(boolean available) {
        isAvailable = available
        ;
    }
}


