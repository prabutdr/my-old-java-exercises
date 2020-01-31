/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.codestrokes.webdemos;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Prabu
 */
public class IncludeServlet extends HttpServlet {
    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /** 
     * Handles the HTTP <code>GET</code> method.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        PrintWriter out = response.getWriter();
        out.println("<h1>Welcome to our universe.</h1>");
        out.println("Rest of the page contents goes here.<br><br>");

        //Get resource to include
        String includeRes = (String) this.getInitParameter("included-resource");
        System.out.println(includeRes);

        //Include copyright information
        RequestDispatcher dispatcher = request.getRequestDispatcher(includeRes);
        dispatcher.include(request, response);
        out.println("<br><br><br>Ends here.");
        out.close();
    } 

    /** 
     * Returns a short description of the servlet.
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Servlet to test include other servlets.";
    }// </editor-fold>

}
