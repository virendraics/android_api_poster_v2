package com.android.test;

import com.android.poster.util.DebugLogger;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

/**
 * @author Virendra
 * @since 22/08/24
 */
public class KeyGen
{
    /**
     * This method is used to get the current time for creating hash
     * @return the current time
     */
    public static String getTimeStamp()
    {
        final SimpleDateFormat sdf = new SimpleDateFormat("yyyy:MM:dd-HH:mm:ss");
        sdf.setTimeZone(TimeZone.getTimeZone("UTC"));
        final String formattedDate = sdf.format(new Date());
        DebugLogger.print("time delegate : "+formattedDate);
        return formattedDate;
    }

    public static String generateAPIHash(String api, String secret, String time)
    {
        MessageDigest md = null;
        try
        {
            md = MessageDigest.getInstance("SHA-256");
        } catch (NoSuchAlgorithmException e)
        {
            // Console print
            e.printStackTrace();
        }

        md.update(api.concat(secret).concat(time).getBytes());
        final byte[] byteData = md.digest();

        final StringBuffer hexString = new StringBuffer();
        for (int i = 0; i < byteData.length; i++)
        {
            final String hex = Integer.toHexString(0xff & byteData[i]);
            if(hex.length() == 1)
                hexString.append('0');
            hexString.append(hex);
        }

        return hexString.toString();
    }
}
