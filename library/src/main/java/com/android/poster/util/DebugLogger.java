package com.android.poster.util;

/**
 * This class is used to print the debugging data
 * @author Virendra
 * @since 19-Aug-2024
 */
public class DebugLogger
{

    private static DebugLogger.Environment environment;

    /**
     * Enum for environments
     */
    public static enum Environment {
        /**
         * In this mode, debugging logs will be printed
         */
        DEBUG,

        /**
         * In this mode, debugging logs will not be printed
         */
        PRODUCTION;

        private Environment() {
        }
    }

    static {
        environment = DebugLogger.Environment.PRODUCTION;
    }

    /**
     * This method is called from developer side based on requirement of log should be print or not
     * @param environment
     */
    public static void setEnvironment(DebugLogger.Environment environment) {
        DebugLogger.environment = environment;
    }

    /**
     * Cll this method to get the debug mode status
     * @return Return the debug mode status
     */
    public static boolean isDebuggable() {
        return environment == DebugLogger.Environment.DEBUG;
    }

    /**
     * Print the log if environment set as debug
     * @param message
     */
    public static void print(String message)
    {
        if (environment == DebugLogger.Environment.DEBUG)
           System.out.println(message);
    }
}
