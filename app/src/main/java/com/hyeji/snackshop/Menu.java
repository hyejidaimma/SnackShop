package com.hyeji.snackshop;

public class Menu {
    private String name;
    private int price;
    private String description;

    public Menu(){
        this.name = "라면";
        this.price = 10000;
        this.description = "맛있는 라면";
    }
    public Menu(String Name, int Price, String description){
        this.name = Name;
        this.price = Price;
        this.description = description;
    }
    public Menu(String Name, int Price){
        this.name = Name;
        this.price = Price;
        this.description = "맛있는 라면";
    }
    public int totalPrice(int price, int count){
        return price * count;
    }
    public String getName() {
        return name;
    }
    public int getPrice() {
        return price;
    }
    public String getDescription() {
        return description;
    }
    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public void setDescription(String description) {
        this.description = description;
    }

}

