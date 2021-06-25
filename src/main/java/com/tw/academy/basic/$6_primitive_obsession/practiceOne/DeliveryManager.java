package com.tw.academy.basic.$6_primitive_obsession.practiceOne;

public class DeliveryManager {
    private final Address fromAddress1;
    private final Address toAddress1;
    String toAddress;
    String fromAddress;

    public DeliveryManager(Address toAddress, Address fromAddress) {
        fromAddress1 = fromAddress;
        this.toAddress = fromAddress1.getFromAddress();
        toAddress1 = toAddress;
        this.fromAddress = toAddress1.getFromAddress();
    }

    public DeliverCenter allocate(){
        if (getProvince(toAddress).equals(getProvince(fromAddress)) && getCity(toAddress).equals(getCity(fromAddress))){
            return DeliverCenter.LOCAL;
        }
        if (getProvince(toAddress).equals(getProvince(fromAddress))) {
            return DeliverCenter.PROVINCE;
        }
        return DeliverCenter.FOREIGN;
    }

    private String getCity(String address) {
        return address.substring(address.indexOf("Province") + 1, address.indexOf("City"));
    }

    private String getProvince(String address) {
        return address.substring(0, address.indexOf("Province"));
    }
}
