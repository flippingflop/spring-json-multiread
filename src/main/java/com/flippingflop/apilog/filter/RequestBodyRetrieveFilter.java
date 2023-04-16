package com.flippingflop.apilog.filter;

import com.flippingflop.apilog.utils.CommonUtils;
import com.flippingflop.apilog.web.CustomHttpServletRequestWrapper;
import org.springframework.stereotype.Component;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

@Component
public class RequestBodyRetrieveFilter implements Filter {

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws ServletException, IOException {
        HttpServletRequest httpServletRequest = (HttpServletRequest) request;

        /** you do not need the wrapper class for multipart request since you can access the parameters directly. */
        if (CommonUtils.isMultipartRequest(httpServletRequest)) {
            chain.doFilter(request, response);
        } else {
            CustomHttpServletRequestWrapper wrapper = new CustomHttpServletRequestWrapper(httpServletRequest);
            chain.doFilter(wrapper, response);
        }
    }
}
