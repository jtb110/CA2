<%-- 
    Document   : index
    Created on : 09-10-2015, 12:29:15
    Author     : Jonas
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

     
        <title>JSP Page</title>
    </head>
    <body>
    <center>
        <br><br><br>
        Enter search by id, name, company etc.
        <input type="search" >
        <input type="button" value="Search"
        <br><br><br>
    </center>
        
     <center>
         <br><br><br><br><br><br><br><br><br>
         Login here to add, edit or delete persons/companies.
	  <form method="post" action="j_security_check">
            <input type="text" name="j_username" required>
            <input type="password" name="j_password" required>
            <input type="submit" value="Login" >

     </center>
      
        </form>
    </body>
</html>
