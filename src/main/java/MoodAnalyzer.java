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
            if (message.contains("sad"))
                return "Sad";
            else
                return "Happy";
        }
        catch(NullPointerException e){
            throw new MoodAnalysisException("Message should not null", MoodAnalysisException.UserDefinedType.NULL_EXCEPTION);
        }
    }
}