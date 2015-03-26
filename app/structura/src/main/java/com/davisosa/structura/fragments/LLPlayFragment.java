package com.davisosa.structura.fragments;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.res.Resources;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.LinearLayout;

import com.davisosa.structura.R;
import com.davisosa.structura.view.EdgeView;
import com.davisosa.structura.view.NodeView;

import java.util.LinkedList;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link LLPlayFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link LLPlayFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class LLPlayFragment extends Fragment {

    Button addNodeBtn;
    Button delNodeBtn;
    Button searchNodeBtn;
    private OnFragmentInteractionListener mListener;


    LinkedList ll = new LinkedList();
    private int ctr = 0;

    public LLPlayFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @return A new instance of fragment LLPlayFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static LLPlayFragment newInstance() {
        LLPlayFragment fragment = new LLPlayFragment();
        Bundle args = new Bundle();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        FrameLayout fl = (FrameLayout) inflater.inflate(R.layout.fragment_ll_play, container, false);

        final LinearLayout nodeLayout = (LinearLayout)fl.findViewById(R.id.node_layout);


        addNodeBtn = (Button) fl.findViewById(R.id.btn_insert);
        addNodeBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (nodeLayout.getChildCount() >= 1)
                {
                    EdgeView ev = new EdgeView(getActivity());
                    nodeLayout.addView(ev,5,100);
                }
                NodeView nv = new NodeView(getActivity());
                nv.setId(++ctr);
                Resources res = getResources();
                LinearLayout.LayoutParams lp = new LinearLayout.LayoutParams(res.getDimensionPixelSize(R.dimen.node_width),res.getDimensionPixelSize(R.dimen.node_height));
                nodeLayout.addView(nv,lp);
            }
        });

       /* delNodeBtn = (Button) fl.findViewById(R.id.btn_delete);
        delNodeBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                nv.deleteNode();
            }
        });

        searchNodeBtn = (Button) fl.findViewById(R.id.btn_search);
        searchNodeBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showSearchDialog();
            }
        });
*/

        return fl;
    }

    private void showSearchDialog() {
        AlertDialog.Builder alert = new AlertDialog.Builder(getActivity());

        alert.setTitle("Find a Node");
        alert.setMessage("Enter the value of the node you'd like to find");

        final EditText input = new EditText(getActivity());
        alert.setView(input);

        alert.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int whichButton) {
                String value = input.getText().toString();
                try {
/*
                    nv.findNode(Integer.parseInt(value));
*/
                } catch (Exception e) {
                    // show toast
                }
            }
        });

        alert.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int whichButton) {
                // Canceled.
            }
        });

        alert.show();
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p/>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnFragmentInteractionListener {
        public void onFragmentInteraction(Uri uri);
    }

}
