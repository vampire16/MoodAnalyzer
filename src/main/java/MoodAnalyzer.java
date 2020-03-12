import java.util.Objects;

public class MoodAnalyzer<analyseMood> {
    String message;
    public static void main(String[] args) {
        System.out.println("Welcome to mood analyzer");
    }

    public MoodAnalyzer() { }

    public MoodAnalyzer(String message) {
        this.message=message;
    }

    public String analyzer() throws MoodAnalysisException {
        try {
            if(message.length()==0)
                throw new MoodAnalysisException("Message should not empty",MoodAnalysisException.UserDefinedType.EMPTY_EXCEPTION);
            else if (message.contains("sad"))
                return "Sad";
            else
                return "Happy";
        }
        catch(NullPointerException e){
            throw new MoodAnalysisException("Message should not null", MoodAnalysisException.UserDefinedType.NULL_EXCEPTION);
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MoodAnalyzer<?> that = (MoodAnalyzer<?>) o;
        return Objects.equals(message, that.message);
    }

    @Override
    public int hashCode() {
        return Objects.hash(message);
    }
}