package com.tw.academy.basic.$7_long_method;

/**
 * This class is a example for bad smell;
 *
 * @author  Thoughtworks
 * @version 1.0
 * @since   2018-1-1
 */
public class OrderReceipt {
    public static final String HEADER = "======Printing Orders======\n";
    public static final char TAB = '\t';
    public static final char NEW_LINE = '\n';
    public static final String SALES_TAX_LABEL = "Sales Tax";
    public static final String TOTAL_AMOUNT_LABEL = "Total Amount";
    public static final double TAX_RATE = .10;
    private Order order;

    public OrderReceipt(Order order) {
        this.order = order;
    }

    public String printReceipt() {
        StringBuilder output = new StringBuilder();

        output.append(HEADER);

        output.append(order.getCustomerName());
        output.append(order.getCustomerAddress());

        double totalSalesTaxAmount = 0d;
        double totalSalesAmount = 0d;
        for (LineItem lineItem : order.getLineItems()) {
            output.append(lineItem.getDescription());
            output.append(TAB);
            output.append(lineItem.getPrice());
            output.append(TAB);
            output.append(lineItem.getQuantity());
            output.append(TAB);
            output.append(lineItem.totalAmount());
            output.append(NEW_LINE);

            double salesTax = lineItem.totalAmount() * TAX_RATE;
            totalSalesTaxAmount += salesTax;

            totalSalesAmount += lineItem.totalAmount() + salesTax;
        }

        output.append(SALES_TAX_LABEL).append(TAB).append(totalSalesTaxAmount);

        output.append(TOTAL_AMOUNT_LABEL).append(TAB).append(totalSalesAmount);
        return output.toString();
    }
}