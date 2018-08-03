package history;

import org.junit.Assert;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class DataStoryTest {

    @Test
    public void test_Add(){
        DataStory dataStory = new DataStory();
        boolean res=dataStory.add("one", "two");
        Assert.assertTrue(res);
    }

    @Test
    public void test_get(){
        DataStory dataStory = new DataStory();
        dataStory.add("one", "two");
        String res = dataStory.getList().get(0)[0]+dataStory.getList().get(0)[1];
        Assert.assertEquals("onetwo",res);
    }
}