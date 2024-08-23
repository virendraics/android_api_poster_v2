package com.android.poster.util;

import com.android.poster.detail.MessageDetail;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonParser;
import com.google.gson.JsonSyntaxException;

import java.io.IOException;
import java.util.Collections;
import java.util.List;

/**
 * Reflection of json string to object
 * @author Virendra
 * @since 19-Aug-2024
 */
public class JsonReflection<T>
{
    Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd'T'HH:mm:ss").create();

    /**
     * This method is called from preparing the API response, it always creates the response as list
     * @param jsonData
     * @param tClass
     * @return the response as list
     * @throws IOException
     */
    public List<?> getList(String jsonData, Class<T> tClass) throws IOException
    {
        if(jsonData.contains("errorMessage") || jsonData.contains("successMessage")&& !jsonData.contains("username"))
            return getObjectListFromJson(jsonData, MessageDetail.class);
        else
            return getObjectListFromJson(jsonData, tClass);
    }

    private List<?> getObjectListFromJson(String jsonData, Class tClass)
    {
        try {
            if (JsonParser.parseString((jsonData)).isJsonArray()) // ARRAY
                return jsonArrayToList(jsonData, tClass);
            else // OBJECT
                return jsonObjectToList(jsonData, tClass);
        } catch (JsonSyntaxException e) {
            System.out.println("===>>>"+jsonData);
            e.printStackTrace();
        }
        return null;
    }

    /**
     * Convert the array of jsonData into object list
     * @param jsonData
     * @param tClass
     * @return the response as list
     * @throws JsonSyntaxException
     */
    public List<?> jsonArrayToList(String jsonData, Class tClass) throws JsonSyntaxException {
        return gson.fromJson(jsonData, new TypeOfList<T>(tClass));
    }

    /**
     * Convert the jsonData into object list
     * @param jsonData
     * @param tClass
     * @return the response as list
     * @throws JsonSyntaxException
     */
    public List<T> jsonObjectToList(String jsonData, Class tClass) throws JsonSyntaxException {
        return Collections.singletonList((T) gson.fromJson(jsonData, tClass));
    }

    /**
     * This is used to create custom message response
     * @param errorMessage
     * @return the error in list
     */
    public List<T> errorList(String errorMessage)
    {
        final MessageDetail messageDetail = new MessageDetail();
        messageDetail.setErrorMessage(errorMessage);
        return (List<T>)Collections.singletonList(messageDetail);
    }
}
