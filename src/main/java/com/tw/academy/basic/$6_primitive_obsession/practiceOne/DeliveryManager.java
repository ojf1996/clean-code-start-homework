package com.tw.academy.basic.$6_primitive_obsession.practiceOne;

public class DeliveryManager {
    private final Address fromAddress;
    private final Address toAddress;

    public DeliveryManager(Address toAddress, Address fromAddress) {
        this.fromAddress = fromAddress;
        this.toAddress = toAddress;
    }

    public DeliverCenter allocate(){
        if (this.fromAddress.isSameProvince(this.toAddress) && this.fromAddress.isSameCity(this.toAddress)){
            return DeliverCenter.LOCAL;
        }
        if (this.fromAddress.isSameProvince(this.toAddress)) {
            return DeliverCenter.PROVINCE;
        }
        return DeliverCenter.FOREIGN;
    }

}
