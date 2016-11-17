package Base.Movies;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;


public class MovieDB {
    private final String fileName = "C:\\Users\\Jeffrey\\Documents\\NetBeansProjects\\MovieManager\\WEB-INF\\movieList.txt";
    private final File f;
    private ArrayList<Movie> movieList = new ArrayList<>();
    
    
    public MovieDB ()
    {
        this.f = new File(fileName);
        populateList();
    }
    
    public MovieDB (String fName)
    {
        this.f = new File(fName);
        populateList();
    }
    
    public void populateList()
    {   
        String line;
        String movieName;
        //int year;
        
        try
        {
            FileReader fileReader = new FileReader(f);
            BufferedReader bufferReader = new BufferedReader(fileReader);
            
            while((line = bufferReader.readLine()) != null)
            {
                movieName = line; //substring up to '-'   ?
                //year = list.subString("after an '-'?");
                
                Movie m = new Movie(movieName/*, year*/);
                movieList.add(m);
            }
        }
        catch(FileNotFoundException ex)
        {
            System.out.println("File not found:" + f.toString() + "\n" + ex.toString());
        }
        catch(IOException ex)
        {
            System.out.println("Error reading from file..." + "\n" + ex.toString());
        }
    }
    
    public ArrayList<Movie> getList()
    {
        if(movieList == null)
        {
            this.populateList();
        }
        return movieList;
    }
    
    public void addMovie(String name, int year)
    {
        Movie m = new Movie(name, year);
        movieList.add(m);
    }
    public void addMovie(Movie m)
    {
        movieList.add(m);
    }
    
    //Search for a single movie by name<>
    //TODO: Add search which returns list of movies where 'name.contains' search parameter
    public Movie searchMovie(String movie)
    {
        for(Movie m: movieList)
        {
            if(m.getMovieName().equalsIgnoreCase(movie))
            {
                return m;
            }
        }
        
        return null;
    }
    public Movie searchMovieID(String id)
    {
        for(Movie m: movieList)
        {
            if(m.getMovieID().equals(id))
            {
                System.out.println("MovieDB - Search - Found the Movie: " + m.toString());
                return m;
                
            }
        }
        
        return null;
    }
    
    @Override
    public String toString()
    {
        String list = "";
        for(Movie m: movieList)
        {
            list += m.toString() + "\n";
        }
        
        
        
        return "";
    }
    
    
}
