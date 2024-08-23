package com.android.test;

import com.android.poster.delegate.AbstractServiceDelegate;
import com.android.poster.response.APIResponse;
import com.android.test.callback.ApiCallback;
import com.android.test.client.EgiftifyRestClient;
import com.android.test.delegate.EgiftifyServiceDelegate;
import com.google.gson.Gson;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Virendra
 * @since 28/06/24
 */
public class RunApi<REQUEST, RESPONSE> {

    public void fireApi(EgiftifyServiceDelegate serviceDelegate, REQUEST detail, Class<RESPONSE> output, ApiCallback<RESPONSE> apiCallback)
    {
        APIResponse<RESPONSE> apiResponse = EgiftifyRestClient.<REQUEST, RESPONSE>builder()
                .input(detail)
                .output(output)
                .serviceDelegate(serviceDelegate)
                .additionalCookie(Map.of("authToken","598497bf53e0539acd4fb360a4601f097256fb89cae6691998b92bdb86ff284c"))
                .additionalHeader(Map.of("Header1", "Value1"))
                .build()
                .fire();

        System.out.println("DDDDDDDDDDDDDDD : "+ new Gson().toJson(apiResponse.getDataList()));
        System.out.println("DDDDDDDDDDDDDDD : "+ new Gson().toJson(apiResponse));

        if(apiCallback != null)
            apiCallback.notify(null, apiResponse);
    }


    public void fireQueryParamApi(AbstractServiceDelegate serviceDelegate, HashMap<String, String> params, Class output, ApiCallback<RESPONSE> apiCallback)
    {
        APIResponse apiResponse = EgiftifyRestClient.builder()
                .queryParam(params)
                .output(output)
                .serviceDelegate(serviceDelegate)
                .build()
                .fire();

        System.out.println("DDDDDDDDDDDDDDD : "+ new Gson().toJson(apiResponse.getDataList()));
    }

}
