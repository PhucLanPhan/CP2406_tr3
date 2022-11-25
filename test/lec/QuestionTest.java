package lec;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class QuestionTest {

    @Test
    void testToString() {
        String question = "Web pages are made using HTML - what does this stand for?";
        String[] choices = {"HyperText Markup Language",
                            "Hyper Tough Makeup Language",
                            "HyperText Madeup Language",
                            "Hard To Makeout Language"};
        int answerIndex = 0;

        Question myQues = new Question(question, choices, 0);
        System.out.println(myQues);
    }
}