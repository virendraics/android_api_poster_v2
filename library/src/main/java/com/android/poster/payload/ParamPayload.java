package com.android.poster.payload;

import okhttp3.MediaType;
import okhttp3.RequestBody;

import java.util.HashMap;
import java.util.stream.Collectors;

/**
 * Implementation of the payload for parameter content.
 * 
 * @author Virendra
 * @version 6.1.0
 * @param <T>
 * @since 19-Aug-2024

 */
public class ParamPayload<T extends HashMap<String, Object>> extends AbstractPayload<T>
{
	/**
	 * This method converts the payload's data (parameters) to a URL-encoded string format.
	 *
	 * @return A URL-encoded string representation of the payload's data.
	 *         Returns null if the data is null.
	 */
	@Override
	public RequestBody getContent()
	{
		final MediaType PARAM = MediaType.parse("application/x-www-form-urlencoded; charset=utf-8");
		return RequestBody.create(data != null ? data.entrySet().stream()
						.map(entry -> entry.getKey() + "=" + entry.getValue())
						.collect(Collectors.joining("&")) : null,
				PARAM);
	}
}
