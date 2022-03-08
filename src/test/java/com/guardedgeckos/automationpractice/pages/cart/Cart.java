package com.guardedgeckos.automationpractice.pages.cart;

public class Cart {
    //region Variables
    private String name;
    private String color;
    private String size;
    private String available;
    private double singlePrice;
    private long quantity;
    private double allPrice;
    private double shipping;
    //endregion

    //region Constructor
    public Cart(String name, String color, String size, String available, double singlePrice, long quantity, double allPrice, double shipping) {
        this.name = name;
        this.color = color;
        this.size = size;
        this.available = available;
        this.singlePrice = singlePrice;
        this.quantity = quantity;
        this.allPrice = allPrice;
        this.shipping = shipping;
    }
    //endregion

    // region Getters
    public String getName() {
        return name;
    }

    public String getColor() {
        return color;
    }
    public String getSize() {
        return size;
    }
    public String getAvailable() {
        return available;
    }
    public double getSinglePrice() {
        return singlePrice;
    }
    public long getQuantity() {
        return quantity;
    }
    public double getAllPrice() {
        return allPrice;
    }
    public double getShipping() {
        return shipping;
    }
    // endregion

    // region Setters
    public void setName(String name) {
        this.name = name;
    }
    public void setColor(String color) {
        this.color = color;
    }
    public void setSize(String size) {
        this.size = size;
    }
    public void setAvailable(String available) {
        this.available = available;
    }
    public void setSinglePrice(double singlePrice) {
        this.singlePrice = singlePrice;
    }
    public void setQuantity(long quantity) {
        this.quantity = quantity;
    }
    public void setAllPrice(double allPrice) {
        this.allPrice = allPrice;
    }
    public void setShipping(double shipping) {
        this.shipping = shipping;
    }
    // endregion
}
