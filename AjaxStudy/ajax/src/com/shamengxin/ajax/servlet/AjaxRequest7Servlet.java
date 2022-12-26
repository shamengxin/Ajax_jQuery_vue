package com.shamengxin.ajax.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

/**
 * 测试ajax乱码问题
 */
@WebServlet("/ajaxrequest7")
public class AjaxRequest7Servlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //接收的中文会不会乱码
        request.setCharacterEncoding("UTF-8");
        String username = request.getParameter("username");
        System.out.println(username);
        //响应中文会有乱码问题吗？
        response.setContentType("text/html;charset=UTF-8");//tomcat9以及之前的版本，这行代码势必需要加的。
        PrintWriter out = response.getWriter();
        out.print(username);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //接收的中文会不会乱码
        String username = request.getParameter("username");
        System.out.println(username);
        //响应中文会有乱码问题吗？
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        out.print(username);
    }
}
