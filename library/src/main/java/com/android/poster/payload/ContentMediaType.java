package com.android.poster.payload;

import java.lang.reflect.InvocationTargetException;
import java.util.stream.Stream;

import lombok.AllArgsConstructor;

/**
 * Enum representing different types of content (payloads) based on media types.
 * 
 * @author Virendra
 * @version 6.1.0
 * @since 19-Aug-2024
 */
@AllArgsConstructor
public enum ContentMediaType
{
	/**
	 * enum for application/x-www-form-urlencoded
	 */
	APPLICATION_FORM_URLENCODED(ContentType.APPLICATION_FORM_URLENCODED, "com.android.poster.payload.ParamPayload"),
	
	/**
	 * enum for application/json
	 */
	APPLICATION_JSON(ContentType.APPLICATION_JSON, "com.android.poster.payload.JsonPayload");

	private final ContentType contentType;

	private final String fqcn;

	/**
	 * Retrieves the content (payload) instance based on the provided media type and data.
	 *
	 * @param contentType The media type of the content to retrieve.
	 * @param data      The data to be used for constructing the content.
	 * @param <T>       The type of data for the payload.
	 * @return An instance of AbstractPayload representing the content, or null if the media type is not supported or if an error occurs during content instantiation.
	 */
	public static <T> AbstractPayload<T> getContent(ContentType contentType, T data)
	{
		final ContentMediaType contentMediaType = Stream.of(values())
				.filter(ct-> contentType == ct.contentType)
				.findFirst()
				.orElse(null);
		try 
		{
			@SuppressWarnings("unchecked")
			final AbstractPayload<T> content = (AbstractPayload<T>)(Class.forName(contentMediaType.fqcn)).getDeclaredConstructor().newInstance();
			content.setData(data);
			return content;
		} 
		catch (ClassNotFoundException | NoSuchMethodException | SecurityException | InstantiationException
				| IllegalAccessException | IllegalArgumentException | InvocationTargetException e) 
		{
			e.printStackTrace();
		}
		return null;
	}
}
