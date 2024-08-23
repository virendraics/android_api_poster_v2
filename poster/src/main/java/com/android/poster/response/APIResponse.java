package com.android.poster.response;

import com.android.poster.detail.Detail;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.AllArgsConstructor;
import java.util.List;


/**
 * Represents an API response with type T.
 * This class encapsulates the various properties of an API response.
 * 
 * @author Virendra
 * @version 6.1.0
 * @since 19-Aug-2024
 */
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class APIResponse<T>
{
	private List<T> dataList;

	/**
	 * The HTTP status code of the API response.
	 */
	private int statusCode;

	/**
	 * The version of the API response.
	 */
	private int version;

	/**
	 * The execution time of the API request.
	 */
	private long executionTime;
}
