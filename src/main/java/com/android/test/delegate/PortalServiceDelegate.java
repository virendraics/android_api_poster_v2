package com.android.test.delegate;

import com.android.poster.http.HttpMethod;
import com.android.poster.payload.ContentType;

/**
 * Delegate for portal services
 * 
 * @author Virendra
 * @version 6.1.0
 * @since 26-Jun-2024
 */
public class PortalServiceDelegate extends EgiftifyServiceDelegate
{
	/**
	 * @param apiEndpoint
	 * @param httpMethod
	 * @param contentType
	 */
	public PortalServiceDelegate(String apiEndpoint, HttpMethod httpMethod, ContentType contentType) {
		super(apiEndpoint, httpMethod, contentType);
	}

	@Override
	public String getURL() {
		return getHost()
				+"/" + "eg_portal_services"
				+"/" + getApiEndpoint();
	}

	/**
	 * API to delivery digital gifts
	 */
	public static final PortalServiceDelegate AUTH_LOGIN = new PortalServiceDelegate("auth/login", HttpMethod.POST, ContentType.APPLICATION_JSON);

}