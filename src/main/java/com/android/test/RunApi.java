package com.android.test;

import com.android.poster.delegate.AbstractServiceDelegate;
import com.android.poster.detail.Detail;
import com.android.poster.response.APIResponse;
import com.android.test.callback.ApiCallback;
import com.android.test.client.ProjectRestClient;
import com.google.gson.Gson;
import java.util.HashMap;

/**
 * @author Virendra
 * @since 28/06/24
 */
public class RunApi {

    public void fireApi(AbstractServiceDelegate serviceDelegate, Detail detail, ApiCallback apiCallback)
    {
        fireApi(serviceDelegate, detail, detail.getClass(), apiCallback);
    }
    public void fireApi(AbstractServiceDelegate serviceDelegate, Detail detail, Class output, ApiCallback apiCallback)
    {
        APIResponse apiResponse = ProjectRestClient.builder()
                .input(detail)
                .output(output)
                .serviceDelegate(serviceDelegate)
                .build()
                .fire();

        System.out.println("DDDDDDDDDDDDDDD : "+ new Gson().toJson(apiResponse.getDataList()));
        System.out.println("DDDDDDDDDDDDDDD : "+ new Gson().toJson(apiResponse));

        if(apiCallback != null)
            apiCallback.notify(null, apiResponse);
    }

    public void fireParamApi(AbstractServiceDelegate serviceDelegate, HashMap<String, String> params, Class output, ApiCallback apiCallback)
    {
        APIResponse apiResponse = ProjectRestClient.builder()
                .input(params)
                .output(output)
                .serviceDelegate(serviceDelegate)
                .build()
                .fire();

        System.out.println("DDDDDDDDDDDDDDD : "+ new Gson().toJson(apiResponse.getDataList()));
    }

    public void fireQueryParamApi(AbstractServiceDelegate serviceDelegate, HashMap<String, String> params, Class output, ApiCallback apiCallback)
    {
        APIResponse apiResponse = ProjectRestClient.builder()
                .queryParam(params)
                .output(output)
                .serviceDelegate(serviceDelegate)
                .build()
                .fire();

        System.out.println("DDDDDDDDDDDDDDD : "+ new Gson().toJson(apiResponse.getDataList()));
    }

}
