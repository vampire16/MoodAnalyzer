public class MoodAnalyzer<analyseMood> {
    public static void main(String[] args) {
        System.out.println("welcome to mood analyzer");
    }

    public String analyzer(String mood){
        if (mood.contains("sad"))
            return "Sad";
        else
            return "Happy";
    }
}

