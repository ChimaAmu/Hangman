package hangman;

import java.util.ArrayList;

public class Game
{
    private String word;
    private ArrayList<Character> guessedLetters = new ArrayList<Character>();
    Integer attempts = 10;

    public Game(WordChooser chooser)
    {
        word = chooser.getRandomWordFromDictionary();
    }

    public static void main(String[] args)
    {
        
    }
    
    public String getWordToGuess()
    {
        StringBuilder str = new StringBuilder();
        
        for (int i = 0; i < this.word.length(); i++)
        {   
            Character currentLetter = word.charAt(i);
            if (i == 0)
            {
                str.append(currentLetter);
            }
            else
            {
                if (guessedLetters.indexOf(currentLetter) != -1)
                {
                    str.append(currentLetter);
                }
                else
                {
                    str.append("_");
                }
            }
        }
        return str.toString();
    }
    

    public Boolean guessLetter(Character letter)
    {
        if (this.word.indexOf(Character.toUpperCase(letter)) != -1)
        {
            guessedLetters.add(Character.toUpperCase(letter));
            return true;
        }
        else
        {
            attempts--;
            return false;
        }
    }

    public Boolean isGameWon()
    {
        for (int i = 1; i < word.length(); i++)
        {
            Character letter = word.charAt(i);
            if (guessedLetters.indexOf(letter) == -1)
            {
                return false;
            }
        }
        return true;
    }

    public Boolean isGameLost()
    {
        if (attempts == 0)
        {   
            System.out.println("You lost, try again!");
            return true;
        }
        else
        {
            return false;
        }
    }
}