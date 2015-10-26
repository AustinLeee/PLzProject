package com.core.vo.app;

import org.springframework.http.HttpRequest;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by ¿Ó”˜’‹ on 2015/10/22.
 */
public class AppContext {

    private static HttpServletRequest httpRequest;

    public static HttpServletRequest getHttpRequest() {
        return httpRequest;
    }

    public void setHttpRequest(HttpServletRequest httpRequest) {
        this.httpRequest = httpRequest;
    }
}
