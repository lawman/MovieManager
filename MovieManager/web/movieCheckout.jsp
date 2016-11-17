<%-- 
    Document   : movieCheckout
    Created on : Sep 24, 2016, 7:04:57 PM
    Author     : Jeffrey
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Check out a movie!</title>
    </head>
    <body>
        <h1>Hello, Worldling!</h1>
        <p>Who's checking out today?</p>
        <form action="<c:out value='MovieServlet'/>" method="post">
            <input type="hidden" name="action" value="check">
            <label>Checking out to:</label>
            <input type="text" name="customer" value="<c:out value='${customer}'/>"><br/>
            
            <label>Movie:</label>
            <input type="text" name="movieName" value="<c:out value='${movie.movieName}'/>"><br/>
            
            <label>Year:</label>
            <input type="text" name="movieYear" value="<c:out value='${movie.movieYear}'/>"><br/>
            <input type="submit" value="Check out movie" class="btn">
        </form>
            
        <form action="<c:url value='MovieServlet'/>" method="get">
            <input type="hidden" name="action" value="displayMovies">
            <input type="submit" value="View Movies" class="btn">
        </form>
    </body>
</html>
