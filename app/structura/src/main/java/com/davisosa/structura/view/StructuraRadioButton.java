package com.davisosa.structura.view;

import android.content.Context;
import android.widget.RadioButton;

import com.davisosa.structura.model.Answer;

/**
 * Created by ishan on 15-03-23.
 */
public class StructuraRadioButton extends RadioButton {

    Answer answer;

    public StructuraRadioButton(Context context, Answer answer) {
        super(context);
        this.answer = answer;
    }

    public Answer getAnswer() {
        return answer;
    }
}
