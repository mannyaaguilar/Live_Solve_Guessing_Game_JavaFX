package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;

import java.awt.*;
import java.util.Random;

public class Controller {

    @FXML
    private TextField userEntry;

    @FXML
    private Button submitButton;

    @FXML
    private Button resetButton;

    @FXML
    private Text feedback;

    Random diceRoll = new Random();
    int generateNumber = diceRoll.nextInt(10000) + 1;

    int numofGuesses = 0;

    public void playerGuess(ActionEvent actionEvent){
        String playerGuessString = userEntry.getText();
        int playerGuess = Integer.parseInt(playerGuessString);

        numofGuesses++;

        if (playerGuess > generateNumber){
            feedback.setText("Too High");
        }
        else if (playerGuess < generateNumber){
            feedback.setText("Too low");
        }
        else if (playerGuess == generateNumber){
            feedback.setText("You are correct!");
        }
    }
    public void resetGame(ActionEvent actionEvent){
        int generateNumber = diceRoll.nextInt(10000) + 1;

        int numofGuesses = 0;
        feedback.setText("Game restarted!");
        userEntry.clear();
    }
}
