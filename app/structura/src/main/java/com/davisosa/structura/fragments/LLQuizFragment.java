package com.davisosa.structura.fragments;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.*;
import com.davisosa.structura.R;

public class LLQuizFragment extends Fragment {

    public static final String ARG_PAGE = "ARG_PAGE";
    private int mPage;

    private Button btnSubmitQuiz;
    private int score = 0;
    private int qCount = 3;


    public static LLQuizFragment newInstance(int quiz) {
        Bundle args = new Bundle();
        args.putInt(ARG_PAGE, quiz);
        LLQuizFragment fragment = new LLQuizFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mPage = getArguments().getInt(ARG_PAGE);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // Inflate the layout
        FrameLayout fl = (FrameLayout) inflater.inflate(R.layout.fragment_quiz, container, false);

        // Attach listeners to all buttons
        attachListeners(fl, qCount);       // DO NOT forget to change qCount
                                           // when you add new questions

        // Submit Button
        btnSubmitQuiz = (Button) fl.findViewById(R.id.submit);
        btnSubmitQuiz.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                showScore(score);    // display score to user
            }
        });

        return fl;
    }


    // Attach listeners to all radio buttons
    private void attachListeners(FrameLayout fl, int count){

        // index starts at 1, not 0
        for(int i=1; i<=count; i++){
            int qid = getResources().getIdentifier("q"+i, "id", fl.getContext().getPackageName());
            RadioGroup rg =(RadioGroup) fl.findViewById(qid);
            rg.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
                public void onCheckedChanged(RadioGroup group, int checkedId) {
                    checkAnswer(group, checkedId);
                }
            });
        }
    }

    // Tally the score
    private void checkAnswer(RadioGroup group, int checkedId){

        RadioButton btn = (RadioButton) group.findViewById(checkedId);
        int index = group.indexOfChild(btn) + 1;
        String answer = btn.getTag().toString();

        if(answer.equals(Integer.toString(index))){
            score++;
        }
    }

    // Display the score as an alert
    private void showScore(int score){
        AlertDialog.Builder alert = new AlertDialog.Builder(getActivity());

        alert.setTitle("Your Score");
        alert.setMessage("Your score is: " + score + " out of " + qCount);

        alert.setNegativeButton("OK", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int whichButton) {
                // OK. Do nothing.
            }
        });

        alert.show();
    }

}