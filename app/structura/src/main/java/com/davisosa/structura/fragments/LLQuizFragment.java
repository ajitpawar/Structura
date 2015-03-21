package com.davisosa.structura.fragments;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.RadioGroup;
import com.davisosa.structura.R;


public class LLQuizFragment extends Fragment {
    public static final String ARG_PAGE = "ARG_PAGE";
    private int mPage;

    private Button btnSubmitQuiz;
    int score,ans1,ans2, ans3;
    int qCount = 5;


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

        // Inflate the layout for this fragment
        FrameLayout fl = (FrameLayout) inflater.inflate(R.layout.fragment_quiz, container, false);
        ViewGroup.LayoutParams lp = fl.getLayoutParams();

        RadioGroup champ=(RadioGroup) fl.findViewById(R.id.answer1);
        champ.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                // TODO Auto-generated method stub
                switch(checkedId) {
                    case R.id.answer1A:
                        ans1 =1;
                        break;
                    case R.id.answer1B:
                        ans1 =2;
                        break;
                    case R.id.answer1C:
                        ans1 =3;
                        break;
                }
            }
        });

        RadioGroup gBall=(RadioGroup) fl.findViewById(R.id.answer2);
        gBall.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                // TODO Auto-generated method stub
                switch(checkedId) {
                    case R.id.answer2A:
                        ans2 = 1;
                        break;
                    case R.id.answer2B:
                        ans2 = 2;
                        break;
                    case R.id.answer2C:
                        ans2 = 3;
                        break;
                }
            }
        });

        RadioGroup gBoot = (RadioGroup) fl.findViewById(R.id.answer3);
        gBoot.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                // TODO Auto-generated method stub
                switch(checkedId) {
                    case R.id.answer3A:
                        ans3 = 1;
                        break;
                    case R.id.answer3B:
                        ans3 = 2;
                        break;
                    case R.id.answer3C:
                        ans3 =3;
                        break;
                }
            }
        });

        btnSubmitQuiz = (Button) fl.findViewById(R.id.submit);
        btnSubmitQuiz.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                score =0;
                // TODO Auto-generated method stub
                if(ans1 == 2)
                    score++;
                if(ans2 == 3)
                    score++;
                if(ans3 == 1)
                    score++;
                //Toast.makeText(QuizActivity.this, "Your score is:" + score + " out of 3", Toast.LENGTH_LONG).show();
                showScore(score);
            }
        });

        return fl;
    }

    private void showScore(int score){
        AlertDialog.Builder alert = new AlertDialog.Builder(getActivity());

        alert.setTitle("Your Score");
        alert.setMessage("Your score is: " + score + " out of " + qCount);

        alert.setNegativeButton("OK", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int whichButton) {
                // Canceled.
            }
        });

        alert.show();
    }
    
}