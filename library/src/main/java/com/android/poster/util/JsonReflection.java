package com.android.poster.util;

import com.android.poster.detail.ProblemDetail;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.type.CollectionType;
import com.google.gson.JsonParser;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Reflection of json string to object
 * @author Virendra
 * @since 19-Aug-2024
 */
public class JsonReflection<T>
{
    /**
     * This method is called from preparing the API response, it always creates the response as list
     * @param jsonData
     * @param tClass
     * @return the response as list
     * @throws IOException
     */
    public List<T> getList(String jsonData, Class<T> tClass) throws IOException
    {
        if (JsonParser.parseString((jsonData)).isJsonArray()) // ARRAY
            return jsonArrayToList(jsonData, tClass);
        else // OBJECT
            return jsonObjectToList(jsonData, tClass);
    }

    /**
     * Convert the array of jsonData into object list
     * @param jsonData
     * @param tClass
     * @return the response as list
     * @throws IOException
     */
    public List<T> jsonArrayToList(String jsonData, Class<T> tClass) throws IOException {
        final ObjectMapper mapper = new ObjectMapper();
        mapper.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
        final CollectionType listType = mapper.getTypeFactory().constructCollectionType(ArrayList.class, tClass);
        final List<T> list = mapper.readValue(jsonData, listType);
        return list;
    }

    /**
     * Convert the jsonData into object list
     * @param jsonData
     * @param tClass
     * @return the response as list
     * @throws IOException
     */
    public List<T> jsonObjectToList(String jsonData, Class<T> tClass) throws IOException {
        final ObjectMapper mapper = new ObjectMapper();
        mapper.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
        if(jsonData.contains("errorMessage") || jsonData.contains("successMessage")&& !jsonData.contains("username"))
        {
            final List<ProblemDetail> newList = new ArrayList<>();
            newList.add(mapper.readValue(jsonData, ProblemDetail.class));
            return (List<T>) newList;
        }else {
            final List<T> newList = new ArrayList<>();
            newList.add(mapper.readValue(jsonData, tClass));
            return newList;
        }
    }
}
