package com.android.poster.delegate;

import com.android.poster.http.HttpMethod;
import com.android.poster.payload.ContentType;
import com.android.poster.service.Service;
import com.android.poster.service.ServiceResolver;
import com.android.poster.util.ObjectUtil;
import lombok.Getter;

/**
 * An abstract class representing a service delegate for making HTTP requests.
 *
 * @author Virendra
 * @version 6.1.0
 * @since 16-Aug-2024
 */
@Getter
public abstract class AbstractServiceDelegate 
{
	private Service service;

	/**
	 * The endpoint or path associated with the service.
	 */
	private String apiEndpoint;
	
	/**
	 * The HTTP method to be used for the request.
	 */
	private HttpMethod httpMethod;
	
	/**
	 * The content type of the request.
	 */
	private ContentType contentType;
	
	/**
	 * This is a constructor to initialize the service delegate
	 * @param service
	 * @param apiEndpoint
	 * @param httpMethod
	 * @param contentType
	 */
	public AbstractServiceDelegate(
			Service service,
			String apiEndpoint,
			HttpMethod httpMethod, 
			ContentType contentType)
	{
		this.service = service;
		this.apiEndpoint = apiEndpoint;
		this.httpMethod = httpMethod;
		this.contentType = contentType;
	}

	/**
	 * This method will override in child class to define the host URL
	 * @return String
	 */
	public abstract String getHost();

	/**
	 * This method will override in child class to define the URL generation for production or UAT server
	 * Note - This is required in case of eGiftify API's because eg_lifeline_services will be appended after host URL only in UAT mode.
	 * @return
	 */
	public abstract boolean generateProductionURL();

	/**
	 * Method to get the complete URL for the service.
	 * It combines the host, action, and query parameters (if any).
	 *
	 * @return The complete URL for the service.
	 */
	public String getURL()
	{
		return getHost()
				+ (ObjectUtil.isNotEmpty(ServiceResolver.getServiceName(service, generateProductionURL())) ? "/" + ServiceResolver.getServiceName(service, generateProductionURL()) : "")
				+"/" + apiEndpoint;
	}
}
