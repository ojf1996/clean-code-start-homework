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
        return this.order.printOrder(new PrintOrderParamters(HEADER, TAB, NEW_LINE, SALES_TAX_LABEL, TOTAL_AMOUNT_LABEL));
    }

}