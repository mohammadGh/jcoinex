package org.jcoinex.sdk;


import org.apache.http.HttpException;
import org.jcoinex.sdk.api.StockApi;
import org.jcoinex.sdk.response.entity.CoinexAsset;
import org.jcoinex.sdk.response.entity.CoinexKline;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class StockApiTest {
    final static String ACCESS_ID="";
    final static String SECRET_KEY="";
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

    @Test
    public void GetKline(){
        List<CoinexKline> klines = null;
        try {
            klines = stockApi.GetKline("YFIUSDT","30min");
        } catch (HttpException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        Logger.getGlobal().log(Level.INFO, klines.toString());
    }

    @Test
    public void GetKLinesTest(){
        String balance = null;
        try {
            balance = stockApi.kline("YFIUSDT","30min");
        } catch (HttpException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        Logger.getGlobal().log(Level.INFO, balance);
    }

    @Test
    public void getUnexecutedOrdersTest(){
        String unexecutedOrders = null;
        try {
            unexecutedOrders = stockApi.getUnexecutedOrders("YFIUSDT",1,10,0);
        } catch (HttpException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        Logger.getGlobal().log(Level.INFO, unexecutedOrders);
    }

    @Test
    public void putLimitOrderTest(){
        String responseOfPutOrder = null;
        try {
            responseOfPutOrder = stockApi.putLimitOrder("YFIUSDT", StockApi.ORDER_TYPE.ORDER_TYPE_BUY,0.01f,27900f);
        } catch (HttpException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        Logger.getGlobal().log(Level.INFO, responseOfPutOrder);
    }

    @Test
    public void cancellAnOrder(){
        String responseOfCancellOrder = null;
        String orderId="28912150999";
        try {
            responseOfCancellOrder = stockApi.cancelOrder("YFIUSDT",orderId);
        } catch (HttpException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        Logger.getGlobal().log(Level.INFO, responseOfCancellOrder);
    }

    @Test
    public void cancellAllOrder(){
        String responseOfCancellAllOrder = null;
        try {
            responseOfCancellAllOrder = stockApi.cancelAllOrder("YFIUSDT",0);
        } catch (HttpException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        Logger.getGlobal().log(Level.INFO, responseOfCancellAllOrder);
    }

    @Test
    public void getTonceTest(){
        Logger.getGlobal().log(Level.INFO, stockApi.getTonce());
    }
}
