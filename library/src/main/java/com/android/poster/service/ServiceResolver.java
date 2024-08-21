package com.android.poster.service;

/**
 * This class is used to resolve the service (war) name.
 * @author Virendra
 * @since 19-Aug-2024
 */
public class ServiceResolver
{
    /**
     * Return the service name/ war name based on service
     * @param service
     * @param isProduction depend upon the environment of the application, it must be true in case of production otherwise it will be false
     * @return the service war name
     */
    public static String getServiceName(Service service, boolean isProduction)
    {
        return switch (service)
                {
                    case LIFELINE -> isProduction ? "" : "eg_lifeline_services";
                    case CUSTOMER -> "egCustomerServices";
                    case MERCHANT -> "eg_merchant_services";
                    case PORTAL -> "eg_portal_services";
                    default -> "";
                };
    }
}
