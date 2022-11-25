package lec;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GameTest {

    @Test
    void addQuestion() {
        Game game = new Game(10);
        String question = "Web pages are made using HTML - what does this stand for?";
        String[] choices = {"HyperText Markup Language",
                "Hyper Tough Makeup Language",
                "HyperText Madeup Language",
                "Hard To Makeout Language"};
        int answerIndex = 0;
        Question myQues = new Question(question, choices, 0);
        game.addQuestion(myQues);

        String question2 = "How old is Harry";
        String[] choices2 = {"20", "18", "19", "21"};
        int answerIndex2 = 0;
        Question myQues2 = new Question(question2, choices2, 0);
        game.addQuestion(myQues2);

        for(int i=0; i<0; i++){
            System.out.println(i);
        }
    }
}