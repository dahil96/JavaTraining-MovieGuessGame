import java.io.File;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;


public class MovieGuessGame {



    public static void main (String args[]) {

        GameEngine movieGameEngine = new GameEngine(10);
        //Open and parse file into dataset
        /* File fileHandle = new File("movies.txt");
       String[] movieNames = null;
        int rowsInDataset = 0;
        try {
            //If file exist open it
            if (fileHandle.exists()) {
                Scanner fileReaderCountRows = new Scanner(fileHandle);
                //Find out number of rows in dataset do define correct size of array

                while (fileReaderCountRows.hasNextLine()) {
                    fileReaderCountRows.nextLine();
                    rowsInDataset++;
                }
                //Create the dataset
                movieNames = new String[rowsInDataset];
                //Run the file scanner to read content
                Scanner fileReaderReadContent = new Scanner(fileHandle);
                int index = 0;
                while (fileReaderReadContent.hasNextLine()) {
                    movieNames[index] = fileReaderReadContent.nextLine();
                    index++;
                }
            } else {
                System.out.println("File does not exist");
            }
        } catch (Exception e) {
            System.out.println("Something went wrong during file operations the file" + e.toString());
        }

        //Select a random movie title
        Random randomGenerator = new Random();
        int randomIndex = randomGenerator.nextInt(rowsInDataset-1);
        String selectedTitle = movieNames[randomIndex];
        //hold current letters from wrong guesses
        String wrongGuesses = "";
        //Hold representation of current right guesses
        char[] currentGuess = new char[selectedTitle.length()];
        for (int i = 0; i < selectedTitle.length(); i++) {
            currentGuess[i] = '_';
        }*/

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
