package com.tw.academy.basic.$5_data_clumps;

public class Order {

    private int orderNumber;

    private String buyerName;
    private String buyerPhoneNumber;
    private String buyerAddress;

    public Order(int orderNumber, Buyer buyer) {
        this.orderNumber = orderNumber;

        this.buyerName = buyer.getBuyerName();
        this.buyerPhoneNumber = buyer.getBuyerPhoneNumber();
        this.buyerAddress = buyer.getBuyerAddress();
    }

    public String confirm(){
        return String.format("Please confirm buyer information: buyer name is %s, " +
                "buyer phone number is %s and buyer address is %s.", buyerName, buyerPhoneNumber, buyerAddress);
    }
}

