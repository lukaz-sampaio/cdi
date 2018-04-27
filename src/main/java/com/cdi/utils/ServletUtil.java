package com.cdi.utils;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.commons.lang3.StringUtils;

/**
 *
 * @author lucas
 */
public class ServletUtil {
    
    private static final Logger LOG = Logger.getLogger(ServletUtil.class.getName());

    private ServletUtil(){}

    public static void render(String path, HttpServletRequest request, HttpServletResponse response){
        if(!response.isCommitted()){
            try {
                request.getRequestDispatcher(path).forward(request, response);
            } catch (ServletException | IOException ex) {
                LOG.log(Level.SEVERE, null, ex);
            }
        }
    }

    public static void redirect(String path, HttpServletRequest request, HttpServletResponse response){
        try {
            if(StringUtils.isNotBlank(path)){
                response.sendRedirect(response.encodeRedirectURL(request.getContextPath() + path));
            }
        } catch (IOException ex) {
            LOG.log(Level.SEVERE, null, ex);
        }
    }
            
}
