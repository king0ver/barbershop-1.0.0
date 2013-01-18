package com.yl.barbershop.web.util;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.StringUtils;

public final class RequestUtil {
    public static boolean isJsonRequest(HttpServletRequest request) {
        return (StringUtils.equals("json", request.getParameter("format"))
                || StringUtils.equals("jsonp", request.getParameter("format")));
    }
}
