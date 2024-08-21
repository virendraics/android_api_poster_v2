package com.android.poster.util;

import com.google.gson.Gson;

/**
 * This is a utility class
 * @author Virendra
 * @version 6.1.0
 * @since 19-Aug-2024
 */
public class ObjectUtil
{
    /**
     * Object ot string conversion
     * @param data
     * @param <T>
     * @return the string
     */
    public static <T extends Object> String printObject(T data)
    {
        return new Gson().toJson(data);
    }

    /**
     * This is used to check the string is empty or not
     * @param value
     * @return true or false
     */
    public static boolean isEmpty(String value)
    {
        return (value == null || "".equals(value));
    }

    /**
     * Return the true of not empty
     * @param value
     * @return true or false
     */
    public static boolean isNotEmpty(String value)
    {
        return !isEmpty(value);
    }
}
