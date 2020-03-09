public class MoodAnalyzer<analyseMood> {
    String message;
    public static void main(String[] args) {
        System.out.println("Welcome to mood analyzer");
    }

    public MoodAnalyzer() { }

    public MoodAnalyzer(String message) {
        this.message=message;
    }

    public String analyzer(){ return (message.contains("sad"))? "Sad" : "Happy"; }
}