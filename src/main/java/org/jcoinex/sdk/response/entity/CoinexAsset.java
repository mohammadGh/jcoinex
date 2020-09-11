package org.jcoinex.sdk.response.entity;

import java.util.Objects;

public class CoinexAsset {

    String coin;
    double available;
    double frozen;

    public CoinexAsset(){}

    public CoinexAsset(String coin, double available, double frozen) {
        this.coin = coin;
        this.available = available;
        this.frozen = frozen;
    }

    public String getCoin() {
        return coin;
    }

    public void setCoin(String coin) {
        this.coin = coin;
    }

    public double getAvailable() {
        return available;
    }

    public void setAvailable(double available) {
        this.available = available;
    }

    public double getFrozen() {
        return frozen;
    }

    public void setFrozen(double frozen) {
        this.frozen = frozen;
    }
}
