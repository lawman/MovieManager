package Base.Movies;

import java.io.Serializable;

public class Movie implements Serializable
{
    private String movieID;
    private String movieName;
    private String movieYear;
    private boolean checkedOut = false;
    
    public Movie() 
    {
        this.movieID = "";
        this.movieName = "";
        this.movieYear = "-1";
    }
    
    public Movie(String name)
    {
        this.movieID = name;
        this.movieName = name;
        this.movieYear = "-1";
        
    }
    
    public Movie(String name, String year)
    {
        this.movieID = name + year;
        this.movieName = name;
        this.movieYear = year;
    }
    
    public Movie(String id, String name, String year)
    {
        this.movieID = id;
        this.movieName = name;
        this.movieYear = year;
    }
    
    
    public String getMovieID()
    {
        return this.movieID; 
    }
    public void setMovieID(String id)
    {
        this.movieID = id;
    }
    
    public String getMovieName()
    {
        return this.movieName;
    }
    
    public void setMovieName(String name)
    {
        this.movieName = name;
    }
    
    public String getMovieYear()
    {
        return this.movieYear;
    }
    public int getIntMovieYear()
    {
        return Integer.parseInt(this.movieYear);
    }
    
    public void setMovieYear(String year)
    {
        this.movieYear = year;
    }
    
    public void setUpdateInfo(String name, String year)
    {
        this.movieName = name;
        this.movieYear = year;
    }
    public boolean getCheckedOut()
    {
        return this.checkedOut;
    }
    public void setCheckedOut(boolean c)
    {
        this.checkedOut = c;
    }
    
    public String generateID(String movieName)
    {
        return "String";
    }
    
    @Override
    public String toString()
    {
        return getMovieName() + " , " + getMovieYear();
    }
    
    
    
}
