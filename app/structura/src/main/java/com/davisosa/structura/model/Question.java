package com.davisosa.structura.model;

import java.util.List;

/**
 * Created by ishan on 15-03-23.
 */
public class Question {
    public String question;
    public List<Answer> answers;
    public Answer correctAnswer;

    public Question(String question, List<Answer> answers, Answer correctAnswer) {
        this.question      = question;
        this.answers       = answers;
        this.correctAnswer = correctAnswer;
    }
}
