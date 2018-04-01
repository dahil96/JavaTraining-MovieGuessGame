import java.io.File;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class GameEngine {

    private int nrOfGuessesLeft;
    private String selectedTitle;
    private String[] movieNames;
    private String[] currentRightAnswers;
    private String currentWrongGuesses;
    private boolean isGameLive;
    private boolean playerWon;

    public GameEngine() {
        nrOfGuessesLeft = 0;
        movieNames = loadAvailableTitles();
        selectedTitle = this.getNewTitle();
        currentRightAnswers = null;
        currentWrongGuesses = "";
        isGameLive = true;
        playerWon = false;
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
        String[] answerString = new String[selectedTitle.length()];
        for (int i = 0; i < answerString.length; i++) {
            if( Character.isWhitespace(selectedTitle.charAt((i)))){
                answerString[i] = "_";
            } else {
                answerString[i] = "-";
            }
        }
        return answerString;
    }
    private void updateCurrentRightAnswers(String guess) {
        for (int i = 0; i < selectedTitle.length();i++) {
            if (selectedTitle.charAt(i) == guess.charAt(0)){
                currentRightAnswers[i] = guess;
            }
        }
    }
    private String getNewTitle() {
        //Select a random movie title
        Random randomGenerator = new Random();
        int randomIndex = randomGenerator.nextInt(movieNames.length - 1);
        return movieNames[randomIndex];
    }

    private void assesGameStatus() {
        System.out.println("Assessing game state");
        if(nrOfGuessesLeft == 0) {
            isGameLive = false;
            playerWon = false;
        } else if (!Arrays.asList(currentRightAnswers).contains("-")) {
            isGameLive = false;
            playerWon = true;
        }
    }

    public void startNewGame(int nrOfGuesses) {
        //Setup new game
        nrOfGuessesLeft = nrOfGuesses;
        currentWrongGuesses = "";
        currentRightAnswers = buildNewAnswerString();
        System.out.println("Selected movie title is: " + selectedTitle);
    }

    public boolean makeGuess(String guess) {
        boolean wasGuessCorrect = false;
        if (nrOfGuessesLeft > 0) {
            if(selectedTitle.contains(guess)) {
                updateCurrentRightAnswers(guess);
                wasGuessCorrect = true;
            } else {
                nrOfGuessesLeft--;
                currentWrongGuesses = currentWrongGuesses + guess + ",";
                wasGuessCorrect = false;
            }
        }
        assesGameStatus();
        return wasGuessCorrect;
    }
    public int getNoOfGuessesLeft() {
        return nrOfGuessesLeft;
    }

    public boolean isGameStillLive() {
        return isGameLive;
    }

    public String getCurrentRightAnswers () {
        return String.join(" ",currentRightAnswers);
    }

    public String getCurrentWrongGuesses(){
        return currentWrongGuesses;
    }

    public boolean didPlayerWin() {
        return playerWon;
    }

    public String getMovieTitle() {
        if (isGameLive) {
            return "Error, game is still running";
        } else {
            return selectedTitle;
        }
    }
}
