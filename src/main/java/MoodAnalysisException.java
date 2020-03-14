public class MoodAnalysisException extends Exception {
    enum UserDefinedType {
        NULL_EXCEPTION,
        EMPTY_EXCEPTION,
        NO_SUCH_CLASS,
        NO_SUCH_METHOD,
        NO_SUCH_FIELD,
        INVOCATION_TARGET_EXCEPTION,
        ILLEGAL_ACCESS_EXCEPTION,
        INSTANTIATION_EXCEPTION
    };

    UserDefinedType userDefinedType;

    public MoodAnalysisException(String message, UserDefinedType userDefinedType) {
        super(message);
        this.userDefinedType = userDefinedType;
    }
}
