package com.davisosa.structura.adapters;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.davisosa.structura.R;
import com.davisosa.structura.Structura;
import com.davisosa.structura.model.Answer;
import com.davisosa.structura.model.Question;
import com.davisosa.structura.view.StructuraRadioButton;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by ishan on 15-03-23.
 */
public class QAListAdapter extends ArrayAdapter<Question> {

    private AdapterCallback mAdapterCallback;
    private Map<Question, Answer> selectedAnswers;

    public boolean didSubmit = false;

    public QAListAdapter(Context context, ArrayList<Question> objects, AdapterCallback mAdapterCallback) {
        super(context, android.R.layout.simple_list_item_1, objects);
        this.mAdapterCallback = mAdapterCallback;
        this.selectedAnswers = new HashMap<Question, Answer>();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        final Question currentQ = getItem(position);

        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.item_qa, parent, false);
        }

        TextView tvQuestionNumber = (TextView) convertView.findViewById(R.id.tvQuestionNumber);
        tvQuestionNumber.setText(String.format("QUESTION %d", position+1));

        TextView tvQuestion = (TextView) convertView.findViewById(R.id.tvQuestion);
        tvQuestion.setText(currentQ.question);

        RadioGroup rgAnswers = (RadioGroup) convertView.findViewById(R.id.rgAnswers);
        // TODO: removing to help with cell reuse. Probably a better way exists;
        rgAnswers.removeAllViews();

        for (int i = 0; i < currentQ.answers.size(); i++) {
            Answer currentAnswer = currentQ.answers.get(i);
            RadioButton rbAnswer = new StructuraRadioButton(getContext(), currentAnswer);
            rbAnswer.setText(currentAnswer.answer);
            rbAnswer.setLayoutParams(new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT));
            if (currentAnswer == currentQ.correctAnswer && didSubmit) {
                Resources res = rbAnswer.getResources();
                rbAnswer.setBackgroundColor(res.getColor(R.color.correct_highlight));

            }
            rgAnswers.addView(rbAnswer, i);
        }

        int childCount = rgAnswers.getChildCount();
        for (int i=0; i < childCount; i++) {
            View view = rgAnswers.getChildAt(i);
            if (view instanceof StructuraRadioButton) {
                StructuraRadioButton srb = (StructuraRadioButton) view;
                if (srb.getAnswer() == selectedAnswers.get(currentQ)) {
                    srb.setChecked(true);
                    break;
                }
            }
        }

        rgAnswers.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                StructuraRadioButton checkedRadioButton = (StructuraRadioButton) group.findViewById(checkedId);
                if (checkedRadioButton != null) {
                    mAdapterCallback.onRadioButtonPressed(currentQ, checkedRadioButton.getAnswer());
                    selectedAnswers.put(currentQ, checkedRadioButton.getAnswer());
                }
            }
        });

        return convertView;
    }

    public static interface AdapterCallback {
        void onRadioButtonPressed(Question question, Answer selectedAnswer);
    }
}
