package com.rikovicisah.app.ws.security;

import com.rikovicisah.app.ws.SpringAppContext;

public class SecurityConstants {
    public static final long EXPIRATION_TIME = 864_000_000; //10 dana (ms)
    public static final String TOKEN_PREFIX = "Bearer ";
    public static final String HEADER_STRING = "Authorization";
    public static final String SIGN_UP_URL = "/users";
//    public static final String TOKEN_SECRET = "kdlfg438q304q034afkdsjsg";

    public static String getSecretToken(){
        AppPropertiesRead propertiesRead = (AppPropertiesRead) SpringAppContext.getBean("AppPropertiesRead");
        return propertiesRead.getTokenSecret();
    }
}
