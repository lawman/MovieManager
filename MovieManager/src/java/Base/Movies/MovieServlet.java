/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Base.Movies;

import Base.User.Customer;
import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Jeffrey
 */
public class MovieServlet extends HttpServlet 
{

    /**
     * 
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException 
    {
        HttpSession session = request.getSession();
        
        //Page Info
        String action = request.getParameter("action");
        String url = "/index.jsp";
        
        //movieList Data
        String path = getServletContext().getRealPath("/WEB-INF/movieList.txt");
        MovieDB movieDB = new MovieDB(path);
        ArrayList<Movie> movies = movieDB.populateList();
        session.setAttribute("movies", movies);
        
        String currentID = request.getParameter("movieID");
        
        
        System.out.println("1. Movie ID: " + currentID);
        System.out.println("1. Action: " + action);
        
        if (action == null)
        {
            action = "index";
            
        }
        //could turn into switch statments to reduce redundancy
        switch (action) {
            case "index":
                url = "/index.jsp";
                break;
            case "displayMovies":
                movies = movieDB.populateList();
                session.setAttribute("movies", movies);
                url = "/movieList.jsp";
                break;
            case "edit":
                {
                    Movie m = movieDB.searchMovieID(currentID);
                    if(m != null)
                    {
                        request.setAttribute("movie", m);
                        System.out.println("Edit - Movie attribute set to: " + m.getMovieName());
                        
                    } else
                    {
                        System.out.println("Edit - Movie not found with ID");
                    }       
                    url = "/movieEditor.jsp";
                    break;
                }
            case "check":
            {
                Movie m = movieDB.searchMovieID(currentID);
                if(m != null)
                {
                    request.setAttribute("movie", m);
                    request.setAttribute("customer", "This Customer Is New");
                    System.out.println("Checkout - MovieName: " + m.getMovieName());
                } else
                {
                    System.out.println("Checkout - Movie not found with ID");
                }       
                url = "/movieCheckout.jsp";
                break;
            }
            case "checkOut":
                try
                {
                    Movie m = movieDB.searchMovie(request.getParameter("movieName"));
                    Customer c = new Customer(request.getParameter("customer"));
                    c.checkOut(m.getMovieID());
                    movieDB.searchMovieID(m.getMovieID()).setCheckedOut(true);
                    request.setAttribute("message", "Checkout " + m.getMovieName() + " to " + c.getCName() + " successful.");
                    
                } catch(Exception e)
                {
                    request.setAttribute("message", "ERROR - Checkout failed.");
                    System.out.println("checkOut - Exception: " + e.getMessage());
                }   
                url = "/movieList.jsp";
                break;
            case "updateMovie":
                try
                {
                    Movie movieNew = new Movie(currentID, (String)request.getParameter("movieName"), (String)request.getParameter("movieYear"));
                    
                    if(currentID != null)
                    {
                        movieDB.updateMovie(movieNew);
                        
                    } else
                    {
                        System.out.println("UpdateMovie - Movie not found to update!");
                        request.setAttribute("message", "Movie cannot update without proper ID");
                    }
                    
                    //movieDB.saveMovieList();
//                  movies = movieDB.populateList();
//                  session.setAttribute("movies", movies);   if breaks, remove comment
                } catch(Exception e)
                {
                    System.out.println("UpdateMovie - Exception: " + e.toString());
                }
                url = "/movieList.jsp";
                break;
            default:
                System.out.println("No action?!?!?");
                break;
        }
        
//        movies = movieDB.getList();
//        session.setAttribute("movies", movies);
//        System.out.println("Update Finished: updated List");
        
        System.out.println("\nEnd of Post? - Action: " + action);
        //System.out.println("Db_List: " + movieDB.toString());
        
        getServletContext()
                .getRequestDispatcher(url)
                .forward(request, response);
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException 
    {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException 
    {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() 
    {
        return "Short description";
    }// </editor-fold>

}
