import java.io.File;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;


public class MovieGuessGame {



    public static void main (String args[]) {

        GameEngine movieGameEngine = new GameEngine();
        movieGameEngine.startNewGame(10);
        //UI on the game

        System.out.println("Guess the movie title, you have 10 chances to guess the correct letters in the title");
        System.out.println("The title to guess has the following letters");
        System.out.println(movieGameEngine.getCurrentRightAnswers());

        // Game logic, if correct letter is guessed, its shown
        // If wrong letter, letter is shown and one point is removed
        // Game ends if you have guessed wrong 10 times or you have guessed all letters right

    }
}
