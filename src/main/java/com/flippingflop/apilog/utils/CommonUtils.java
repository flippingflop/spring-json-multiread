package com.flippingflop.apilog.utils;

import org.springframework.boot.configurationprocessor.json.JSONException;
import org.springframework.boot.configurationprocessor.json.JSONObject;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.multipart.support.StandardMultipartHttpServletRequest;

import javax.servlet.http.HttpServletRequest;
import java.util.Collections;
import java.util.Enumeration;
import java.util.Iterator;

public class CommonUtils {

    public static boolean isMultipartRequest(HttpServletRequest request) {
        return request.getContentType() != null &&
                request.getContentType().startsWith("multipart/") &&
                (("POST".equalsIgnoreCase(request.getMethod()) || "PUT".equalsIgnoreCase(request.getMethod())));
    }

    /**
     * retrieve only json values from the multipart request.
     * @param request the multipart request
     * @return
     * @throws JSONException
     */
    public static String retrieveJsonBodyFromMultipartRequest(HttpServletRequest request) throws JSONException {
        MultipartHttpServletRequest multipartHttpServletRequest = new StandardMultipartHttpServletRequest(request);
        Enumeration<String> enumeration = multipartHttpServletRequest.getParameterNames();
        Iterator<String> iterator = Collections.list(enumeration).iterator();
        JSONObject jsonObject = new JSONObject();

        while (iterator.hasNext()) {
            String paramName = iterator.next();
            String paramValue = multipartHttpServletRequest.getParameter(paramName);
            jsonObject.put(paramName, paramValue);
        }

        return jsonObject.toString();
    }

}
