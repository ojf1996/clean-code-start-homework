package com.tw.academy.basic.$7_long_method;

public class PrintOrderParameters {
    private final String header;
    private final char warpWordCharacter;
    private final char warpLineChar;
    private final String salesTaxLabel;
    private final String totalAmountLabel;

    public PrintOrderParameters(String header, char tab, char newLine, String salesTaxLabel, String totalAmountLabel) {
        this.header = header;
        warpWordCharacter = tab;
        warpLineChar = newLine;
        this.salesTaxLabel = salesTaxLabel;
        this.totalAmountLabel = totalAmountLabel;
    }

    public String getHeader() {
        return header;
    }

    public char getWarpWordCharacter() {
        return warpWordCharacter;
    }

    public char getWarpLineChar() {
        return warpLineChar;
    }

    public String getSalesTaxLabel() {
        return salesTaxLabel;
    }

    public String getTotalAmountLabel() {
        return totalAmountLabel;
    }
}
