package com.davisosa.structura.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;
import com.davisosa.structura.R;


public class LLQuizFragment extends Fragment {
    public static final String ARG_PAGE = "ARG_PAGE";
    private int mPage;

    private Button btnSubmitQuiz;
    int score,ans1,ans2, ans3;

/*
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mPage = getArguments().getInt(ARG_PAGE);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_page, container, false);
        TextView textView = (TextView) view;
        textView.setText("Fragment #55" + mPage); // default text for each fragment
        return view;
    }

*/

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


        return fl;
    }

 /*
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);
        RadioGroup champ=(RadioGroup)findViewById(R.id.answer1);
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
        RadioGroup gBall=(RadioGroup)findViewById(R.id.answer2);
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
        RadioGroup gBoot = (RadioGroup)findViewById(R.id.answer3);
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
        btnSubmitQuiz = (Button) findViewById(R.id.submit);
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
                Toast.makeText(QuizActivity.this, "Your score is:" + score + " out of 3", Toast.LENGTH_LONG).show();
            }
        });
    }
  */

}