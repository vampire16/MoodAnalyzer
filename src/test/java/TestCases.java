import org.junit.Assert;
import org.junit.Test;

import java.lang.reflect.Constructor;

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
        Constructor constructor=MoodAnalyserFactory.getConstructor("MoodAnalyzer");
        MoodAnalyzer moodAnalyserObject = MoodAnalyserFactory.createMoodAnalyserObject(constructor);
        boolean result=moodAnalyzer.equals(moodAnalyserObject);
        Assert.assertTrue("true",result);
    }

    @Test
    public void givenClass_WhenWrong_ThenShouldReturnClassNotFound() {
        try {
            MoodAnalyserFactory.getConstructor("MoodAnalyser");
        } catch (MoodAnalysisException e) {
            Assert.assertEquals(MoodAnalysisException.UserDefinedType.NO_SUCH_CLASS,e.userDefinedType);
        }
    }

    @Test
    public void givenConstructor_WhenWrong_ThenShouldReturnNoSuchMethod() {
        try {
            MoodAnalyserFactory.getConstructor("MoodAnalyzer",Integer.class);
        } catch (MoodAnalysisException e) {
            Assert.assertEquals(MoodAnalysisException.UserDefinedType.NO_SUCH_METHOD,e.userDefinedType);
        }
    }

    @Test
    public void givenObject_WhenEqualsWithParamConstructor_ThenReturnTrue() throws MoodAnalysisException {
        moodAnalyzer=new MoodAnalyzer("Hello");
        Constructor constructor=MoodAnalyserFactory.getConstructor("MoodAnalyzer",String.class);
        MoodAnalyzer moodAnalyserObject = MoodAnalyserFactory.createMoodAnalyserObject(constructor,"Hello");
        boolean result=moodAnalyzer.equals(moodAnalyserObject);
        Assert.assertTrue("true",result);
    }

    @Test
    public void givenClassNameWithParamConstructor_WhenWrong_ThenShouldReturnClassNotFound() {
        try {
            MoodAnalyserFactory.getConstructor("MoodAnalyser",String.class);
        } catch (MoodAnalysisException e) {
            Assert.assertEquals(MoodAnalysisException.UserDefinedType.NO_SUCH_CLASS,e.userDefinedType);
        }
    }

    @Test
    public void givenParamConstructor_WhenWrong_ThenShouldReturnNoSuchMethod() {
        try {
            MoodAnalyserFactory.getConstructor("MoodAnalyzer",String.class,Integer.class);
        } catch (MoodAnalysisException e) {
            Assert.assertEquals(MoodAnalysisException.UserDefinedType.NO_SUCH_METHOD,e.userDefinedType);
        }
    }


}
