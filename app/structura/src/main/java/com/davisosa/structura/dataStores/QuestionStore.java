package com.davisosa.structura.dataStores;

import com.davisosa.structura.model.Answer;
import com.davisosa.structura.model.Question;

import java.util.ArrayList;

/**
 * Created by ishan on 15-03-23.
 */
public class QuestionStore {

    private static ArrayList<Question> defaultStore;

    public static ArrayList<Question> getDefaultStore() {
        if (QuestionStore.defaultStore == null) {
            setDefaultStore();
        }
        return defaultStore;
    }

    private static void setDefaultStore() {

        // TODO: possibly create a xml/json file and read the data from there

        // q1
        String one_question = "1. Some text here. More text maybe. Some more here as well.";
        String one_answer_string_1  = "One Answer";
        String one_answer_string_2  = "Two Answer";
        String one_answer_string_3  = "Three Answer";

        Answer one_answer_1 = new Answer(one_answer_string_1);
        Answer one_answer_2 = new Answer(one_answer_string_2);
        Answer one_answer_3 = new Answer(one_answer_string_3);

        ArrayList<Answer> one_answers = new ArrayList<Answer>();
        one_answers.add(one_answer_1);
        one_answers.add(one_answer_2);
        one_answers.add(one_answer_3);

        Answer one_correct_answer = one_answer_2;

        Question q1 = new Question(one_question, one_answers, one_correct_answer);

        // q2
        String two_question = "2. Some text here. More text maybe. Some more here as well.";
        String two_answer_string_1  = "One Answer";
        String two_answer_string_2  = "Two Answer";
        String two_answer_string_3  = "Three Answer";

        Answer two_answer_1 = new Answer(two_answer_string_1);
        Answer two_answer_2 = new Answer(two_answer_string_2);
        Answer two_answer_3 = new Answer(two_answer_string_3);

        ArrayList<Answer> two_answers = new ArrayList<Answer>();
        two_answers.add(two_answer_1);
        two_answers.add(two_answer_2);
        two_answers.add(two_answer_3);

        Answer two_correct_answer = two_answer_2;

        Question q2 = new Question(two_question, two_answers, two_correct_answer);

        // q3
        String three_question = "3. Some text here. More text maybe. Some more here as well.";
        String three_answer_string_1  = "One Answer";
        String three_answer_string_2  = "Two Answer";
        String three_answer_string_3  = "Three Answer";

        Answer three_answer_1 = new Answer(three_answer_string_1);
        Answer three_answer_2 = new Answer(three_answer_string_2);
        Answer three_answer_3 = new Answer(three_answer_string_3);

        ArrayList<Answer> three_answers = new ArrayList<Answer>();
        three_answers.add(three_answer_1);
        three_answers.add(three_answer_2);
        three_answers.add(three_answer_3);

        Answer three_correct_answer = three_answer_2;

        Question q3 = new Question(three_question, three_answers, three_correct_answer);

        // set up default list
        ArrayList<Question> qaList = new ArrayList<>();
        qaList.add(q1);
        qaList.add(q2);
        qaList.add(q3);

        QuestionStore.defaultStore = qaList;
    }
}
