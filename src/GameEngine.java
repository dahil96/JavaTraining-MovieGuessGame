import java.io.File;
import java.util.Random;
import java.util.Scanner;

public class GameEngine {

    private int guessesLeft = 0;
    private String selectedTitle = "";

    public GameEngine(int nrOfGuesses) {
        guessesLeft = nrOfGuesses;
        selectedTitle = this.getNewTitle();
    }

    private String getNewTitle() {
        return "test";
    }

    public String getMoveTile() {
        return selectedTitle;
    }
/*

    File fileHandle = new File("movies.txt");
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
    }
    */
}
