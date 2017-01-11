package Base.Movies;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;


public class MovieDB {
    private final String fileName = "C:\\Users\\Jeffrey\\Documents\\NetBeansProjects\\MovieManager\\web\\WEB-INF\\movieList.txt";
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
    
    public ArrayList<Movie> populateList()
    {   
        String line;
//        String iD;
//        String name;
//        String year;
        
//        movieList.clear();    removed to test overwriting probem
        
        try
        {
            FileReader fileReader = new FileReader(f);
            BufferedReader bufferReader = new BufferedReader(fileReader);
            //BufferedReader buffReader = new BufferedReader(new FileReader(f));
            while((line = bufferReader.readLine()) != null)
            {
                if (line.contains("-")) 
                {
                    StringTokenizer t = new StringTokenizer(line, "-");
                    
                    if (t.countTokens() >= 3) { 
                        String iD = t.nextToken();
                        String name = t.nextToken();
                        String year = t.nextToken();
                        Movie m = new Movie(iD, name, year);
                        movieList.add(m);
                    } else if(t.countTokens() == 2)
                    {
                        String iD = t.nextToken();
                        String name = t.nextToken();
                        Movie m = new Movie(iD, name, "4");
                        movieList.add(m);
                    } else
                    {
                        System.out.println("Womp Womp - Wiener");
                        String id = line.toString();
                        Movie m = new Movie(id);
                        movieList.add(m);
                    }
                } 
            }//End while
            bufferReader.close();
            
            return movieList;
        }
        catch(FileNotFoundException ex)
        {
            System.out.println("File not found:" + f.toString() + "\n" + ex.toString());
            return null;
        }
        catch(IOException ex)
        {
            System.out.println("Error reading from file..." + "\n" + ex.toString());
            return null;
        }
        catch(IllegalArgumentException e)
        {
            System.out.println("Illegal Argument Exception: " + e.toString());
            return null;
        }
        catch(Exception e)
        {
            System.out.println("Error: " + e.toString());
            return null;
        }
    }
    
    public boolean saveMovieList()
    {
        boolean saveSuccess;
        try {
            
            File file = new File(fileName);
            PrintWriter out = new PrintWriter(new FileWriter(file));
            
            System.out.println("\n  List: \n" + this.toString());
            
            for (Movie m : movieList) 
            {
                out.println(m.getMovieID() + "-" + m.getMovieName() + "-" + m.getMovieYear());
                
                //System.out.println("OutPutting: " + m.getMovieID() + "-" + m.getMovieName() + "-" + m.getMovieYear());
            }
            System.out.println("MovieDB - Movies saved to text complete.");
            out.close();
            saveSuccess = true;
            
        } catch (IOException e) 
        {
            
            saveSuccess = false;
            System.out.println(e);
            
        }
        return saveSuccess;
    }
    
//    public ArrayList<Movie> getList()
//    {
//           
//     
//        return this.populateList();;        
//    }
    
    public void updateMovie(Movie mov)
    {
        try
        {
            for(Movie m: movieList)
            {
                if(m.getMovieID().equals(mov.getMovieID()))
                {
//                    System.out.println("MovieDB - Update - Found the Movie: " + m.toString());
                    m.setUpdateInfo(mov.getMovieName(), mov.getMovieYear());
                    System.out.println("MovieDB - Update finished: " + m.toString());
                    break;
                    //Set breakPoint here after movie is found and modified
                }
            }
            if(this.saveMovieList())
            {
                System.out.println("MovieDB - Movie Update - Saved Movie List successful.");
            }
            
        }catch(Exception e)
        {
            System.out.println("MovieDB - UpdateMovie - Exception: " + e.toString());
        }
        
        
    }
    public void addMovie(String id, String name, String year)
    {
        Movie m = new Movie(id, name, year);
        movieList.add(m);
    }
    
    /*
    * Adds a movie to the ArrayList<Movie> movieList
    *
    * @param Movie m
    */
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
            if(m.getMovieName().equalsIgnoreCase(movie))                        //Change to movieID
            {
                return m;
            }
        }
        
        return null;
    }
    public Movie searchMovieID(String id)
    {
        System.out.println("MovieDB - Started movie Search by ID");
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
        
        return list;
    }
    
    
}
