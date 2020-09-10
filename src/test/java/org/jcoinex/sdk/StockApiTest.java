package org.jcoinex.sdk;


import org.apache.http.HttpException;
import org.jcoinex.sdk.api.StockApi;
import org.jcoinex.sdk.entity.response.CoinexAsset;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class StockApiTest {
    final static String ACCESS_ID="D6A86903737949AC8560C2F6B1C631D4";
    final static String SECRET_KEY="1CBA02A24B1F3EC3ACAC30CCFC2A13FDD62BB66B4BBE69EF";
    final static String BASE_URL="https://api.coinex.com/v1/";

    private static StockApi stockApi;

    @BeforeAll
    public static void makeStockApi(){
        if(stockApi==null)
            stockApi= new StockApi(BASE_URL, ACCESS_ID, SECRET_KEY);
    }

    @Test
    public void GetBalanceTest(){
        List<CoinexAsset> assets = null;
        try {
            assets = stockApi.getAssets();
        } catch (HttpException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        for(CoinexAsset asset:assets)
            Logger.getGlobal().log(Level.INFO, asset.toString());
    }

    @Test
    public void GetBalance2Test(){
        String balance = null;
        try {
            balance = stockApi.getBalance();
        } catch (HttpException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        Logger.getGlobal().log(Level.INFO, balance);
    }
}
