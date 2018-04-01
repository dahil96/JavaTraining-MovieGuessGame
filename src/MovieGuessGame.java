
import java.util.Scanner;


public class MovieGuessGame {



    public static void main (String args[]) {

        GameEngine movieGameEngine = new GameEngine();
        movieGameEngine.startNewGame(10);
        //UI on the game

        System.out.println("Guess the movie title, you have 10 chances to guess the correct letters in the title");
        System.out.println("The title to guess has the following letters");
        System.out.println(movieGameEngine.getCurrentRightAnswers());

        boolean lastGuess;
        Scanner input = new Scanner(System.in);
        String guess = "";
        do {
            System.out.println("--------------------------------");
            System.out.println("Make your guess! Choose a letter");
            guess = input.nextLine();
            lastGuess = movieGameEngine.makeGuess(guess);
            System.out.printf("The guess was %s%n", lastGuess);
            System.out.println("Current score is: ");
            System.out.println("Number of guesses left " + movieGameEngine.getNoOfGuessesLeft());
            System.out.println("The current guesses are " + movieGameEngine.getCurrentRightAnswers());
            System.out.println("Current wrong letters guessed " + movieGameEngine.getCurrentWrongGuesses());
        }
        while (movieGameEngine.isGameStillLive());
        input.close();
        System.out.println("The game ended:");
        if (movieGameEngine.didPlayerWin()) {
            System.out.println("Great Job the title was " + movieGameEngine.getMovieTitle());
            System.out.println("You guessed it with " + movieGameEngine.getNoOfGuessesLeft() + " guesses left");
        } else {
            System.out.println("Sorry you did not guess the title, the title was " + movieGameEngine.getMovieTitle());
        }
        // Game logic, if correct letter is guessed, its shown
        // If wrong letter, letter is shown and one point is removed
        // Game ends if you have guessed wrong 10 times or you have guessed all letters right

    }
}
