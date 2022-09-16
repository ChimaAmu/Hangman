package hangman;

import java.util.Scanner;

public class App
{
    public String getGreeting()
    {
        return "Hello World!";
    }

    public static void main(String[] args)
    {
        WordChooser chooser = new WordChooser();

        Game game = new Game(chooser);
        System.out.println("Word to guess:");

        do
        {
            System.out.println(game.getWordToGuess());

            System.out.println("Guess a letter:");

            Scanner scanner = new Scanner(System.in);
            Character guess = scanner.nextLine().charAt(0);
            Boolean result = game.guessLetter(guess);

            if (result)
            {
                System.out.println("Right!");
                if (game.isGameWon()) {
                    System.out.println("You won! The word was: " + game.getWordToGuess());
                
                    break;
                }
            }
            else
            {
                System.out.println("Wrong...");
            }
        } while (!game.isGameLost());

    }
}