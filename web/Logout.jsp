<%-- 
    Document   : Logout
    Created on : Apr 29, 2016, 1:12:25 AM
    Author     : horia.mut
--%>

<%@ page session="true" %>
User '<%=request.getRemoteUser()%>' has been logged out.

<% session.invalidate(); %>

<br/><br/>
<a href="Login.xhtml">Click here to go back.</a>
