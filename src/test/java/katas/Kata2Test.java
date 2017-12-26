package katas;

import org.junit.Assert;
import org.junit.Test;

import model.Movie;
import util.DataUtil;

import static org.hamcrest.CoreMatchers.equalTo;


public class Kata2Test {
	
	@Test
	public void testNotNull() {
		Assert.assertNotNull(Kata2.execute());
	}
	
    @Test
    public void testExecute() {
        Assert.assertThat(Kata2.execute().size(), equalTo(2));
    }
    
    
    @Test
    public void testIds() {
    	Assert.assertEquals(DataUtil.getMovies().get(1).getId(), Kata2.execute().get(0));
    	Assert.assertEquals(DataUtil.getMovies().get(3).getId(), Kata2.execute().get(1));
    }
}
