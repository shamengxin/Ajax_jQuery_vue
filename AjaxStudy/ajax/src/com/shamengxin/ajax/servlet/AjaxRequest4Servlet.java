package com.shamengxin.ajax.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;

/**
 * 验证用户名是否可用
 */
@WebServlet("/ajaxrequest4")
public class AjaxRequest4Servlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //获取用户名
        String username = request.getParameter("username");
        //打布尔标记（一种编程模型）
        boolean flag=false;//默认时用户名不存在
        //连接数据库验证用户名是否存在
        Connection conn=null;
        PreparedStatement ps=null;
        ResultSet rs=null;
        try {
            //1.注册驱动
            Class.forName("com.mysql.cj.jdbc.Driver");
            //2.获取连接
            conn= DriverManager.getConnection("jdbc:mysql://localhost:3306/ajax","root","heyufeng");
            //3.获取预编译的数据库操作对象
            String sql="select id,name from t_user where name=?";
            ps=conn.prepareStatement(sql);
            ps.setString(1,username);
            //4.执行SQL语句
            rs=ps.executeQuery();
            //5.结果集
            if(rs.next()){
                //用户名已存在
                flag=true;
            }

        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            //释放资源
            if(rs!=null){
                try {
                    rs.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if(ps!=null){
                try {
                    ps.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if(conn!=null){
                try {
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }

        //响应结果集
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        if(flag){
            //用户名已存在
            out.print("<font color='red'>对不起，用户名已存在</font>");
        }else{
            //用户名不存在，可以使用
            out.print("<font color='green'>用户名可以使用</font>");
        }
    }
}
