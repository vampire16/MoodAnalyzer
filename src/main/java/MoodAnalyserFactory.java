import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class MoodAnalyserFactory {
    public static MoodAnalyzer createMoodAnalyserObject(Constructor constructor) throws MoodAnalysisException{
        try {
            return (MoodAnalyzer) constructor.newInstance();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static Constructor getConstructor(String className,Class<?>... param) throws MoodAnalysisException {
        try {
            Class<?> moodClass = Class.forName(className);
            return moodClass.getConstructor(param);
        } catch (ClassNotFoundException e) {
            throw new MoodAnalysisException("class not found",MoodAnalysisException.UserDefinedType.NO_SUCH_CLASS);
        } catch (NoSuchMethodException e) {
            throw new MoodAnalysisException("Method not found",MoodAnalysisException.UserDefinedType.NO_SUCH_METHOD);
        }
    }
}
