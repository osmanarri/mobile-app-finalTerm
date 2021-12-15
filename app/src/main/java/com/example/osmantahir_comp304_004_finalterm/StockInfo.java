package com.example.osmantahir_comp304_004_finalterm;

import androidx.annotation.NonNull;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class StockInfo {
    @PrimaryKey
    @NonNull
    private String stockSymbol; //primary key
    private String companyName;
    private double stockQuote;

    public StockInfo(String stockSymbol, String companyName, double stockQuote) {
        this.stockSymbol = stockSymbol;
        this.companyName = companyName;
        this.stockQuote = stockQuote;
    }

    public StockInfo() {
    }

    public String getStockSymbol() {
        return stockSymbol;
    }

    public void setStockSymbol(String stockSymbol) {
        this.stockSymbol = stockSymbol;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public double getStockQuote() {
        return stockQuote;
    }

    public void setStockQuote(double stockQuote) {
        this.stockQuote = stockQuote;
    }
}


