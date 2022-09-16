package hangman;

import java.util.Arrays;

import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;

import org.junit.Test;

public class WordChooserTest
{
    WordChooser mockedList = mock(WordChooser.class);


    @Test
    public void testGetsDictionary()
    {
        WordChooser wordChooser = new WordChooser();
    
        String[] MOCK_DICT = { "MAKERS", "CANDIES", "DEVELOPER", "LONDON" };
        assertTrue(Arrays.asList(MOCK_DICT).contains(wordChooser.getRandomWordFromDictionary()));
    
    }
    
}