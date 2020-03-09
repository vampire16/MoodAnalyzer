import org.junit.Assert;
import org.junit.Test;

public class TestCases {
    MoodAnalyzer moodAnalyzer;

    @Test
    public void givenMessage_WhenMoodSad_ShouldReturnSad(){
        moodAnalyzer = new MoodAnalyzer("I am in sad mood");
        Assert.assertEquals("Sad",moodAnalyzer.analyzer());
    }

    @Test
    public void givenMessage_WhenMoodAny_ShouldReturnHappy(){
        moodAnalyzer = new MoodAnalyzer("I am in any mood");
        Assert.assertEquals("Happy",moodAnalyzer.analyzer());
    }
}
