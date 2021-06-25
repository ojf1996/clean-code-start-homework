package com.tw.academy.basic.$7_long_method;

import java.util.List;

public class Order {
    String customerName;
    String address;
    List<LineItem> lineItems;

    public Order(String customerName, String address, List<LineItem> lineItems) {
        this.customerName = customerName;
        this.address = address;
        this.lineItems = lineItems;
    }

    public String getCustomerName() {
        return customerName;
    }

    public String getCustomerAddress() {
        return address;
    }

    public List<LineItem> getLineItems() {
        return lineItems;
    }

    String printOrder(PrintOrderParameters printOrderParameters) {
        StringBuilder output = new StringBuilder();

        output.append(printOrderParameters.getHeader());

        output.append(getCustomerName());
        output.append(getCustomerAddress());

        double totalSalesTaxAmount = 0d;
        double totalSalesAmount = 0d;

        for (LineItem lineItem : getLineItems()) {
            output.append(lineItem.printLine(printOrderParameters));
        }

        for (LineItem lineItem : getLineItems()) {
            double salesTax = lineItem.getSalesTax(OrderReceipt.TAX_RATE);
            totalSalesTaxAmount += salesTax;

            totalSalesAmount += lineItem.totalAmount() + salesTax;
        }

        output.append(printOrderParameters.getSalesTaxLabel()).append(printOrderParameters.getWarpWordCharacter()).append(totalSalesTaxAmount);

        output.append(printOrderParameters.getTotalAmountLabel()).append(printOrderParameters.getWarpWordCharacter()).append(totalSalesAmount);
        return output.toString();
    }

}
