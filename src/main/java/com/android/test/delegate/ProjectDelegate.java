package com.android.test.delegate;


import com.android.poster.delegate.AbstractServiceDelegate;
import com.android.poster.http.HttpMethod;
import com.android.poster.payload.ContentType;
import com.android.poster.service.Service;

/**
 * Delegate for rest services
 * 
 * @author Virendra
 * @version 6.1.0
 * @since 20-Aug-2024
 */
public class ProjectDelegate extends AbstractServiceDelegate
{
	/**
	 * Return the API host URL
	 * @return
	 */
	@Override
	public String getHost()
	{
		return "";
	}

	/**
	 * Return true only in case of production environment
	 * Note - This is required in case of eGiftify API's because eg_lifeline_services will be appended after host URL only in UAT mode.
	 * @return
	 */
	@Override
	public boolean generateProductionURL() {
		return true;
	}

	/**
	 * API to delivery digital gifts
	 */
	public static final ProjectDelegate AUTH_LOGIN = new ProjectDelegate(Service.PORTAL, "auth/login", HttpMethod.POST, ContentType.APPLICATION_JSON);

	/**
	 * @param service
	 * @param apiEndpoint
	 * @param httpMethod
	 * @param contentType
	 */
	public ProjectDelegate(Service service, String apiEndpoint, HttpMethod httpMethod, ContentType contentType) {
		super(service, apiEndpoint, httpMethod, contentType);
	}
}