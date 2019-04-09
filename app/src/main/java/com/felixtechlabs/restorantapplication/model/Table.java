package com.felixtechlabs.restorantapplication.model;

public class Table {

    int tableNumbers;
    String tableStatus;
    boolean isAvailable = true;
    String tableId;
    public String imgUrl;

    public Table() {
    }

    public Table(int tableNumbers, String tableStatus, boolean isAvailable, String tableId, String imgUrl) {
        this.tableNumbers = tableNumbers;
        this.tableStatus = tableStatus;
        this.isAvailable = isAvailable;
        this.tableId = tableId;
        this.imgUrl = imgUrl;
    }

    public int getTableNumbers() {
        return tableNumbers;
    }

    public void setTableNo(int tableNo) {
        this.tableNumbers = tableNo;
    }

    public String getTableStatus() {
        return tableStatus;
    }

    public void setTableStatus(String tableStatus) {
        this.tableStatus = tableStatus;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public void setAvailable(boolean available) {
        isAvailable = available;
    }

    public String getTableId() {
        return tableId;
    }

    public void setTableId(String tableId) {
        this.tableId = tableId;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }
}


