import org.junit.*;

import static org.junit.Assert.*;

import concatenation.*;

import java.io.IOException;

public class ConcatenationTest {
    private ConcatenationWithHashSet concatenation;

    @Before
    public void init() throws Exception {
        concatenation = new ConcatenationWithHashSet();
        concatenation.getWordsFromFile("test.txt");
        concatenation.findConcatenatedWords();
    }

    @Test
    public void findConcatenatedWordsTrieTest() throws IOException {
        String check = "ratcatdogcat";
        assertEquals(concatenation.concatenatedWords.get(0), check);
    }


    @Test
    public void getFirstLongestConcatenatedWordTest() {
        String check = "ratcatdogcat";
        assertEquals(concatenation.getFirstLongestConcatenatedWord(), check);
    }

    @Test
    public void getSecondLongestConcatenatedWordTest() {
        String check = "catsdogcats";
        assertEquals(concatenation.getSecondLongestConcatenatedWord(), check);
    }

    @Test
    public void getNumberOfConcatenatedWordsTest() {
        int check = 3;
        assertEquals(concatenation.getNumberOfConcatenatedWords(), check);
    }
}
