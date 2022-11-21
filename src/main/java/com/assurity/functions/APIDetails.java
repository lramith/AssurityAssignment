package com.assurity.functions;

import com.assurity.data.Item;
import com.assurity.util.RequestUtil;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

import static com.assurity.common.Constants.*;

/**
 * <h1>API Details Class</h1>
 * This class is the functional class to holds functional methods for API requests
 *
 * @author Ramith Wanniarachchi
 */
public class APIDetails {

    /**
     * This method is used to get API details, and deserialize into Item object.
     *
     * @param itemNumber  Item number for the request
     * @param isCatalogue Catalogue flag for the request
     * @return Item object with API details
     */
    public static Item getDetailsFromItemAPI(String itemNumber, boolean isCatalogue) throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        return mapper.readValue(RequestUtil.get(GET_ITEM_URL.replace(ITEM_TEXT, itemNumber).replace(CATALOGUE_TEXT, String.valueOf(isCatalogue))), Item.class);
    }
}
