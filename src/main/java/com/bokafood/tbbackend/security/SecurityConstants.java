package com.bokafood.tbbackend.security;

public class SecurityConstants {
    public static final String SECRET_KEY = "bQeThWmZq4t7w!z$C&F)J@NcRfUjXn2r5u8x/A?D*G-KaPdSgVkYp3s6v9y$B&E)";
    //public static final String SECRET_KEY = "secret";

    public static final int ACCESS_TOKEN_EXPIRATION = 300000; // 300000 milliseconds = 300 seconds = 5 minutes.
    //public static final int ACCESS_TOKEN_EXPIRATION = 1200000; // 1200000 milliseconds = 1200 seconds = 20 minutes.
    public static final int REFRESH_TOKEN_EXPIRATION = 86400000; // 86400000 milliseconds = 86400 seconds = 24 hours.
    public static final String BEARER = "Bearer "; // Authorization : "Bearer " + Token
    public static final String AUTHORIZATION = "Authorization"; // "Authorization" : Bearer Token
    public static final String REFRESH = "Refresh"; // "refresh" : Token
}
