/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.codestrokes.webdemos;

import java.util.Enumeration;
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
public class FirstServlet extends HttpServlet {

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
        //Set the MIME type of the response, "text/html"
        response.setContentType("text/html");

        //Use a PrintWriter to send text data to the client who has requested
        //the servlet
        PrintWriter out = response.getWriter();

        //Begin assembling the HTML content
        out.println("<html><head>");
        out.println("<title>Help Page</title></head><body>");
        out.println("<form method=\"post\" action=\"" + request.getContextPath() +
                "/FirstServlet\">");
        out.println("<table border=\"0\"><tr><td valign=\"top\">");
        out.println("Your first name: </td> <td valign=\"top\">");
        out.println("<input type=\"text\" name=\"firstname\" size=\"20\">");
        out.println("</td></tr><tr><td valign=\"top\">");
        out.println("Your last name: </td> <td valign=\"top\">");
        out.println("<input type=\"text\" name=\"lastname\" size=\"20\">");
        out.println("</td></tr><tr><td valign=\"top\">");
        out.println("Your email: </td> <td valign=\"top\">");
        out.println("<input type=\"text\" name=\"email\" size=\"20\">");
        out.println("</td></tr><tr><td valign=\"top\">");

        out.println("<input type=\"submit\" value=\"Submit Info\"></td></tr>");
        out.println("</table></form>");
        out.println("</body></html>");

        RequestDispatcher dispatcher = request.getRequestDispatcher("/Copyright");
        dispatcher.include(request, response);

        String incPrivacy = (String)this.getInitParameter("included-privacy");
        dispatcher = request.getRequestDispatcher(incPrivacy);
        dispatcher.include(request, response);
    } 

    /** 
     * Handles the HTTP <code>POST</code> method.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        //Get the parameter names
        Enumeration paramNames = request.getParameterNames();

        String parName; // this will hold the name of the parameter

        boolean emptyEnum = false;
        if(!paramNames.hasMoreElements())
            emptyEnum = true;

        //Set the MIME type of the response, "text/html"
        response.setContentType("text/html");

        //Use a PrintWriter to send text data to the client
        PrintWriter out = response.getWriter();

        //Begin assembling the HTML content
        out.println("<html><head>");
        out.println("<title>Submitted Parameters</title></head><body>");

        if(emptyEnum) {
            out.println("<h2>Sorry, the request does not contain any parameters</h2>");
        }
        else {
            out.print("<h2>Here are the submitted parameter values</h2>");
        }

        while(paramNames.hasMoreElements()) {
            parName = (String) paramNames.nextElement();
            out.println("<strong>" + parName + "</strong> : " +
                    request.getParameter(parName));
            out.println("<br/>");
        }
        out.println("</body></html>");
        RequestDispatcher dispatcher = request.getRequestDispatcher("/Copyright");
        dispatcher.include(request, response);

        String incPrivacy = (String)this.getInitParameter("included-privacy");
        dispatcher = request.getRequestDispatcher(incPrivacy);
        dispatcher.include(request, response);
    }

    /** 
     * Returns a short description of the servlet.
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }

}
