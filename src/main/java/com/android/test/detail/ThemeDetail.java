package com.android.test.detail;


import com.android.poster.detail.Detail;

/**
 * This is the main theme detail which contains all UI components theme data
 * @author Gunja
 * @version 1.0.0
 * @since 31 Jan 2024
 */
public class ThemeDetail extends Detail
{
    /**
     * themeColor
     */
    public String themeColor;

    /**
     * buttons
     */
    public Button button;

    /**
     * It return the instance of button by type
     * @param buttonType
     * @return ButtonDetail
     */
    public ButtonDetail getButtonByType(int buttonType)
    {
       return switch (buttonType)
       {
           case 1 -> button.secondaryButton;
           default -> button.primaryButton;
       };
    }

    /**
     * The type Buttons.
     */
    public static class Button
    {
        /**
         * primaryButton
         */
        public ButtonDetail primaryButton;

        /**
         * secondaryButton
         */
        public ButtonDetail secondaryButton;

    }



}