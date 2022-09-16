package hangman;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.junit.Test;

public class GameTest
{
    WordChooser mockChooser = mock(WordChooser.class);

    @Test public void testGetsWordToGuess()
    {
        when(mockChooser.getRandomWordFromDictionary()).thenReturn("DEVELOPER");

        Game game = new Game(mockChooser);
        
        assertEquals(game.getWordToGuess(), "D________");
    }

    @Test public void testGuessCharacterTrue()
    {
        when(mockChooser.getRandomWordFromDictionary()).thenReturn("MAKERS");

        Game game = new Game(mockChooser);

        assertEquals(game.guessLetter('K'), true);
        assertEquals(game.getWordToGuess(), "M_K___");
    }


    @Test public void testGuessCharacterFalse()
    {
        when(mockChooser.getRandomWordFromDictionary()).thenReturn("MAKERS");

        Game game = new Game(mockChooser);

        assertEquals(game.guessLetter('Z'), false);
        assertEquals(game.getWordToGuess(), "M_____");
    }
    
    @Test public void testIsGameWon()
    {
        when(mockChooser.getRandomWordFromDictionary()).thenReturn("WON");

        Game game = new Game(mockChooser);

        assertEquals(game.guessLetter('W'), true);
        assertEquals(game.guessLetter('O'), true);
        assertEquals(game.guessLetter('N'), true);

        assertEquals(game.isGameWon(), true);
    }

    @Test public void testIsGameWonWithSpecialWord()
    {
        when(mockChooser.getRandomWordFromDictionary()).thenReturn("WOON");

        Game game = new Game(mockChooser);

        assertEquals(game.guessLetter('W'), true);
        assertEquals(game.guessLetter('O'), true);
        assertEquals(game.guessLetter('N'), true);

        assertEquals(game.isGameWon(), true);
    }

    @Test public void testIsGameLost()
    {
        when(mockChooser.getRandomWordFromDictionary()).thenReturn("MAKERS");

        Game game = new Game(mockChooser);

        assertEquals(game.guessLetter('Z'), false);
        assertEquals(game.guessLetter('Z'), false);
        assertEquals(game.guessLetter('Z'), false);
        assertEquals(game.guessLetter('Z'), false);
        assertEquals(game.guessLetter('Z'), false);
        assertEquals(game.guessLetter('Z'), false);
        assertEquals(game.guessLetter('Z'), false);
        assertEquals(game.guessLetter('Z'), false);
        assertEquals(game.guessLetter('Z'), false);
        assertEquals(game.guessLetter('Z'), false);

        assertTrue("fails if too many incorrect guesses", game.isGameLost());
    }
}