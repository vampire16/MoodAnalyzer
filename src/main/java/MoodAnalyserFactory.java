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
            throw new MoodAnalysisException(e.getMessage(),MoodAnalysisException.UserDefinedType.ILLEGAL_ACCESS_EXCEPTION);
        } catch (InstantiationException e) {
            throw new MoodAnalysisException(e.getMessage(),MoodAnalysisException.UserDefinedType.INSTANTIATION_EXCEPTION);
        } catch (InvocationTargetException e) {
            throw new MoodAnalysisException(e.getMessage(),MoodAnalysisException.UserDefinedType.INVOCATION_TARGET_EXCEPTION);
        }
    }

    public static Object invokeMethod(Object moodAnalyserObject, String analyzer) throws MoodAnalysisException {
        try{
        Class objectClass = moodAnalyserObject.getClass();
        Method moodMethod = objectClass.getMethod(analyzer);
        Object result = moodMethod.invoke(moodAnalyserObject);
        return result;
        } catch (IllegalAccessException e) {
            throw new MoodAnalysisException(e.getMessage(),MoodAnalysisException.UserDefinedType.ILLEGAL_ACCESS_EXCEPTION);
        } catch (InvocationTargetException e) {
            throw new MoodAnalysisException(e.getMessage(),MoodAnalysisException.UserDefinedType.INVOCATION_TARGET_EXCEPTION);
        } catch (NoSuchMethodException e) {
            throw new MoodAnalysisException("Method not found",MoodAnalysisException.UserDefinedType.NO_SUCH_METHOD);
        }
    }

    public static void setFieldValue(Object moodObject,String fieldName,String fieldValue) throws MoodAnalysisException {
        try {
            Class<?> moodClass = moodObject.getClass();
            Field declaredField = moodClass.getDeclaredField(fieldName);
            declaredField.set(moodObject,fieldValue);
        } catch (NoSuchFieldException e) {
            throw new MoodAnalysisException("Field not found",MoodAnalysisException.UserDefinedType.NO_SUCH_FIELD);
        } catch (IllegalAccessException e) {
            throw new MoodAnalysisException("Message should not null",MoodAnalysisException.UserDefinedType.ILLEGAL_ACCESS_EXCEPTION);
        }
    }

}
