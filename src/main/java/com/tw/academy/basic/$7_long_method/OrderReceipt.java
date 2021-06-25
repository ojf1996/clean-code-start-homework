package com.tw.academy.basic.$7_long_method;

/**
 * This class is a example for bad smell;
 *
 * @author  Thoughtworks
 * @version 1.0
 * @since   2018-1-1
 */
public class OrderReceipt {
    private Order o;

    public OrderReceipt(Order o) {
        this.o = o;
    }

    public String printReceipt() {
        StringBuilder output = new StringBuilder();

        output.append("======Printing Orders======\n");

        output.append(o.getCustomerName());
        output.append(o.getCustomerAddress());

        double totSalesTx = 0d;
        double tot = 0d;
        for (LineItem lineItem : o.getLineItems()) {
            output.append(lineItem.getDescription());
            output.append('\t');
            output.append(lineItem.getPrice());
            output.append('\t');
            output.append(lineItem.getQuantity());
            output.append('\t');
            output.append(lineItem.totalAmount());
            output.append('\n');

            double salesTax = lineItem.totalAmount() * .10;
            totSalesTx += salesTax;

            tot += lineItem.totalAmount() + salesTax;
        }

        output.append("Sales Tax").append('\t').append(totSalesTx);

        output.append("Total Amount").append('\t').append(tot);
        return output.toString();
    }
}