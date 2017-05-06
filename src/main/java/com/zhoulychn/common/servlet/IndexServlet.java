package com.zhoulychn.common.servlet;

import javax.servlet.*;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.Enumeration;

/**
 * Created by lewis on 2016/12/3.
 */
public class IndexServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        getServletContext();
        System.out.println(request);
        HttpSession session = request.getSession();
        System.out.println(session);
        session.invalidate();
        HttpSession session1 = request.getSession();
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("");
    }
}
