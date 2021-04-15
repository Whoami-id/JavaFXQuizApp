
package application;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.util.Duration;
import model.Question;
import model.QuestionBank;

public class Controller {

    private final QuestionBank questionBank = new QuestionBank();
    private final Question[] allQuestion = questionBank.getQuestions();

    private boolean pickeAnswer = false;
    private int questionNumber;
    private int score = 0;

    public void initialize() {
        final Question firstQuestion = allQuestion[0];
        questionLabel.setText(firstQuestion.getQuestionText());

        progressbarHBox.getChildren().add(new Rectangle(40, 20, Color.BLUE));

    }

    @FXML
    private Label questionLabel;

    @FXML
    private Button trueButton;

    @FXML
    private Button falseButton;

    @FXML
    private Label questionCountLabel;

    @FXML
    private Label scoreLabel;

    @FXML
    private HBox progressbarHBox;

    @FXML
    void buttonTapped(final ActionEvent event) {
        final Button tappButton = (Button) event.getSource();
        if (tappButton.getId().equals("trueButton")) {
            pickeAnswer = true;
        } else if (tappButton.getId().equals("falseButton")) {
            pickeAnswer = false;
        }
        checkAnswer();
        questionNumber += 1;
        nextQuestion();
    }

    private void checkAnswer() {
        final boolean correctAnswer = allQuestion[questionNumber].isAnswer();
        if (correctAnswer == pickeAnswer) {
            score += 20;
            createAlertBox("Richtig");
        } else {
            createAlertBox("Flase");
        }
    }

    private void nextQuestion() {
        if (questionNumber <= 9) {
            questionLabel.setText(allQuestion[questionNumber].getQuestionText());
            updateUI();
        } else {
            restart();
        }
    }

    public void updateUI() {
        scoreLabel.setText("Score: " + score);
        questionCountLabel.setText("" + (questionNumber + 1) + "/10");

        final double progressBarWidth = progressbarHBox.getWidth() / 10;
        progressbarHBox.getChildren().add(new Rectangle(progressBarWidth, 20, Color.BLUE));

    }

    private void restart() {
        final Alert alert = new Alert(AlertType.INFORMATION);
        alert.setTitle("Glückwunsch");
        alert.setHeaderText("Glückwunsch zum beneden des Quiz");
        alert.setContentText("Neuestart");
        alert.showAndWait();

        questionNumber = 0;
        score = 0;
        nextQuestion();
        progressbarHBox.getChildren().clear();
    }

    private void createAlertBox(final String text) {
        final Alert alert = new Alert(AlertType.INFORMATION);
        alert.setContentText(text);
        alert.show();

        final Timeline timeLine = new Timeline(new KeyFrame(Duration.seconds(2), event -> alert.close()));
        timeLine.setCycleCount(1);
        timeLine.play();
    }

}