package org.jcoinex.sdk.entity.response;

import java.util.Objects;

public class CoinexAsset {

    String string;
    double available;
    double frozen;

    public CoinexAsset(){}

    public CoinexAsset(String string, double available, double frozen) {
        this.string = string;
        this.available = available;
        this.frozen = frozen;
    }

    public String getString() {
        return string;
    }

    public void setString(String string) {
        this.string = string;
    }

    public double getAvailable() {
        return available;
    }

    public void setAvailable(double available) {
        this.available = available;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CoinexAsset that = (CoinexAsset) o;
        return string == that.string;
    }

    @Override
    public int hashCode() {
        return Objects.hash(string);
    }

    @Override
    public String toString() {
        return "CoinexAsset{" +
                "string='" + string + '\'' +
                ", available=" + available +
                ", frozen=" + frozen +
                '}';
    }
}
