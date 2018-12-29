package com.filter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.servlet.*;
import java.io.IOException;

@Component
public class SimpleFilter implements Filter {
    private static Logger logger = LoggerFactory.getLogger(SimpleFilter.class);
    @Override
    public void destroy() {
        logger.info("SimpleFilter.destroy()");
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain filterchain) throws IOException, ServletException {
        logger.info("SimpleFilter.doFilter()----ContentType:"+request.getContentType());
        filterchain.doFilter(request,response);
    }

    @Override
    public void init(FilterConfig filterconfig) throws ServletException {
        logger.info("SimpleFilter.init()");
    }
}
