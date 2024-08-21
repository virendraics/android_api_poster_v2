package com.android.test.detail;

import com.android.poster.detail.Detail;
import lombok.Data;

/**
 *
 * @author Virendra
 * @since 16/08/24
 */
@Data
public class AbstractDetail extends Detail
{
    private static final long serialVersionUID = 0L;
    private String id;
    private String authToken;

    public AbstractDetail() {
    }
}
