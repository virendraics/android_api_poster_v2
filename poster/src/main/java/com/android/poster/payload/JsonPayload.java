package com.android.poster.payload;

import com.android.poster.util.ObjectUtil;
import okhttp3.MediaType;
import okhttp3.RequestBody;

/**
 * Implementation of the payload for JSON content.
 * 
 * @author Virendra
 * @version 6.1.0
 * @param <T>
 * @since 19-Aug-2024
 */
public class JsonPayload<T extends Object> extends AbstractPayload<T>
{
	@Override
	public RequestBody getContent()
	{
		final MediaType JSON = MediaType.parse("application/json; charset=utf-8");
		final String s = ObjectUtil.printObject(data);
		return RequestBody.create(s, JSON);
	}
}
