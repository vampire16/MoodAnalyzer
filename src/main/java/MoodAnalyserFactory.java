import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class MoodAnalyserFactory {
    public static Constructor getConstructor(String className,Class<?> ... param) throws MoodAnalysisException {
        try {
            Class<?> moodClass = Class.forName(className);
            return moodClass.getConstructor(param);
        } catch (ClassNotFoundException e) {
            throw new MoodAnalysisException("class not found",MoodAnalysisException.UserDefinedType.NO_SUCH_CLASS);
        } catch (NoSuchMethodException e) {
            throw new MoodAnalysisException("Method not found",MoodAnalysisException.UserDefinedType.NO_SUCH_METHOD);
        }
    }

    public static MoodAnalyzer createMoodAnalyserObject(Constructor constructor, Object... objects) throws MoodAnalysisException{
        try {
            return (MoodAnalyzer) constructor.newInstance(objects);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static Object invokeMethod(Object moodAnalyserObject, String analyzer) throws MoodAnalysisException {
        try{
        Class objectClass = moodAnalyserObject.getClass();
        Method moodMethod = objectClass.getMethod(analyzer);
        Object result = moodMethod.invoke(moodAnalyserObject);
        return result;
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            throw new MoodAnalysisException("Method not found",MoodAnalysisException.UserDefinedType.NO_SUCH_METHOD);
        }
        return null;
    }

    public static void setFieldValue(Object moodObject,String fieldName,String fieldValue){
        try {
            Class<?> moodClass = moodObject.getClass();
            Field declaredField = moodClass.getDeclaredField(fieldName);
            declaredField.set(moodObject,fieldValue);
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }

}
