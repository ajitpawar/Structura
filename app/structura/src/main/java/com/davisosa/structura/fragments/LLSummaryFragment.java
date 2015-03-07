package com.davisosa.structura.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.davisosa.structura.R;

public class LLSummaryFragment extends Fragment {
    public static final String ARG_PAGE = "ARG_PAGE";
    private int mPage;

    public static LLSummaryFragment newInstance(int summary) {
        Bundle args = new Bundle();
        args.putInt(ARG_PAGE, summary);
        LLSummaryFragment fragment = new LLSummaryFragment();
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
        View view = inflater.inflate(R.layout.fragment_ll_summary, container, false);
        TextView textView = (TextView) view.findViewById(R.id.summary);
        textView.setText(Html.fromHtml(getString(R.string.ll_summary_body)));
        return view;
    }
}