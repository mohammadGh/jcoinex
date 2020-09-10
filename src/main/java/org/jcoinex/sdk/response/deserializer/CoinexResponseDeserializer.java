package org.jcoinex.sdk.response.deserializer;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.type.CollectionType;
import com.sun.xml.internal.ws.util.xml.CDATA;
import org.jcoinex.sdk.entity.response.CoinexAsset;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CoinexResponseDeserializer {
    public static List<CoinexAsset> deserializeToAsset(String assetsJson) throws IOException {
        ObjectMapper mapper = new ObjectMapper();

        JsonNode json = mapper.readTree(assetsJson);

        String dataPartJson = json.get("data").toString();

        CollectionType javaType = mapper.getTypeFactory()
                .constructCollectionType(List.class, CoinexAsset.class);
        List<CoinexAsset> asList = mapper.readValue(assetsJson, javaType);

        return new ArrayList<>();
    }
}
