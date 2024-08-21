package com.android.test.client;

import com.android.poster.client.AbstractRestClient;
import com.android.poster.util.ObjectUtil;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.SuperBuilder;
import okhttp3.Headers;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * Rest client for APIs
 * 
 * @author Virendra
 * @version 6.1.0
 * @since 20-Aug-2024
 */
@Setter
@Getter
@SuperBuilder
public class ProjectRestClient<REQUEST> extends AbstractRestClient<REQUEST>
{
	private static String apiKey = "";
	
	private static String secretKey = "";
	
	@Override
	public Headers cookies()
	{
		final String timeStamp = getTimeStamp();
		return Headers.of("x-timestamp", timeStamp,
				"api_key", apiKey,
				"hash", generateAPIHash(apiKey, secretKey, timeStamp),
				"currentVersion", "14",
				"Launcher", "Android API poster",
				"authToken", ""
		);
	}

	@Override
	public Headers headers()
	{
		Headers cookieHeaders = cookies();
		String cookieString = IntStream.range(0, cookieHeaders.size())
				.mapToObj(i -> cookieHeaders.name(i) + "=" + (ObjectUtil.isNotEmpty(cookieHeaders.value(i)) ? cookieHeaders.value(i) : ""))
				.collect(Collectors.joining(";"));

		return Headers.of("Accept", "application/json",
				"Content-Type", serviceDelegate.getContentType().toString(),
				"Cookie", cookieString,
				"Launcher", "Android"
		);
	}

	private static String generateAPIHash(String api, String secret, String time) 
	{
		MessageDigest md = null;
		try
		{
			md = MessageDigest.getInstance("SHA-256");
		} catch (NoSuchAlgorithmException e) 
		{
			// Console print
			e.printStackTrace();
		}
		
		md.update(api.concat(secret).concat(time).getBytes());
		final byte[] byteData = md.digest();

		final StringBuffer hexString = new StringBuffer();
		for (int i = 0; i < byteData.length; i++) 
		{
			final String hex = Integer.toHexString(0xff & byteData[i]);
			if(hex.length() == 1) 
				hexString.append('0');
			hexString.append(hex);
		}
		
		return hexString.toString();
	}
}