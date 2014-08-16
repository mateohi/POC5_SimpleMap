package com.ic.banking.glass.poc5_simplemap.integration.publicapi;

public class PublicUrls {


    private static final String BASE_URL = SERVICE_HOST + SERVICE_PATH;

    public static final String GET_PUBLIC_INFO_URL = BASE_URL + "/publicInfo";
    public static final String GET_NEWSFEED_URL = BASE_URL + "/newsFeed";
    public static final String GET_EXCHANGE_RATES_URL = BASE_URL + "/exchangeRates";
    public static final String GET_IMAGE_URL = BASE_URL + "/images?ids=%d";

}
