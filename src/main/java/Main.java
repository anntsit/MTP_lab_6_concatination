import concatenation.ConcatenationWithHashSet;

public class Main {

    public static void main(String[] args) {
        System.out.println("FINDING CONCATENATED WORDS WITH HASH SET IMPLEMENTATION\n");

        ConcatenationWithHashSet concatenation = new ConcatenationWithHashSet();
        concatenation.getWordsFromFile("words.txt");
        Metrix.start();
        concatenation.findConcatenatedWords();
        Metrix.stop();
        Metrix.getAllMetrics();
        concatenation.getAllInfo();
    }
}
