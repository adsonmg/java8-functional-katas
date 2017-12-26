package katas;

import org.junit.Assert;
import org.junit.Test;

import com.google.common.collect.ImmutableList;

import static org.hamcrest.CoreMatchers.equalTo;

import java.util.ArrayList;
import java.util.List;


public class Kata3Test {

    @Test
    public void testExecute() {
    	
    	Assert.assertThat(Kata3.execute().size(), equalTo(4));
    	
    	List<Integer> valoresTeste = new ArrayList();
    	valoresTeste.add(70111470);
    	valoresTeste.add(654356453);
    	valoresTeste.add(65432445);
    	valoresTeste.add(675465);
        
        Assert.assertEquals(valoresTeste, Kata3.execute());
        
    }
}
