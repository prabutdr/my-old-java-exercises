<%-- 
    Document   : FirstJSP
    Created on : Nov 11, 2010, 11:12:28 PM
    Author     : Prabu
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%-- Use the 'taglib' directive to make the JSTL 1.0 core tags available --%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">

<%-- Use the 'jsp:useBean' standard action to create the Date object --%>
<jsp:useBean id="date" class="java.util.Date"/>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>First JSP Page</title>
    </head>
    <body>
        <h1>Hello World!</h1>
        <h2>Here is today's date</h2>
        <c:out value="${date}"/>
    </body>
</html>
