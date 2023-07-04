package com.bokafood.tbbackend.security;

public class SecurityConstants {
    public static final String SECRET_KEY = "bQeThWmZq4t7w!z$C&F)J@NcRfUjXn2r5u8x/A?D*G-KaPdSgVkYp3s6v9y$B&E)"; //Your secret should always be strong (uppercase, lowercase, numbers, symbols) so that nobody can potentially decode the signature.
    //public static final String SECRET_KEY = "MFswDQYJKoZIhvcNAQEBBQADSgAwRwJAbOXzZpPD6Ln0xeyzp+S02uReXlE3+jAm\n" +
            //"AmLMZlakdkWGxbh+51OTGpk0boN0L3w6nkVR3W7M4vvgW7Umm/OJ3wIDAQAB";
    //public static final int TOKEN_EXPIRATION = 7200000; // 7200000 milliseconds = 7200 seconds = 2 hours.
    public static final int TOKEN_EXPIRATION = 600000; // 600000 milliseconds = 600 seconds = 10 minutes.
    public static final String BEARER = "Bearer "; // Authorization : "Bearer " + Token
    public static final String AUTHORIZATION = "Authorization"; // "Authorization" : Bearer Token
    public static final String REGISTER_PATH = "/user/register"; // Public path that clients can use to register.
    public static final String AUTHORITIES = "authorities";
}