<%-- 
    Document   : movieList
    Created on : Sep 23, 2016, 3:05:51 PM
    Author     : Jeffrey

    TODO:
        Connect to servlet
        -Access movieDB
        -Pull movies into list
        -Populate list of movies
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>View Your Movies</title>
    </head>
    <body>
        <h1>Products</h1>
        <table>
            <tr>
                <th>Name</th>
                <th>Year</th>
                <th>Checked Out</th>
                <th>Edit</th>
                <th>Check Out</th>
            </tr> 
            <tr>
                <td>Movie 1</td>
                <td>Year 1</td>
                <td>True</td>
                <td>Edit</td>
                <td>Check Out</td>
            </tr>
            <c:forEach var="movie" items="${sessionScope.movies}">
                <tr>
                    <td><c:out value='${pageScope.movie.movieName}'/></td>
                    <td><c:out value='${pageScope.movie.movieYear}'/></td>
                    <td><c:out value='${pageScope.movie.getCheckedOut()}'/></td>
                    <td>
                        <form action="<c:out value='${movieServlet}'/>" method="post">
                            <input type="hidden" name="action" value="edit"/>
                            <input type="hidden" name="movieID" value="<c:out value='${movie.movieID}'/>"/>
                            <input type="submit" value="Edit"/>
                        </form>
                    </td>
                    <td>
                        <form action="<c:out value='${movieServlet}'/>" method="post">
                            <input type="hidden" name="action" value="check">
                            <input type="hidden" name="movieID" value="<c:out value='${movie.movieID}'/>">
                            <input type="submit" value="Check In/Out">
                        </form>
                    </td>
                </tr>
            </c:forEach>
        </table>
    </body>
</html>
