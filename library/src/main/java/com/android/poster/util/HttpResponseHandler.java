package com.android.poster.util;

import com.android.poster.delegate.AbstractServiceDelegate;
import com.android.poster.response.APIResponse;
import okhttp3.Response;

import java.io.IOException;
import java.util.Map;

/**
 * This class is used to handle the response
 * @author Virendra
 * @since 19-Aug-2024
 */
public class HttpResponseHandler
{
    /**
     * This method is used to handle the response after getting response from server
     * @param response
     * @param output
     * @param serviceDelegate
     * @param startTime
     * @return the APIResponse
     * @throws IOException
     */
    public APIResponse handleResponse(Response response, Class output, AbstractServiceDelegate serviceDelegate, long startTime) throws IOException
    {
        final String jsonData = response.body().string();
        DebugLogger.print("############# API RESPONSE [" + serviceDelegate.getApiEndpoint() + "] ################ \n" + jsonData);
        if(jsonData == null)
            return customResponse("Empty response from server", 420, startTime);

        final int version = response.headers().toMultimap().containsKey("version") ? Integer.parseInt(response.headers().toMultimap().get("version").get(0)) : 0;
        if(StatusCode.getInstance().exist(response.code()) != null)
            return APIResponse.builder()
                    .dataList(new JsonReflection().errorList(StatusCode.getInstance().exist(response.code())))
                    .statusCode(response.code())
                    .executionTime(System.currentTimeMillis() - startTime)
                    .version(version)
                    .build();
        else
            return APIResponse.builder()
                    .dataList(new JsonReflection().getList(jsonData, output))
                    .statusCode(response.code())
                    .executionTime(System.currentTimeMillis() - startTime)
                    .version(version)
                    .build();
    }

    /**
     * Call this method in case you want to return any custom message as a response
     * @param message
     * @param statusCode
     * @param startTime
     * @return the APIResponse
     */
    public APIResponse customResponse(String message, int statusCode, long startTime)
    {
        return APIResponse.builder()
                .dataList(new JsonReflection().errorList(message))
                .statusCode(statusCode)
                .executionTime(System.currentTimeMillis() - startTime)
                .build();
    }
}

/**
 * Custom response message based on status code.
 */
class StatusCode
{
    private static StatusCode statusCode;

    /**
     * Add status code with default message which you want to send as response to client side if status code match from these
     */
    private final Map<Integer, String> errorMap = Map.of(
            500, "We are unable to process your request. Please try after some time.",
            503, "Unable to connect with the server. Please try after some time.", //server is down
            404, "Unable to connect with the server. Please try after some time." //not reachable (tomcat error)
    );

    public static StatusCode getInstance()
    {
        if(statusCode == null)
        {
            statusCode = new StatusCode();
        }
        return statusCode;
    }

    /**
     * return value of key
     * @param key
     * @return  return value of key
     */
    public String exist(int key)
    {
        return errorMap.get(key);
    }
}
