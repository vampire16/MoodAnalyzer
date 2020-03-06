import org.junit.Assert;
import org.junit.Test;

public class TestCases {

    @Test
    public void givenMessage_whenMoodSad_shouldReturnSad(){
        MoodAnalyzer moodAnalyzer=new MoodAnalyzer("I am in sad mood");
        Assert.assertEquals("Sad",moodAnalyzer.analyzer());
    }

    @Test
    public void givenMessage_whenMoodAny_shouldReturnHappy(){
        MoodAnalyzer moodAnalyzer=new MoodAnalyzer("I am in any mood");
        Assert.assertEquals("Happy",moodAnalyzer.analyzer());
    }
}
