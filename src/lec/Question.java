package lec;

import java.util.Arrays;

public class Question {
    private String questions;
    private String[] choices = new String[4];
    private int answerIndex = 0;

    public Question(String questions, String[] choices, int answerIndex) {
        /**
         * Pre-condition: choices is an array of 4 strings
         */
        this.questions = questions;
        this.choices = choices;
        this.answerIndex = answerIndex;
    }

    @Override
    public String toString() {
        return "Question: " + '\n' + questions + '\n' +
                "Choices:" +'\n' +
                choices[0] + '\n' +
                choices[1] + '\n' +
                choices[2] + '\n' +
                choices[3] + '\n' +
                "Answer:"+ '\n' + choices[answerIndex];
    }
}
