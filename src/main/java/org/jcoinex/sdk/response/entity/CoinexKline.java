package org.jcoinex.sdk.response.entity;

import com.fasterxml.jackson.annotation.JsonCreator;

public class CoinexKline {
     long timestamp;
     double openingPrice;
     double closingPrice;
     double highestPrice;
     double lowestPrice;
     double volume;
     double amount;
     String market;

     public  CoinexKline(){}

    @JsonCreator
    public CoinexKline(long timestamp, double openingPrice, double closingPrice, double highestPrice, double lowestPrice, double volume, double amount, String market) {
        this.timestamp = timestamp;
        this.openingPrice = openingPrice;
        this.closingPrice = closingPrice;
        this.highestPrice = highestPrice;
        this.lowestPrice = lowestPrice;
        this.volume = volume;
        this.amount = amount;
        this.market = market;
    }

    public long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(long timestamp) {
        this.timestamp = timestamp;
    }

    public double getOpeningPrice() {
        return openingPrice;
    }

    public void setOpeningPrice(double openingPrice) {
        this.openingPrice = openingPrice;
    }

    public double getClosingPrice() {
        return closingPrice;
    }

    public void setClosingPrice(double closingPrice) {
        this.closingPrice = closingPrice;
    }

    public double getHighestPrice() {
        return highestPrice;
    }

    public void setHighestPrice(double highestPrice) {
        this.highestPrice = highestPrice;
    }

    public double getLowestPrice() {
        return lowestPrice;
    }

    public void setLowestPrice(double lowestPrice) {
        this.lowestPrice = lowestPrice;
    }

    public double getVolume() {
        return volume;
    }

    public void setVolume(double volume) {
        this.volume = volume;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public String getMarket() {
        return market;
    }

    public void setMarket(String market) {
        this.market = market;
    }
}
