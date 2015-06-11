package org.tai.web.servlet;

import javax.servlet.*;
import java.io.IOException;

public class CountingFilter implements Filter {

    private PerSessionRequestCounter counter;

    public CountingFilter(PerSessionRequestCounter counter) {
        this.counter = counter;
    }

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {

    }

    @Override
    public void destroy() {

    }

}
