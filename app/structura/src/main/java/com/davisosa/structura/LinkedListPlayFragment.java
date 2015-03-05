package com.davisosa.structura;

import android.app.ActionBar;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.net.Uri;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.davisosa.structura.R;
import com.melnykov.fab.FloatingActionButton;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import android.os.Handler;
import android.widget.Toast;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link LinkedListPlayFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link LinkedListPlayFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class LinkedListPlayFragment extends Fragment {

    private OnFragmentInteractionListener mListener;
    FloatingActionButton addNodeBtn;
    FloatingActionButton delNodeBtn;
    FloatingActionButton searchNodeBtn;

    NodeView nv;

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @return A new instance of fragment LinkedListPlayFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static LinkedListPlayFragment newInstance() {
        LinkedListPlayFragment fragment = new LinkedListPlayFragment();
        Bundle args = new Bundle();
        return fragment;
    }

    public LinkedListPlayFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        FrameLayout fl = (FrameLayout) inflater.inflate(R.layout.fragment_linked_list_play, container, false);
        ViewGroup.LayoutParams lp = fl.getLayoutParams();

        nv = new NodeView(getActivity(), getActivity());
        fl.addView(nv, lp.width, lp.height);

        addNodeBtn = (FloatingActionButton) fl.findViewById(R.id.add);
        addNodeBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                nv.addNewNodeToCanvas();
            }
        });

        delNodeBtn = (FloatingActionButton) fl.findViewById(R.id.sub);
        delNodeBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                nv.deleteNode();
            }
        });

        searchNodeBtn = (FloatingActionButton) fl.findViewById(R.id.search);
        searchNodeBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showSearchDialog();
            }
        });

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
                    nv.findNode(Integer.parseInt(value));
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
