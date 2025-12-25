package com.dimo.account_management_system_javaee;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;

import java.io.IOException;

@WebServlet(urlPatterns = "/helloWorld")
public class helloWorld implements Servlet {
    @Override
    public void init(ServletConfig servletConfig) throws ServletException {

    }

    @Override
    public ServletConfig getServletConfig() {
        return null;
    }

    @Override
    public void service(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException {
        System.out.println("helloWorld");
    }

    @Override
    public String getServletInfo() {
        return null;
    }

    @Override
    public void destroy() {

    }
}
