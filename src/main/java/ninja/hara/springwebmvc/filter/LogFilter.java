package ninja.hara.springwebmvc.filter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.autoconfigure.gson.GsonProperties;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
@Order(1)
public class LogFilter implements Filter {
    private Logger logger = LoggerFactory.getLogger(LogFilter.class);
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        logger.info("entrou no LogFilter!");
        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse resp = (HttpServletResponse) response;

        System.out.println("Logging Request: "+req.getMethod()+" - "+req.getRequestURI());

        chain.doFilter(request, response);

        logger.info("saiu do LogFilter!");
    }

}
