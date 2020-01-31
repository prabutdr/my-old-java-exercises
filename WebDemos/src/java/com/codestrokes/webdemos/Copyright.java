package com.codestrokes.webdemos;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.ServletException;
import java.io.IOException;
import java.io.PrintWriter;

public class Copyright extends HttpServlet {
    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException
    {
        PrintWriter out = response.getWriter();
        out.println("Include - Get<br>");
        out.println("Copyright &copy; 2009-2010 CodeStrokes inc.,");
        //out.close();
    }

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException
    {
        PrintWriter out = response.getWriter();
        out.println("Include - Post<br>");
        out.println("Copyright &copy; 2009-2010 CodeStrokes inc.,");
        //out.close();
    }
}