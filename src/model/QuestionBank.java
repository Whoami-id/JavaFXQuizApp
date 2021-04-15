
package model;

public class QuestionBank {

    private Question[] questions;

    public QuestionBank() {
        final Question question1 = new Question("Ist die Erde rund?", true);
        final Question question2 = new Question("In Deutschland gibt es 20 Bundesländer", false);
        final Question question3 = new Question("Ist Frauen in Arizona gesetzlich verboten Hosen zu tragen?", true);
        final Question question4 = new Question("Der größter Mann der Welt ist 2,47m", true);
        final Question question5 = new Question("Der Blauwal ist das größte Tier aller Zeiten", true);
        final Question question6 = new Question("Fische sind Säugetieren", false);
        final Question question7 = new Question("Können Elefanten schwimmen", true);
        final Question question8 = new Question("Ein Elefant kann fliegen", false);
        final Question question9 = new Question("Albert Einstein wurde 80 Jahre alt", false);
        final Question question10 = new Question("Die Welt besteht aus 8 Kontinenten", false);
        questions = new Question[] { question1, question2, question3, question4, question5, question6, question7,
                question8, question9, question10 };
    }

    public Question[] getQuestions() {
        return questions;
    }

    public void setQuestion(final Question[] questions) {
        this.questions = questions;
    }

}
