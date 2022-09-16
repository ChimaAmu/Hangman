package hangman;

import java.util.Random;

public class WordChooser
{
    public static final String[] DICTIONARY = {"MAKERS", "CANDIES", "DEVELOPER", "LONDON"};

    public static void main(String[] args)
    {
        System.out.println();
    }

    public String getRandomWordFromDictionary()
    {   
        Random rnd = new Random();
        String num = DICTIONARY[rnd.nextInt(DICTIONARY.length)];
        return num;
    }
}