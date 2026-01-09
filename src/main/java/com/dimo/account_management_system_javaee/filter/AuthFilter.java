package com.dimo.account_management_system_javaee.filter;

import com.dimo.account_management_system_javaee.utils.jwtUtil;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.ExpiredJwtException;
import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;

import java.io.IOException;
import java.util.Date;




@WebFilter("/account/*")
public class AuthFilter implements Filter {
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException, ExpiredJwtException {
        HttpServletRequest req = (HttpServletRequest) servletRequest;

        String jwt = jwtUtil.loadJwt(req);
        if(jwt == null) throw new RuntimeException("user not login");
        Claims claims = jwtUtil.parseJwt(jwt);
        Date expiration = claims.getExpiration();
        Date now = new Date();
        if(expiration.before(now)){
            throw new RuntimeException("jwt expired");
        }

        filterChain.doFilter(servletRequest, servletResponse);
    }
}
