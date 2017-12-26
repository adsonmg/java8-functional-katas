package katas;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import model.Bookmark;
import model.Movie;
import model.MovieList;
import util.DataUtil;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/*
    Goal: Retrieve the id, title, and smallest box art url for every video
    DataSource: DataUtil.getMovieLists()
    Output: List of ImmutableMap.of("id", "5", "title", "Bad Boys", "boxart": "url)
*/
public class Kata7 {
    public static List<Map> execute() {
        List<MovieList> movieLists = DataUtil.getMovieLists();
        
        return movieLists.stream().
        		map(MovieList::getVideos).
        		flatMap(List::stream).
        		map(movie -> ImmutableMap.builder()
        				.put("id", movie.getId())
        				.put("title", movie.getTitle())
        				.put("boxart", movie.getBoxarts().stream().
        						min((ba1, ba2) -> Integer.compare(ba1.getHeight()*ba2.getWidth(), ba2.getHeight()*ba2.getWidth())).
        				get().
        				getUrl()).
        				build()).
        				collect(Collectors.toList());

    }
}
