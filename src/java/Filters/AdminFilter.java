
package Filters;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


public class AdminFilter implements Filter {
    
  @Override
    public void doFilter(ServletRequest request, ServletResponse response,
            FilterChain chain)
            throws IOException, ServletException {
        
       // code that executees before servlet // next filter
          
        HttpServletRequest httpRequest = (HttpServletRequest)request;
       HttpSession session = httpRequest.getSession(); //establish session
      
       String email = (String) session.getAttribute("email");
        String adminEmail = "cprg352+admin@gmail.com";

        if (!email.equals(adminEmail)) {
            HttpServletResponse httpResponse = (HttpServletResponse) response;
            httpResponse.sendRedirect("notes");
            return;
        }
       
       
        
            chain.doFilter(request, response); // chain to servlet
        
            
            
        }

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
     
    }

    @Override
    public void destroy() {
     
    }
        
 
}
