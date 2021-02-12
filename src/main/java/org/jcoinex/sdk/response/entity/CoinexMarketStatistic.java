package org.jcoinex.sdk.response.entity;

public class CoinexMarketStatistic {
    double vol;
    double low;
    double open;
    double high;
    double last;
    double buy;
    double buyAmount;
    double sell;
    double sellAmount;

    public double getVol() {
        return vol;
    }

    public void setVol(double vol) {
        this.vol = vol;
    }

    public double getLow() {
        return low;
    }

    public void setLow(double low) {
        this.low = low;
    }

    public double getOpen() {
        return open;
    }

    public void setOpen(double open) {
        this.open = open;
    }

    public double getHigh() {
        return high;
    }

    public void setHigh(double high) {
        this.high = high;
    }

    public double getLast() {
        return last;
    }

    public void setLast(double last) {
        this.last = last;
    }

    public double getBuy() {
        return buy;
    }

    public void setBuy(double buy) {
        this.buy = buy;
    }

    public double getBuyAmount() {
        return buyAmount;
    }

    public void setBuyAmount(double buyAmount) {
        this.buyAmount = buyAmount;
    }

    public double getSell() {
        return sell;
    }

    public void setSell(double sell) {
        this.sell = sell;
    }

    public double getSellAmount() {
        return sellAmount;
    }

    public void setSellAmount(double sellAmount) {
        this.sellAmount = sellAmount;
    }

    @Override
    public String toString() {
        return "CoinexMarketStatistic{" +
                "vol=" + vol +
                ", low=" + low +
                ", open=" + open +
                ", high=" + high +
                ", last=" + last +
                ", buy=" + buy +
                ", buyAmount=" + buyAmount +
                ", sell=" + sell +
                ", sellAmount=" + sellAmount +
                '}';
    }
}
