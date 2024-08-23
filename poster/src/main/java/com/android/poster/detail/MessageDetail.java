package com.android.poster.detail;

import lombok.Data;

import java.util.Map;

/**
 * This detail class is used in case of error response
 * @author Virendra
 * @since 19-Aug-2024
 */
@Data
public class MessageDetail extends Detail
{
    // private String detail; // This introduced in SPRING framework
    // Bellow these three details are added here just to support old API's, once all API migrated to SPRING framework then it will be removed

    private String errorMessage;

    private String successMessage;

    private String description;

    /**
     * Gunja
     * V_5_5 (Account Lockout)
     **/
    private Map<String, ? extends Object> data;

    private int errorCode;
}
