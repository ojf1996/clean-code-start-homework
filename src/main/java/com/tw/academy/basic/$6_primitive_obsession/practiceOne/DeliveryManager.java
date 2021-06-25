package com.tw.academy.basic.$6_primitive_obsession.practiceOne;

public class DeliveryManager {
    private final Address fromAddress;
    private final Address toAddress;

    public DeliveryManager(Address toAddress, Address fromAddress) {
        this.fromAddress = fromAddress;
        this.toAddress = toAddress;
    }

    public DeliverCenter allocate(){
        if (getProvince(fromAddress.getFromAddress()).equals(getProvince(toAddress.getFromAddress())) && getCity(fromAddress.getFromAddress()).equals(getCity(toAddress.getFromAddress()))){
            return DeliverCenter.LOCAL;
        }
        if (getProvince(fromAddress.getFromAddress()).equals(getProvince(toAddress.getFromAddress()))) {
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
