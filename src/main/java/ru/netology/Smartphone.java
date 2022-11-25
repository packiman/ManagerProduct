package ru.netology;

public class Smartphone extends Product {

    private String vendor;

    public String getVendor(){
        return vendor;
    }


    public Smartphone(int id,String name,String vendor,int price) {
        super(id,name,price);
        this.vendor = vendor;
    }
}
