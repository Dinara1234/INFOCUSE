package org.example.springsecurityrest.handler;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.web.DefaultRedirectStrategy;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

import java.io.IOException;
import java.util.Collection;


public class CustomAuthenticationSuccessHandler implements AuthenticationSuccessHandler {


    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
                                        Authentication authentication) throws IOException, ServletException {

        String redirectUrl = "/";

        Collection<? extends GrantedAuthority> authorities = authentication.getAuthorities();
        for (GrantedAuthority grantedAuthority : authorities) {
            if (grantedAuthority.getAuthority().equals("ROLE_ADMIN")) {
                redirectUrl = "/admin";
                break;
            }
           if (grantedAuthority.getAuthority().equals("ROLE_USER")) {
                redirectUrl = "/user";
                break;
            }else if (grantedAuthority.getAuthority().equals("ROLE_MODEL")) {
                redirectUrl = "/model";
                break;
            }else if (grantedAuthority.getAuthority().equals("ROLE_PHOTOGRAPHER")) {
                redirectUrl = "/photographer";
                break;
            }
        }

        new DefaultRedirectStrategy().sendRedirect(request, response, redirectUrl);
    }
}
