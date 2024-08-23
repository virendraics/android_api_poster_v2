package com.android.test.delegate;

import com.android.poster.http.HttpMethod;
import com.android.poster.payload.ContentType;

/**
 * Delegate for merchant services
 * 
 * @author Virendra
 * @version 6.1.0
 * @since 26-Jun-2024
 */
public class MerchantServiceDelegate extends EgiftifyServiceDelegate
{
	/**
	 * @param apiEndpoint
	 * @param httpMethod
	 * @param contentType
	 */
	public MerchantServiceDelegate(String apiEndpoint, HttpMethod httpMethod, ContentType contentType) {
		super(apiEndpoint, httpMethod, contentType);
	}

	@Override
	public String getURL() {
		return getHost()
				+"/" + "eg_merchant_services"
				+"/" + getApiEndpoint();
	}
}