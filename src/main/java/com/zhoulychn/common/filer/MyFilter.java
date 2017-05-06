package com.zhoulychn.common.filer;

import javax.servlet.*;
import java.io.IOException;

/**
 * Created by lewis on 2016/12/19.
 */
public class MyFilter implements Filter {
    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        chain.doFilter(req, resp);


    }

    public void init(FilterConfig config) throws ServletException {

    }

}
