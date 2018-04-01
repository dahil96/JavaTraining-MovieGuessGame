import java.io.File;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;


public class MovieGuessGame {



    public static void main (String args[]) {

        GameEngine movieGameEngine = new GameEngine();


        System.out.println("Selected title is " + movieGameEngine.getMoveTile() );
        //UI on the game

       /* System.out.println("Guess the movie title, you have 10 chances to guess the correct letters in the title");
        System.out.println("The current title is ");
        System.out.println(Arrays.toString(currentGuess));

        // Game logic, if correct letter is guessed, its shown
        // If wrong letter, letter is shown and one point is removed
        // Game ends if you have guessed wrong 10 times or you have guessed all letters right


        System.out.println("Rows in data set is" + rowsInDataset);
        System.out.println("Last movie title is" + movieNames[rowsInDataset - 1]);*/
    }
}
