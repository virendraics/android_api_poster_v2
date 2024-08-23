package com.android.poster.payload;

import lombok.AllArgsConstructor;

import java.lang.reflect.InvocationTargetException;
import java.util.stream.Stream;

/**
 * Enum representing different types of payloads based on content types.
 *
 * @author Virendra
 * @version 6.1.0
 * @since 19-Aug-2024
 */
@AllArgsConstructor
public class ContentMediaType
{
	/**
	 * for application/x-www-form-urlencoded
	 */
	public static ContentMediaType APPLICATION_FORM_URLENCODED = new ContentMediaType(ContentType.APPLICATION_FORM_URLENCODED, ParamPayload.class.getName());

	/**
	 * for application/json
	 */
	public static ContentMediaType APPLICATION_JSON = new ContentMediaType(ContentType.APPLICATION_JSON, JsonPayload.class.getName());

	private ContentType contentType;

	private String fqcn;

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
		final ContentMediaType contentMediaType = Stream.of(APPLICATION_FORM_URLENCODED, APPLICATION_JSON)
				.filter(ct-> contentType == ct.contentType)
				.findFirst()
				.orElse(null);
		try
		{
			final AbstractPayload<T> content = (AbstractPayload<T>)(Class.forName(contentMediaType.fqcn)).getDeclaredConstructor().newInstance();
			content.setData(data);
			return content;
		}
		catch (NullPointerException | ClassNotFoundException | NoSuchMethodException | SecurityException | InstantiationException
			   | IllegalAccessException | IllegalArgumentException | InvocationTargetException e)
		{
			e.printStackTrace();
		}
		return null;
	}
}