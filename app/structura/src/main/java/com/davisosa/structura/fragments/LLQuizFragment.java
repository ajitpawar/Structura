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
import com.davisosa.structura.model.Question;

import java.util.ArrayList;

public class LLQuizFragment extends Fragment {

    private ArrayList<Question> qList;
    private QAListAdapter aQaList;


    public static LLQuizFragment newInstance(int quiz) {
        LLQuizFragment fragment = new LLQuizFragment();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        qList   = new ArrayList<>();
        aQaList = new QAListAdapter(getActivity(), qList);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.fragment_quiz, container, false);

        ListView lvQa = (ListView) v.findViewById(R.id.lvQa);
        lvQa.setAdapter(aQaList);

        // get initial question list
        fetchQuestions();

        return v;
    }

    private void fetchQuestions() {
        qList.clear();
        ArrayList<Question> defaultStore = QuestionStore.getDefaultStore();
        for (int i = 0; i < defaultStore.size(); i++) {
            Question currQ = defaultStore.get(i);
            qList.add(currQ);
        }
        aQaList.notifyDataSetChanged();
    }

}