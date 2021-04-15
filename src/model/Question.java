
package model;

public class Question {

    public Question(final String questionText, final boolean answer) {
        this.questionText = questionText;
        this.answer = answer;
    }

    private String questionText;
    private boolean answer;

    public boolean isAnswer() {
        return answer;
    }

    public void setAnswer(final boolean answer) {
        this.answer = answer;
    }

    public String getQuestionText() {
        return questionText;
    }

    public void setQuestionText(final String questionText) {
        this.questionText = questionText;
    }

}
