import org.junit.*;

import static org.junit.Assert.*;

import concatenation.*;

import java.io.IOException;

public class ConcatenationTest {
    private ConcatenationWithHashSet concat;

    @Before
    public void init() throws Exception {
        concat = new ConcatenationWithHashSet();
        concat.getWordsFromFile("test.txt");
        concat.findConcatenatedWords();
    }

    @Test
    public void findConcatenatedWordsTrieTest() throws IOException {
        String check = "ratcatdogcat";
        assertEquals(concat.concatenatedWords.get(0), check);
    }


    @Test
    public void getFirstLongestConcatenatedWordTest() {
        String check = "ratcatdogcat";
        assertEquals(concat.getFirstLongestConcatenatedWord(), check);
    }

    @Test
    public void getSecondLongestConcatenatedWordTest() {
        String check = "catsdogcats";
        assertEquals(concat.getSecondLongestConcatenatedWord(), check);
    }

    @Test
    public void getNumberOfConcatenatedWordsTest() {
        int check = 3;
        assertEquals(concat.getNumberOfConcatenatedWords(), check);
    }

    @Test
    public void getAllInfo(){
        assertEquals(true, concat.getAllInfo());
    }

    @Test
    public void getWordsFromFile() {
        assertEquals(true, concat.getWordsFromFile("test.txt"));
    }
}
