<%-- 
    Document   : movieEditor
    Created on : Sep 24, 2016, 5:09:43 PM
    Author     : Jeffrey
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Modify a Movie</title>
    </head>
    <body>
        <h1>Make your changes</h1>
        
        <form action="<c:out value='MovieServlet'/>" method="post">
            <input type="hidden" name="action" value="updateMovie">
            <input type="hidden" name="movieID" value="<c:out value='${movie.movieID}'/>"> 
            <label>Movie:</label>
                <input type="text" name="movieName" value="<c:out value='${movie.movieName}'/>"><br/>
            <label>Year:</label>
                <input type="text" name="movieYear" value="<c:out value='${movie.movieYear}'/>"><br/>
            <label class="pad_top">&nbsp;</label>
                <input type="submit" value="Make Changes" class="btn">
        </form>
                
        <form action="<c:url value='MovieServlet'/>" method="get">
            <input type="hidden" name="action" value="displayMovies">
            <input type="submit" value="View Movies" class="btn">
        </form>
        
        
        
    </body>
</html>
