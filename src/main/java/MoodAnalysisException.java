public class MoodAnalysisException extends Exception {
    enum UserDefinedType {
        NULL_EXCEPTION,
        EMPTY_EXCEPTION,
        NO_SUCH_CLASS
    };

    UserDefinedType userDefinedType;

    public MoodAnalysisException(String message, UserDefinedType userDefinedType) {
        super(message);
        this.userDefinedType = userDefinedType;
    }

    public MoodAnalysisException(String message, Throwable cause, UserDefinedType userDefinedType) {
        super(message, cause);
        this.userDefinedType = userDefinedType;
    }

    public MoodAnalysisException(Throwable cause, UserDefinedType userDefinedType) {
        super(cause);
        this.userDefinedType = userDefinedType;
    }
}
