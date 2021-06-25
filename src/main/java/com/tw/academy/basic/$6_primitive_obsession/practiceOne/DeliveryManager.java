package com.tw.academy.basic.$6_primitive_obsession.practiceOne;

public class DeliveryManager {
    private final Address fromAddress1;
    private final Address toAddress1;

    public DeliveryManager(Address toAddress, Address fromAddress) {
        fromAddress1 = fromAddress;
        toAddress1 = toAddress;
    }

    public DeliverCenter allocate(){
        if (getProvince(fromAddress1.getFromAddress()).equals(getProvince(toAddress1.getFromAddress())) && getCity(fromAddress1.getFromAddress()).equals(getCity(toAddress1.getFromAddress()))){
            return DeliverCenter.LOCAL;
        }
        if (getProvince(fromAddress1.getFromAddress()).equals(getProvince(toAddress1.getFromAddress()))) {
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
