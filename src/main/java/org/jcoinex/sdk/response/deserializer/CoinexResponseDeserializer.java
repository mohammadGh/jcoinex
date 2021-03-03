package org.jcoinex.sdk.response.deserializer;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.type.CollectionType;
import org.jcoinex.sdk.response.entity.CoinexAsset;
import org.jcoinex.sdk.response.entity.CoinexKline;
import org.jcoinex.sdk.response.entity.CoinexMarketStatistic;
import org.jcoinex.sdk.response.entity.CoinexUnexecutedOrder;

import java.io.IOException;
import java.util.*;

public class CoinexResponseDeserializer {
    public static List<String> deserializeToMarketStrings(String marketJson) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        JsonNode json = mapper.readTree(marketJson);
        String dataPartJson = json.get("data").toString();

        TypeReference<List<String>> typeRef
                = new TypeReference<List<String>>() {};

        List<String> marketList=mapper.readValue(dataPartJson,typeRef);

        return marketList;
    }

    public static CoinexMarketStatistic deserializeToMarketStatistic(String json) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        JsonNode jsonNode = mapper.readTree(json);
        String dataPartJson = jsonNode.get("data").get("ticker").toString();

        TypeReference<CoinexMarketStatistic> typeRef
                = new TypeReference<CoinexMarketStatistic>() {};

        CoinexMarketStatistic orders=mapper.readValue(dataPartJson,typeRef);

        return orders;
    }
    public static List<CoinexAsset> deserializeToAsset(String assetsJson) throws IOException {
        ObjectMapper mapper = new ObjectMapper();

        JsonNode json = mapper.readTree(assetsJson);

        String dataPartJson = json.get("data").toString();

        TypeReference<HashMap<String, CoinexAsset>> typeRef
                = new TypeReference<HashMap<String, CoinexAsset>>() {};

        HashMap<String, CoinexAsset> assetsMap=mapper.readValue(dataPartJson,typeRef);

        List<CoinexAsset> assetList=new ArrayList<>(assetsMap.size());
        for (Map.Entry<String, CoinexAsset> entry : assetsMap.entrySet()) {
            assetList.add(new CoinexAsset(entry.getKey(),entry.getValue().getAvailable(),entry.getValue().getFrozen()));
        }
        return assetList;
    }

    public static List<CoinexKline> deserializeToKlines(String klinejson) throws IOException {
        ObjectMapper mapper = new ObjectMapper();

        JsonNode json = mapper.readTree(klinejson);

        JsonNode dataNode = json.get("data");

        List<CoinexKline> klineList=new ArrayList<>();
        for (Iterator<JsonNode> it = dataNode.elements(); it.hasNext(); ) {
            JsonNode arrayElement = it.next();

            long timestamp=arrayElement.get(0).asLong();
            double openingPrice=arrayElement.get(1).asDouble();
            double closingPrice=arrayElement.get(2).asDouble();
            double highestPrice=arrayElement.get(3).asDouble();
            double lowestPrice=arrayElement.get(4).asDouble();
            double volume=arrayElement.get(5).asDouble();
            double amount=arrayElement.get(6).asDouble();
            String market=arrayElement.get(7).toString();

            klineList.add(new CoinexKline(timestamp,openingPrice,closingPrice,highestPrice,lowestPrice,volume,amount,market));
        }
        return  klineList;
    }

    public static List<CoinexUnexecutedOrder> deserializeToUnexecutedOrders(String json) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);

        JsonNode jsonNode = mapper.readTree(json);

        String dataPartJson = jsonNode.get("data").get("data").toString();

        TypeReference<List<CoinexUnexecutedOrder>> typeRef
                = new TypeReference<List<CoinexUnexecutedOrder>>() {};

        List<CoinexUnexecutedOrder> orders=mapper.readValue(dataPartJson,typeRef);

        return orders;
    }

    public static long deserializeDataAsLong(String jsonStr) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        JsonNode json = mapper.readTree(jsonStr);
        String dataPartJson = json.get("data").toString();
        return Long.valueOf(dataPartJson);
    }
}
