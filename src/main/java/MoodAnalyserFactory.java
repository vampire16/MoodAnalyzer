import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class MoodAnalyserFactory {
    public static MoodAnalyzer createMoodAnalyserObject() throws MoodAnalysisException{
        try {
            Class<?> moodAnalyzerClass = Class.forName("MoodAnalyzer");
            Constructor<?> moodConstructor = moodAnalyzerClass.getConstructor(Integer.class);
            Object moodObject = moodConstructor.newInstance();
            return (MoodAnalyzer) moodObject;
        } catch (ClassNotFoundException e) {
            throw new MoodAnalysisException("class not found",MoodAnalysisException.UserDefinedType.NO_SUCH_CLASS);
        } catch (NoSuchMethodException e) {
            throw new MoodAnalysisException("Method not found",MoodAnalysisException.UserDefinedType.NO_SUCH_METHOD);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        return null;
    }
}
