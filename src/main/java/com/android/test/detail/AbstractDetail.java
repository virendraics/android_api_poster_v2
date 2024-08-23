package com.android.test.detail;

import com.android.poster.detail.Detail;

/**
 *
 * @author Virendra
 * @since 16/08/24
 */
public class AbstractDetail extends Detail
{
    private static final long serialVersionUID = 0L;
    private String id;
    private String authToken;

    public AbstractDetail() {
    }

    public String getToken() {
        return this.authToken;
    }

    public void setToken(String token) {
        this.authToken = token;
    }

    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
