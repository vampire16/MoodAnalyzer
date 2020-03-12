import org.junit.Assert;
import org.junit.Test;

public class TestCases {
    MoodAnalyzer moodAnalyzer;

    @Test
    public void givenMessage_WhenMoodSad_ShouldReturnSad() throws MoodAnalysisException {
        moodAnalyzer = new MoodAnalyzer("I am in sad mood");
        Assert.assertEquals("Sad",moodAnalyzer.analyzer());
    }

    @Test
    public void givenMessage_WhenMoodAny_ShouldReturnHappy() throws MoodAnalysisException {
        moodAnalyzer = new MoodAnalyzer("I am in any mood");
        Assert.assertEquals("Happy",moodAnalyzer.analyzer());
    }

    @Test
    public void givenMessage_WhenNull_ThenShouldReturnHappy() throws MoodAnalysisException {
        moodAnalyzer = new MoodAnalyzer(null);
        Assert.assertEquals("Happy",moodAnalyzer.analyzer());
    }

    @Test
    public void givenMessage_WhenNull_ThenShouldReturnCustomException() {
        try {
            moodAnalyzer = new MoodAnalyzer(null);
            moodAnalyzer.analyzer();
        }
        catch(MoodAnalysisException e) {
            Assert.assertEquals(MoodAnalysisException.UserDefinedType.NULL_EXCEPTION,e.userDefinedType);
        }
    }

    @Test
    public void givenMessage_WhenEmpty_ThenShouldReturnCustomException() {
        try{
            moodAnalyzer=new MoodAnalyzer("");
            moodAnalyzer.analyzer();
        }
        catch(MoodAnalysisException e){
            Assert.assertEquals(MoodAnalysisException.UserDefinedType.EMPTY_EXCEPTION,e.userDefinedType);
        }
    }

    @Test
    public void givenObject_WhenEquals_ThenReturnTrue() throws MoodAnalysisException {
        moodAnalyzer=new MoodAnalyzer();
        MoodAnalyzer moodAnalyserObject = MoodAnalyserFactory.createMoodAnalyserObject();
        boolean result=moodAnalyzer.equals(moodAnalyserObject);
        Assert.assertTrue("true",result);
    }

    @Test
    public void givenClass_WhenWrong_ThenShouldReturnClassNotFound() {
        try {
            MoodAnalyserFactory.createMoodAnalyserObject();
        } catch (MoodAnalysisException e) {
            Assert.assertEquals(MoodAnalysisException.UserDefinedType.NO_SUCH_CLASS,e.userDefinedType);
        }
    }

    @Test
    public void givenMethod_WhenWrong_ThenShouldReturnNoSuchMethod() {
        try {
            MoodAnalyserFactory.createMoodAnalyserObject();
        } catch (MoodAnalysisException e) {
            Assert.assertEquals(MoodAnalysisException.UserDefinedType.NO_SUCH_METHOD,e.userDefinedType);
        }
    }

}
