package katas;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import model.Bookmark;
import model.BoxArt;
import model.InterestingMoment;
import model.Movie;
import model.MovieList;
import util.DataUtil;

import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/*
    Goal: Retrieve each video's id, title, middle interesting moment time, and smallest box art url
    DataSource: DataUtil.getMovies()
    Output: List of ImmutableMap.of("id", 5, "title", "some title", "time", new Date(), "url", "someUrl")
*/
public class Kata9 {
    public static List<Map> execute() {
        List<MovieList> movieLists = DataUtil.getMovieLists();

        return movieLists.stream().
        		map(MovieList::getVideos).
        		flatMap(List::stream).
        		map((Movie movie)->  ImmutableMap.builder().
        				put("id", movie.getId()).
        				put("title", movie.getTitle()).
        				put("time", movie.getInterestingMoments().
        								stream().
        								filter(moment -> moment.getType().equals("Middle")).
        								findFirst().
        								get().
        								getTime().toString()).
        				put("url", movie.getBoxarts().
        						stream().
        						min((BoxArt ba1, BoxArt ba2) -> Integer.compare(ba1.getHeight()*ba1.getWidth(), ba2.getHeight()*ba2.getWidth())).
        						get().
        						getUrl()).
        				build()
        			).collect(Collectors.toList());
    }
}
