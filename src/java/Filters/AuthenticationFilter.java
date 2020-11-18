
package Filters;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author 844817
 */
public class AuthenticationFilter implements Filter {
   
 
    public void doFilter(ServletRequest request, ServletResponse response,
            FilterChain chain)
            throws IOException, ServletException {
      
      HttpServletRequest httpRequest = (HttpServletRequest)request;
       HttpSession session = httpRequest.getSession(); //establish session
           
            String email = (String) session.getAttribute("email"); // get email
            if (email == null) { //if email null send bavk to login
          HttpServletResponse httpResponse = (HttpServletResponse)response;
               httpResponse.sendRedirect("login");
               return;
            }
            
            chain.doFilter(request, response); // forward on to the servlet or next filter
       
}

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {  }

    @Override
    public void destroy() {
    }
}