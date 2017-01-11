<%-- 
    Document   : index
    Created on : Sep 23, 2016, 3:01:31 PM
    Author     : Jeffrey
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
    <head>
        <title>Movie Manager</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
    </head>
    <body>
        <!--Emoji Face Codes Throughout here-->
        <div>Movie Manager</div>
        <p id='message'>${message}</p>
        
        <h1>Check out Movie</h1>
            <p>\|/ Click Down Here </p>
            <form action="<c:url value='MovieServlet'/>" method="post">
                    <input type="hidden" name="action" value="displayMovies">
                    <input type="submit" value="View Movies" class="btn">
            </form>
    </body>
</html>
