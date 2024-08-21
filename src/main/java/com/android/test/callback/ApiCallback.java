package com.android.test.callback;

import com.android.poster.detail.Detail;
import com.android.poster.detail.ProblemDetail;
import com.android.poster.response.APIResponse;
import com.android.poster.util.ObjectUtil;

import javax.naming.Context;
import java.util.List;

/**
 * This abstract class is to handle all api fire system.
 * @author virendra
 * @version 6.1.0
 * @since 20-Aug-2024
 */
public abstract class ApiCallback
{
	/**
	 * this method will always override and called whenever api return a outDetail except of message outDetail
	 * @param result - response of api
	 */
	public abstract void onSuccess(List<Detail> result);

	/**
	 * showing message (eitehr success message or error message)
	 *
	 * @param context
	 * @param apiResponse  - response of api
	 */
	public void onMessageDetail(Context context, APIResponse apiResponse)
	{
		if(apiResponse.getStatusCode() == 200 && ObjectUtil.isNotEmpty(((ProblemDetail)apiResponse.getDataList().get(0)).getSuccessMessage()))
			onSuccessMessage(context, ((ProblemDetail)apiResponse.getDataList().get(0)));
		else
			onErrorMessage(context, ((ProblemDetail)apiResponse.getDataList().get(0)));
	}

	/**
	 * This is a top method of callback, after execution of API this method is called to handle and notify according to the response
	 * @param context
	 * @param apiResponse
	 */
	public void notify(Context context, APIResponse apiResponse)
	{
//		ADLogger.log(ADLogger.Type.e,"API_LOG", new Gson().toJson(result));
		if( apiResponse != null && apiResponse.getDataList().size() >0 && apiResponse.getDataList().get(0) instanceof ProblemDetail)
		{
			onMessageDetail(context, apiResponse);
		}else if( apiResponse != null && apiResponse.getDataList().size() >0)
		{
			onSuccess(apiResponse.getDataList());
		}
	}

	public void onSuccessMessage(Context context, ProblemDetail problemDetail)
	{
//		Checks.alertMessage(context, "Success!", ((MessageDetail) result.get(0)).getSuccessMessage(), new TrueCallback() {
//			@Override
//			public void action(boolean result) {
//				if(result)
//					onOk();
//			}
//		});

		System.out.println("onSuccessMessage() = "+ problemDetail.getSuccessMessage());
	}


	public void onErrorMessage(Context context, ProblemDetail problemDetail)
	{
		System.out.println("onErrorMessage() = "+ problemDetail.getErrorMessage());
	}

}
 