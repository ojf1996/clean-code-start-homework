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

    String printOrder(String header, char tab, char newLine, String salesTaxLabel, String totalAmountLabel) {
        StringBuilder output = new StringBuilder();

        output.append(header);

        output.append(getCustomerName());
        output.append(getCustomerAddress());

        double totalSalesTaxAmount = 0d;
        double totalSalesAmount = 0d;
        for (LineItem lineItem : getLineItems()) {
            output.append(lineItem.getDescription());
            output.append(tab);
            output.append(lineItem.getPrice());
            output.append(tab);
            output.append(lineItem.getQuantity());
            output.append(tab);
            output.append(lineItem.totalAmount());
            output.append(newLine);

            double salesTax = lineItem.totalAmount() * OrderReceipt.TAX_RATE;
            totalSalesTaxAmount += salesTax;

            totalSalesAmount += lineItem.totalAmount() + salesTax;
        }

        output.append(salesTaxLabel).append(tab).append(totalSalesTaxAmount);

        output.append(totalAmountLabel).append(tab).append(totalSalesAmount);
        return output.toString();
    }
}
