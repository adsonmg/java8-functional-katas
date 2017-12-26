package katas;

import model.BoxArt;
import model.Movie;
import util.DataUtil;

import java.util.List;

/*
    Goal: Retrieve the url of the largest boxart using map() and reduce()
    DataSource: DataUtil.getMovieLists()
    Output: String
*/
public class Kata6 {
    public static String execute() {
        List<Movie> movies = DataUtil.getMovies();
        
        return movies.stream().
	        	map(Movie::getBoxarts).
	        	flatMap(c -> c.stream()).
	        	max((BoxArt b1, BoxArt b2) -> Integer.compare(b1.getHeight()*b1.getWidth(), b2.getHeight()*b2.getWidth())).
	        	get().
	        	getUrl();

    }
}
