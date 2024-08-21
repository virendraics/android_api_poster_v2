package com.android.test;

import com.android.poster.detail.Detail;
import com.android.poster.detail.ProblemDetail;
import com.android.poster.response.APIResponse;
import com.android.poster.util.DebugLogger;
import com.android.test.callback.ApiCallback;
import com.android.test.delegate.ProjectDelegate;
import com.android.poster.test.detail.LoginView;
import com.android.test.detail.MerchantUserDetail;
import com.google.gson.Gson;
import javax.naming.Context;
import java.util.List;

/**
 * @author Virendra
 * @version 6.1.0
 * @since 26-Jun-2024
 */
public class ApiTest {

    public static void main(String[] args) {

        DebugLogger.setEnvironment(DebugLogger.Environment.DEBUG);

        LoginView loginView = new LoginView();
        loginView.setUsername("abc");
        loginView.setPassword("welcome1");
        new RunApi().fireApi(ProjectDelegate.AUTH_LOGIN, loginView, MerchantUserDetail.class, new ApiCallback() {
            @Override
            public void onSuccess(List<Detail> result) {
                System.out.println("onSuccess() = "+ new Gson().toJson(result));
            }

            @Override
            public void onErrorMessage(Context context, ProblemDetail problemDetail) {
                //super.onErrorMessage(context, problemDetail);
                System.out.println("onErrorMessage   () = "+ new Gson().toJson(problemDetail));
            }

            @Override
            public void notify(Context context, APIResponse apiResponse) {
                //super.notify(context, apiResponse);
                System.out.println("apiResponse() = "+ new Gson().toJson(apiResponse));
            }
        });   // POST

     //   new RunApi().fireQueryParamApi(FreeServiceDelegate.GET_CUSTOMER, param, ThemeDetail.class, null);   // GET

//

      //  new RunApi().fireApi(FreeServiceDelegate.GET_CUSTOMER_LIST, customerDetail, CustomerDetail.class, null);  // POST JSON
    }
}
