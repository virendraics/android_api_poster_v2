package com.android.poster.client;

import com.android.poster.delegate.AbstractServiceDelegate;
import com.android.poster.payload.ContentMediaType;
import com.android.poster.response.APIResponse;
import com.android.poster.util.DebugLogger;
import com.android.poster.util.HttpResponseHandler;
import com.android.poster.util.ObjectUtil;
import com.google.gson.Gson;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;
import okhttp3.*;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

/**
 * This class is designed to be subclassed by specific REST clients, which can be used to make API requests and handle responses.
 * It provides a common structure and shared functionality for making API calls in a non-blocking and asynchronous way.
 *
 * @author Virendra
 * @version 6.1.0
 * @param <REQUEST> The input type for the API request, which represents the payload or input parameters specific to the API being called.
 * @since 16-Aug-2024
 */
@Setter
@Getter
@NoArgsConstructor
@SuperBuilder
public abstract class AbstractRestClient<REQUEST, RESPONSE, DELEGATE extends AbstractServiceDelegate>
{
	protected REQUEST input;

	protected Class<RESPONSE> output;

	protected DELEGATE serviceDelegate;

	/**
	 * The query parameters are used to modify the behavior of the API request or filter the API response based on specific criteria.
	 * @return A Map containing the query parameters for the API request, where the keys are parameter names and the values are parameter values.
	 */
	protected Map<String, String> queryParam;

	/**
	 * As per the requirement client can also pass the additional cookie header which will be added in final headers
	 * Ex. Passing authToken in cookie
	 */
	protected Map<String, String> additionalCookie;

	/**
	 * As per the requirement client can also pass the additional header which will be added in final headers
	 * Ex. Passing the language local
	 */
	protected Map<String, String> additionalHeader;

	/**
	 * This method should be implemented by subclasses to provide the headers specific to the API being called.
	 * The headers typically include information such as authorization tokens, content type, and any custom headers required by the API endpoint.
	 *
	 * @return Headers for the API request, where the keys are header names and the values are header values.
	 */
	public abstract Headers headers();

	/**
	 * This method should be implemented by subclasses to provide the cookies specific to the API being called.
	 * The cookies are typically used for session management or maintaining state during the API interaction.
	 *
	 * @return A Headers containing the cookies for the API request, where the keys are cookie names and the values are cookie values.
	 */
	public abstract Map<String, String> cookies();

	/**
	 * Sends an API request using WebClient and handles the API response.
	 *
	 * @return APIResponse&lt;RESPONSE&gt;
	 */
	public APIResponse fire()
	{
        //1. Get headers
        final Headers headers = headers();
		DebugLogger.print("Cookie >>>>> " + headers.get("Cookie"));

		//2. Get the url
		String url = serviceDelegate.getURL();
		if(queryParam != null)
		{
			url += url.endsWith("?") ? "" : "?";
			url += queryParam.entrySet().stream()
					.map(entry -> entry.getKey() + "=" + (ObjectUtil.isNotEmpty(entry.getValue()) ? entry.getValue() : ""))
					.collect(Collectors.joining("&"));
		}

		DebugLogger.print("Final URL >>>>> "+ url);

		//3. Get the body payload
		final RequestBody bodyPayload = getBodyPayload();

		//4. Record the start time of the request for measuring execution time.
		final long startTime = System.currentTimeMillis();

		//5. Create http client
		final OkHttpClient client = new OkHttpClient.Builder()
				.connectTimeout(10, TimeUnit.SECONDS)
				.writeTimeout(10, TimeUnit.SECONDS)
				.readTimeout(30, TimeUnit.SECONDS)
				.build();

		//6. Preparing request
		final Request.Builder requestBuilder = new Request.Builder()
				.url(url)
				.headers(headers);
		final Request request = switch (serviceDelegate.getHttpMethod())
				{
					case GET ->
							requestBuilder
									.get()
									.build();
					case POST ->
							requestBuilder
									.post(bodyPayload)
									.build();
					case DELETE ->
							requestBuilder
									.delete()
									.build();
					case PUT ->
							requestBuilder
									.put(bodyPayload)
									.build();
				};

		//7. Executing request
		try {
			final Response response = client.newCall(request).execute();
			if(response != null)
				//7.1 Handling response
				return new HttpResponseHandler().handleResponse(response, output, serviceDelegate, startTime);
		}catch (IOException e) {
			e.printStackTrace();
		}
		return new HttpResponseHandler().customResponse("Unable to get response from server", 420, startTime);
	}

	/**
	 * Generates the body payload for the API request based on the service delegate's content type and input data.
	 * @return The body payload as a string.
	 */
	private RequestBody getBodyPayload()
	{
		if(DebugLogger.isDebuggable())
			debugPrint();
		// Get the content type from the service delegate and use it to retrieve the appropriate payload implementation.
		return ContentMediaType.getContent(serviceDelegate.getContentType(), input).getContent();
	}

	/**
	 * Printing the debug logs
	 */
	private void debugPrint() {
		final String requestData = switch (serviceDelegate.getContentType())
		{
			case APPLICATION_JSON -> new Gson().toJson(input);
			case APPLICATION_FORM_URLENCODED ->
					input != null ? ((HashMap<String, String>) input).entrySet().stream()
						.map(entry -> entry.getKey() + "=" + entry.getValue())
						.collect(Collectors.joining("&")) : "";
			default -> "";
		};
		DebugLogger.print("############# API REQUEST ["+ serviceDelegate.getApiEndpoint() +"] ################ \n"+requestData);
	}
}
