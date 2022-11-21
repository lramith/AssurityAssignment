package com.assurityconsulting.functions;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.assurityconsulting.data.Item;
import com.assurityconsulting.util.RequestUtil;;

import static com.assurityconsulting.common.Constants.*;

public class APIDetails {

    public static Item getDetailsFromItemAPI(String itemNumber, boolean isCatalogue) throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        return mapper.readValue(RequestUtil.get(GET_ITEM_URL.replace(ITEM_TEXT, itemNumber).replace(CATALOGUE_TEXT, String.valueOf(isCatalogue))), Item.class);
    }
}
