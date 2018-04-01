import java.io.File;
import java.util.Random;
import java.util.Scanner;

public class GameEngine {

    private int guessesLeft;
    private String selectedTitle;
    private String[] movieNames;
    private String[] currentRightAnswers;
    private String currentWrongGuesses;

    public GameEngine() {
        guessesLeft = 0;
        movieNames = loadAvailableTitles();
        selectedTitle = this.getNewTitle();
        currentRightAnswers = null;
        currentWrongGuesses = "";
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
    private String[] buildNewAnswerString() {
        String[] answerString = new String[selectedTitle.length()-1];
        for (int i = 0; i < answerString.length; i++) {
            if( Character.isWhitespace(selectedTitle.charAt((i)))){
                answerString[i] = "_";
            } else {
                answerString[i] = "-";
            }
        }
        return answerString;
    }
    private String getNewTitle() {
        //Select a random movie title
        Random randomGenerator = new Random();
        int randomIndex = randomGenerator.nextInt(movieNames.length - 1);
        return movieNames[randomIndex];
    }

    public void startNewGame(int nrOfGuesses) {
        //Setup new game
        guessesLeft = nrOfGuesses;
        currentWrongGuesses = "";
        currentRightAnswers = buildNewAnswerString();
        System.out.println("Selected movie title is: " + selectedTitle);
    }

    public int makeGuess(String guess) {
        if (guessesLeft > 0) {
            if(selectedTitle.contains(guess)) {
                System.out.println("contains");
            }
            guessesLeft--;
        }
        return guessesLeft;
    }
    public int noOfGuessesLeft() {
        return guessesLeft;
    }

    public String getCurrentRightAnswers () {
        return String.join(" ",currentRightAnswers);
    }
}
