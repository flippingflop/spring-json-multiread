package com.flippingflop.apilog.interceptor;

import com.flippingflop.apilog.utils.CommonUtils;
import com.flippingflop.apilog.web.CustomHttpServletRequestWrapper;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Log4j2
@Component
public class ApiLogInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String jsonBody = null;
        if (CommonUtils.isMultipartRequest(request)) {
            /** multipart */
            jsonBody = CommonUtils.retrieveJsonBodyFromMultipartRequest(request);
        } else {
            /** retrieved json body can be saved in the request and be used when you need in further logic. */
            jsonBody = ((CustomHttpServletRequestWrapper) request).getJsonBody();
        }

        log.info(jsonBody);
        return true;
    }
}
