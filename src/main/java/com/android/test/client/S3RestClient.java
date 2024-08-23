package com.android.test.client;

import com.android.poster.client.AbstractRestClient;
import com.android.test.delegate.S3ServiceDelegate;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.SuperBuilder;
import okhttp3.Headers;

import java.util.Map;

/**
 * Rest client for S3 APIs
 * 
 * @author Virendra
 * @version 6.1.0
 * @since 26-Jun-2024
 */
@Setter
@Getter
@SuperBuilder
public class S3RestClient<REQUEST, RESPONSE> extends AbstractRestClient<REQUEST, RESPONSE, S3ServiceDelegate>
{
	@Override
	public Map<String, String> cookies()
	{
		return null;
	}

	@Override
	public Headers headers()
	{
		return Headers.of("Accept", "application/json",
				"Content-Type", serviceDelegate.getContentType().toString()
		);
	}
}