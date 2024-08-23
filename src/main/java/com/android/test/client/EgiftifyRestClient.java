package com.android.test.client;

import com.android.poster.client.AbstractRestClient;
import com.android.poster.util.ObjectUtil;
import com.android.test.KeyGen;
import com.android.test.delegate.EgiftifyServiceDelegate;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.SuperBuilder;
import okhttp3.Headers;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Rest client for eGiftify APIs
 * 
 * @author Virendra
 * @version 6.1.0
 * @since 26-Jun-2024
 */
@Setter
@Getter
@SuperBuilder
public class EgiftifyRestClient<REQUEST, RESPONSE> extends AbstractRestClient<REQUEST, RESPONSE, EgiftifyServiceDelegate>
{
	private static String apiKey = "";
	
	private static String secretKey = "";
	
	@Override
	public Map<String, String> cookies()
	{
		final String timeStamp = KeyGen.getTimeStamp();
		final Map<String, String> cookiesMap = new HashMap<>(Map.of(
				"x-timestamp", timeStamp,
				"api_key", apiKey,
				"hash", KeyGen.generateAPIHash(apiKey, secretKey, timeStamp),
				"currentVersion", "14",
				"Launcher", "Android API poster"
		));
		if(additionalCookie != null)
		   cookiesMap.putAll(additionalCookie);
		return cookiesMap;
	}

	@Override
	public Headers headers()
	{
		final String cookieString = cookies().entrySet()
				.stream()
				.map(entry -> entry.getKey() + "=" + (ObjectUtil.isNotEmpty(entry.getValue()) ? entry.getValue() : ""))
				.collect(Collectors.joining(";"));

		final Headers.Builder headersBuilder = Headers.of(
				"Accept", "application/json",
				"Content-Type", serviceDelegate.getContentType().toString(),
				"Cookie", cookieString,
				"Launcher", "Android"
		).newBuilder();

		if (additionalHeader != null) {
			headersBuilder.addAll(Headers.of(additionalHeader));
		}
		return headersBuilder.build();
	}
}