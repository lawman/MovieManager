package Base.Movies;

import java.io.Serializable;

public class Movie implements Serializable
{
    private String movieID;
    private String movieName;
    private int movieYear;
    private boolean checkedOut = false;
    
    public Movie() 
    {
        movieID = "";
        movieName = "";
        movieYear = -1;
    }
    
    public Movie(String name)
    {
        movieName = name;
        movieID = name;
    }
    
    public Movie(String name, int year)
    {
        movieID = name + year;
        movieName = name;
        movieYear = year;
    }
    
    public Movie(String id, String name, int year)
    {
        movieID = id;
        movieName = name;
        movieYear = year;
    }
    
    
    public String getMovieID()
    {
        return movieID; 
    }
    public void setMovieID(String id)
    {
        movieID = id;
    }
    
    public String getMovieName()
    {
        return movieName;
    }
    
    public void setMovieName(String name)
    {
        movieName = name;
    }
    
    public int getMovieYear()
    {
        return movieYear;
    }
    
    public void setMovieYear(int year)
    {
        movieYear = year;
    }
    
    public boolean getCheckedOut()
    {
        return checkedOut;
    }
    public void setCheckedOut(boolean c)
    {
        checkedOut = c;
    }
    
    @Override
    public String toString()
    {
        return getMovieName() + " , " + getMovieYear();
    }
    
    
}
