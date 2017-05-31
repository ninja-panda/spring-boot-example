package com.tuturself.spring.boot.filter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Configuration
@Order(Ordered.HIGHEST_PRECEDENCE)
public class WebFilter implements Filter {

    private static final Logger logger = LoggerFactory.getLogger(WebFilter.class);

    private static final boolean CONDITION = true;

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        logger.debug("Initiating WebFilter >> ");
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response,FilterChain chain) throws IOException,
            ServletException {
        if (CONDITION == true) {
            HttpServletRequest req = (HttpServletRequest) request;
            HeaderMapRequestWrapper requestWrapper = new HeaderMapRequestWrapper(req);
            String remote_addr = request.getRemoteAddr();
            requestWrapper.addHeader("remote_addr", remote_addr);
            chain.doFilter(requestWrapper, response); // Goes to default servlet.
        }
        else {
            ((HttpServletResponse) response).setStatus(HttpServletResponse.SC_BAD_REQUEST);
        }
    }

    @Override
    public void destroy() {
        logger.debug("Destroying WebFilter >> ");
    }
}
