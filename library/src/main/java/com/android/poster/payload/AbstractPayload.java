package com.android.poster.payload;

import okhttp3.RequestBody;

/**
 * Abstract class representing a payload with generic data type T.
 * This class provides a base structure for different payload implementations.
 * 
 * @author Virendra
 * @version 6.1.0
 * @param <T>
 * @since 19-Aug-2024
 */
public abstract class AbstractPayload<T>
{
	protected T data;

	/**
	 * Gets the content of the payload as a string.
	 * Subclasses must implement this method to provide content-specific behavior.
	 *
	 * @return A string representation of the payload's content.
	 */
	public abstract RequestBody getContent();

	/**
	 * Set the payload data
	 * @param data
	 */
	public void setData(T data)
	{
		this.data = data;
	}
	
}
