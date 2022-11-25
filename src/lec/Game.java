package lec;

import java.util.ArrayList;

public class Game {
    ArrayList<Question> questions;
    int points;

    /**
     * @param questions: is not null
     * @param points > 0
     */
    public Game( int points) {
        questions = new ArrayList<>();
        this.points = points;
    }

    public void addQuestion(Question question) {
        questions.add(question);
    }

    public ArrayList<Question> getQuestions() {
        return questions;
    }
}
