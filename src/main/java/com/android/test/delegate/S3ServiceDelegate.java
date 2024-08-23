package com.android.test.delegate;


import com.android.poster.delegate.AbstractServiceDelegate;
import com.android.poster.http.HttpMethod;
import com.android.poster.payload.ContentType;

/**
 * Delegate for S3 services
 * 
 * @author Virendra
 * @version 6.1.0
 * @since 26-Jun-2024
 */
public class S3ServiceDelegate extends AbstractServiceDelegate
{
	@Override
	public String getHost()
	{
		return "https://d2fbrinfk051vz.cloudfront.net";
	}

    @Override
    public String getURL() {
        return getHost() +"/" + getApiEndpoint();
    }

    /**
	 * @param apiEndpoint
	 * @param httpMethod
	 * @param contentType
	 */
	public S3ServiceDelegate(String apiEndpoint, HttpMethod httpMethod, ContentType contentType) {
		super(apiEndpoint, httpMethod, contentType);
	}

	/**
	 * API to get theme from S3
	 */
	public static final S3ServiceDelegate THEME = new S3ServiceDelegate(
					"resources/purchase/oflSLzBnCtvPUpD7NouQ3mq8ztnU1m07Co4PpEdV5fM/theme.json",
					HttpMethod.GET,
			        ContentType.APPLICATION_JSON);

}