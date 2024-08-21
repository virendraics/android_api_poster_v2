package com.android.poster.test.detail;

import com.android.poster.detail.Detail;
import lombok.Data;

/**
 * @author Virendra
 * @since 16/08/24
 */

@Data
public class LoginView extends Detail
{
    String username;
    String password;
    String otp;
}
