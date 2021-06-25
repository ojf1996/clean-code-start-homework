package com.tw.academy.basic.$6_primitive_obsession.practiceOne;

public class Address {
    private final String fromAddress;

    public Address(String fromAddress) {
        this.fromAddress = fromAddress;
    }

    public String getFromAddress() {
        return fromAddress;
    }

    String getProvince() {
        String address = getFromAddress();
        return address.substring(0, address.indexOf("Province"));
    }
}
