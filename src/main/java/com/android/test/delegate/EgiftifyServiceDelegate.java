package com.android.test.delegate;

import com.android.poster.delegate.AbstractServiceDelegate;
import com.android.poster.http.HttpMethod;
import com.android.poster.payload.ContentType;

/**
 * Delegate for eGiftify services
 * 
 * @author Virendra
 * @version 6.1.0
 * @since 26-Jun-2024
 */
public abstract class EgiftifyServiceDelegate extends AbstractServiceDelegate
{
	/**
	 * This is a constructor to initialize the service delegate
	 *
	 * @param apiEndpoint
	 * @param httpMethod
	 * @param contentType
	 */
	public EgiftifyServiceDelegate(String apiEndpoint, HttpMethod httpMethod, ContentType contentType) {
		super(apiEndpoint, httpMethod, contentType);
	}

	@Override
	public String getHost()
	{
	      return "https://api.eatwallet.com";
	}
}