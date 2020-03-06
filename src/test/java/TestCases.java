import org.junit.Assert;
import org.junit.Test;

public class TestCases {
    MoodAnalyzer moodAnalyzer=new MoodAnalyzer();

    @Test
    public void givenMessage_whenMoodSad_shouldReturnSad(){
        String mood=moodAnalyzer.analyzer("I am in sad mood");
        Assert.assertEquals("Sad",mood);
    }
}
