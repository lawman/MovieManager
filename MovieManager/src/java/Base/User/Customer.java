package Base.User;

import Base.Movies.Movie;
import java.util.ArrayList;

public class Customer {
    private String cName;
    private String cAddress;
    private ArrayList<String> cMoviesList = new ArrayList<>();  //stores iDs of movies
    
    public Customer()
    {
        cName = null;
        cAddress = null;
    }
    
    public Customer(String name)
    {
        cName = name;
        cAddress = null;
    }
    
    public void setCName(String name)
    {
        cName = name;
    }
    
    public String getCName()
    {
        return cName;
    }
    
    public void setCAddress(String adr)
    {
        cAddress = adr;
    }
    
    public String getCAddress()
    {
        return cAddress;
    }
    
    public void checkOut(String id)
    {
        cMoviesList.add(id);
    }
    public void checkIn(String id)
    {
        cMoviesList.remove(id);
    }
    
}
