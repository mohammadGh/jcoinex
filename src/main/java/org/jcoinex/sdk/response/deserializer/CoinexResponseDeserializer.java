package org.jcoinex.sdk.response.deserializer;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.type.CollectionType;
import org.jcoinex.sdk.response.entity.CoinexAsset;
import org.jcoinex.sdk.response.entity.CoinexKline;

import java.io.IOException;
import java.util.*;

public class CoinexResponseDeserializer {
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
}
