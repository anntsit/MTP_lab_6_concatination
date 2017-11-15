package concatenation;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Comparator;
import java.util.HashSet;
import java.util.stream.Stream;

public class ConcatenationWithHashSet extends ConcatenatedWords{
    private HashSet<String> hashSet;

    public ConcatenationWithHashSet(){
        hashSet = new HashSet<>();
    }

    public void getWordsFromFile(String path){
        try (Stream<String> stream = Files.lines(Paths.get(path))) {
            stream.forEach(word -> {
                hashSet.add(word);
            });
        } catch (IOException e) {
            System.out.println("Problem occurred while reading your file : " + e);
        }
    }

    /**
     * Method that checks if the word is concatenated by dividing it into
     * prefix and suffix, and then recursively checks if the current part
     * is in set of words.
     * @param word - word that needs to be checked.
     */
    private void checkForConcatenation(String word) {
        String prefix;
        String suffix;
        for (int i = 0; i <= word.length() - 1; i++) {
            prefix = word.substring(0, i + 1);
            suffix = word.substring(i + 1, word.length());

            if (hashSet.contains(prefix)) {
                if (hashSet.contains(suffix)) {
                    concatenatedWords.add(currentWord);
                    break;
                }
                checkForConcatenation(suffix);
            }
        }
    }

    /**
     * Method that looks for all concatenated words in Trie and in the end
     * sorts the ArrayList of concatenated words by length.
     * @return
     */
    public void findConcatenatedWords() {
        for (String word : hashSet) {
            currentWord = word;
            checkForConcatenation(word);
        }
        concatenatedWords.sort(Comparator.comparing(String::length).reversed());
    }
}
