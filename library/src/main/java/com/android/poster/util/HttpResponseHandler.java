package com.android.poster.util;

import com.android.poster.delegate.AbstractServiceDelegate;
import com.android.poster.detail.Detail;
import com.android.poster.detail.ProblemDetail;
import com.android.poster.response.APIResponse;
import okhttp3.Response;

import java.io.IOException;
import java.util.Collections;
import java.util.List;

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
        DebugLogger.print("############# SERVER RESPONSE [" + serviceDelegate.getApiEndpoint() + "] ################ \n" + jsonData);
        if(jsonData == null)
            return customResponse("Empty response from server", 420, startTime);

        final int version = response.headers().toMultimap().containsKey("version") ? Integer.parseInt(response.headers().toMultimap().get("version").get(0)) : 0;
        if(response.code() == 500 || response.code() == 404)
            return APIResponse.builder()
                    .dataList(errorList("Unable to get response from server"))
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
                .dataList(errorList(message))
                .statusCode(statusCode)
                .executionTime(System.currentTimeMillis() - startTime)
                .build();
    }

    /**
     * Prepare the error and add in list
     * @param errorMessage
     * @return the error in list
     */
    private List<Detail> errorList(String errorMessage)
    {
        final ProblemDetail problemDetail = new ProblemDetail();
        problemDetail.setErrorMessage(errorMessage);
        return Collections.singletonList(problemDetail);
    }
}
