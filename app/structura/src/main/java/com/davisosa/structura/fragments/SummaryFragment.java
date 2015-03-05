package com.davisosa.structura.fragments;

/**
 * Created by DhyeySejpal on 05/03/2015.
 */
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.Html;
import android.text.Spanned;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.davisosa.structura.R;

/**
 * Created by vaishali on 2015-03-05.
 */
public class SummaryFragment extends Fragment {
    public static final String ARG_PAGE = "ARG_PAGE";
    private int mPage;

    public static SummaryFragment newInstance(int summary) {
        Bundle args = new Bundle();
        args.putInt(ARG_PAGE, summary);
        SummaryFragment fragment = new SummaryFragment();
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
        View view = inflater.inflate(R.layout.fragment_summary, container, false);
        TextView textView = (TextView) view.findViewById(R.id.llsummary);
        String formattedText = getString(R.string.llsummarytext);
        Spanned result = Html.fromHtml(formattedText);
        textView.setText(result); // default text for each fragment
        return view;
    }
}