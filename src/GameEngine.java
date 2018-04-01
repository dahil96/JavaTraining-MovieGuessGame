import java.io.File;
import java.util.Random;
import java.util.Scanner;

public class GameEngine {

    private int guessesLeft;
    private String selectedTitle;
    private String[] movieNames;

    public GameEngine() {
        guessesLeft = 0;
        movieNames = loadAvailableTitles();
        selectedTitle = this.getNewTitle();
    }
    private String[] loadAvailableTitles(){
        File fileHandle = new File("movies.txt");
        int rowsInDataset = 0;
        String[] loadedMovieNames = null;
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
                loadedMovieNames = new String[rowsInDataset];
                //Run the file scanner to read content
                Scanner fileReaderReadContent = new Scanner(fileHandle);
                int index = 0;
                while (fileReaderReadContent.hasNextLine()) {
                    loadedMovieNames[index] = fileReaderReadContent.nextLine();
                    index++;
                }
            } else {
                System.out.println("File does not exist");
            }
        } catch (Exception e) {
            System.out.println("Something went wrong during file operations the file" + e.toString());
        }
        return loadedMovieNames;
    }
    private String getNewTitle() {
        //Select a random movie title
        Random randomGenerator = new Random();
        int randomIndex = randomGenerator.nextInt(movieNames.length - 1);
        return movieNames[randomIndex];
    }

    public boolean startNewGame() {
        return true;
    }
    /*
        //hold current letters from wrong guesses
        String wrongGuesses = "";

        //Hold representation of current right guesses
        char[] currentGuess = new char[selectedTitle.length()];
        for (int i = 0; i < selectedTitle.length(); i++) {
            currentGuess[i] = '_';
        }*/

    public String getMoveTile() {
        return selectedTitle;
    }
}
