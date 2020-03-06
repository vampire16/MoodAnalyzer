public class MoodAnalyzer<analyseMood> {
    String message;
    public static void main(String[] args) {
        System.out.println("welcome to mood analyzer");
    }

    public MoodAnalyzer() {
    }

    public MoodAnalyzer(String message) {
        this.message=message;
    }

    public String analyzer(){
        if (message.contains("sad"))
            return "Sad";
        else
            return "Happy";
    }
}

