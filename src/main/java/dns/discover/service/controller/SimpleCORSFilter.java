package dns.discover.service.controller;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.FilterType;
import org.springframework.stereotype.Component;

import javax.servlet.*;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.annotation.Annotation;

@Component
public class SimpleCORSFilter implements Filter {

    /**
     * Function for setting up req/res properties. Allowing cross-origin (CORS) and setting up response headers
     *
     * @param req               Request
     * @param res               Response
     * @param chain             FilterChain
     * @throws IOException      Exception
     * @throws ServletException Exception
     */
    public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain) throws IOException, ServletException {
        HttpServletResponse response = (HttpServletResponse) res;
        response.setHeader("Access-Control-Allow-Origin", "*");
        response.setHeader("Access-Control-Allow-Methods", "POST, GET, PUT, OPTIONS, DELETE, PATCH");
        response.setHeader("Access-Control-Max-Age", "3600");
        response.setHeader("Access-Control-Allow-Headers", "Origin, X-Requested-With, Content-Type, Accept");
        chain.doFilter(req, res);
    }

    /**
     * Init function for Filter
     *
     * @param filterConfig Configuration of filter
     */
    public void init(FilterConfig filterConfig) {}

    /**
     * Destroy Filter Function
     */
    public void destroy() {}
}