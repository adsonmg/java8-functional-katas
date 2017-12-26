package katas;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import model.BoxArt;
import model.Movie;
import model.MovieList;
import util.DataUtil;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/*
    Goal: Retrieve id, title, and a 150x200 box art url for every video
    DataSource: DataUtil.getMovieLists()
    Output: List of ImmutableMap.of("id", "5", "title", "Bad Boys", "boxart": BoxArt)
    
    return ImmutableList.of(ImmutableMap.of("id", 5, "title", "Bad Boys", "boxart", new BoxArt(150, 200, "url")));

*/
public class Kata4 {
    public static List<Map> execute() {
        List<MovieList> movieLists = DataUtil.getMovieLists();
        
        return movieLists.stream().
        		map(MovieList::getVideos).
        		flatMap(List::stream).
        		map((Movie m) -> ImmutableMap.builder()
        				.put("id", m.getId())
        				.put("title", m.getTitle())
        				.put("boxart", m.getBoxarts().stream().
        						filter(b -> b.getWidth()==150 && b.getHeight()==200).
        						findFirst()).build()
        				)
        		.collect(Collectors.toList());


    }
}
