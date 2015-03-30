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
import com.davisosa.structura.adapters.QAListAdapter;
import com.davisosa.structura.dataStores.QuestionStore;
import com.davisosa.structura.model.Answer;
import com.davisosa.structura.model.Question;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class LLQuizFragment extends Fragment implements QAListAdapter.AdapterCallback {

    private ArrayList<Question> qList;
    private QAListAdapter aQaList;

    private Map<Question, Answer> selectedAnswers;

    private Button btnSubmit;

    public static LLQuizFragment newInstance(int quiz) {
        LLQuizFragment fragment = new LLQuizFragment();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        qList   = new ArrayList<>();
        aQaList = new QAListAdapter(getActivity(), qList, this);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.fragment_quiz, container, false);

        ListView lvQa = (ListView) v.findViewById(R.id.lvQa);
        lvQa.setAdapter(aQaList);

        // get footer
        View footerView = inflater.inflate(R.layout.footer_qa_list, null, false);
        lvQa.addFooterView(footerView);

        btnSubmit = (Button) footerView.findViewById(R.id.btnSubmit);
        // disable until, all questions have been answered
        btnSubmit.setEnabled(false);
        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkAnswers();
            }
        });

        // get initial question list
        fetchQuestions();

        System.out.println(lvQa.getAdapter().getItemViewType(0));

        return v;
    }

    private void checkAnswers() {
        int score = 0;
        for (Map.Entry<Question, Answer> entry : selectedAnswers.entrySet()) {
            Question question = entry.getKey();
            Answer answer = entry.getValue();
            if (question.correctAnswer == answer) { score ++; }
        }
        // show dialog
        new AlertDialog.Builder(getActivity())
                .setTitle("Quiz Score")
                .setMessage(String.format("You scored %d out of %d", score, qList.size()))
                .setPositiveButton("Okay", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        aQaList.didSubmit = true;
                        aQaList.notifyDataSetChanged();
                        dialog.cancel();
                    }
                })
                .show();
    }

    private void fetchQuestions() {
        qList.clear();
        ArrayList<Question> defaultStore = QuestionStore.getDefaultLLStore();
        for (int i = 0; i < defaultStore.size(); i++) {
            Question currQ = defaultStore.get(i);
            qList.add(currQ);
        }
        aQaList.notifyDataSetChanged();
    }

    @Override
    public void onRadioButtonPressed(Question question, Answer selectedAnswer) {
        if (selectedAnswers == null) {
            selectedAnswers = new HashMap<Question, Answer>();
        }
        selectedAnswers.put(question, selectedAnswer);
        if (selectedAnswers.size() == qList.size()) {
            btnSubmit.setEnabled(true);
        }
    }
}