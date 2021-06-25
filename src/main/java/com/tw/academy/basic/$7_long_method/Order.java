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

    String printOrder(PrintOrderParamters printOrderParamters) {
        StringBuilder output = new StringBuilder();

        output.append(printOrderParamters.getHeader());

        output.append(getCustomerName());
        output.append(getCustomerAddress());

        double totalSalesTaxAmount = 0d;
        double totalSalesAmount = 0d;
        for (LineItem lineItem : getLineItems()) {
            printLine(printOrderParamters, output, lineItem);

            double salesTax = lineItem.totalAmount() * OrderReceipt.TAX_RATE;
            totalSalesTaxAmount += salesTax;

            totalSalesAmount += lineItem.totalAmount() + salesTax;
        }

        output.append(printOrderParamters.getSalesTaxLabel()).append(printOrderParamters.getWarpWordCharacter()).append(totalSalesTaxAmount);

        output.append(printOrderParamters.getTotalAmountLabel()).append(printOrderParamters.getWarpWordCharacter()).append(totalSalesAmount);
        return output.toString();
    }

    private void printLine(PrintOrderParamters printOrderParamters, StringBuilder output, LineItem lineItem) {
        output.append(lineItem.getDescription());
        output.append(printOrderParamters.getWarpWordCharacter());
        output.append(lineItem.getPrice());
        output.append(printOrderParamters.getWarpWordCharacter());
        output.append(lineItem.getQuantity());
        output.append(printOrderParamters.getWarpWordCharacter());
        output.append(lineItem.totalAmount());
        output.append(printOrderParamters.getWarpLineChar());
    }
}
