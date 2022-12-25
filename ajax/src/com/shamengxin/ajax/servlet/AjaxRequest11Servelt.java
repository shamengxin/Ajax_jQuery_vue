package com.shamengxin.ajax.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

/**
 * 测试自己写的jQuery库
 */
@WebServlet("/ajaxrequest11")
public class AjaxRequest11Servelt extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String username = request.getParameter("username");
        response.setContentType("text/html;charset=UTF-8");
        //{"uname":"zhangsan"}
        response.getWriter().print("{\"uname\":\""+username.toUpperCase()+"\"}");
    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String username = request.getParameter("username");
        response.setContentType("text/html;charset=UTF-8");
        //{"uname":"zhangsan"}
        response.getWriter().print("{\"uname\":\""+username.toLowerCase()+"\"}");
    }
}
