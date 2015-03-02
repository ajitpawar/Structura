package com.davisosa.structura;

import android.app.ActionBar;
import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.davisosa.structura.R;
import com.melnykov.fab.FloatingActionButton;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;


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

        nv = new NodeView(getActivity());
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


        return fl;
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


    public class NodeView extends View {
        int count = 0;
        int defaulttNodeTop = 50;
        int defaultNodeLeft = 120;
        List<LLNode> nodeList = new ArrayList<LLNode>();

        public NodeView(Context context) {
            super(context);
        }

        public void addNewNodeToCanvas() {
            count++;
            LLNode node = createNewNode();
            nodeList.add(node);
            invalidate();
        }

        public LLNode createNewNode() {
            int topOffset = (int) (defaulttNodeTop + (250 * ( Math.floor((double)nodeList.size()/3) )));
            int leftOffset;
            if (nodeList.size() < 3) {
                leftOffset = defaultNodeLeft + (300 * (nodeList.size()));
            } else {
                leftOffset = (int) (defaultNodeLeft + (300 * (nodeList.size() - (3*(Math.floor(nodeList.size()/3))))));
            }
            int value = 1;
            Bitmap bitmap = getNodeBitmap();

            return new LLNode(bitmap, value, leftOffset, topOffset);
        }

        public void deleteNode() {
            if (nodeList.size() == 0) {
                return;
            }
            nodeList.remove(nodeList.size() - 1);
            invalidate();
        }

        public Bitmap getNodeBitmap() {
            View node = getActivity().getLayoutInflater().inflate(R.layout.ll_node, null);

            TextView tvNodeValueDigit = (TextView) node.findViewById(R.id.tvNodeValueDigit);
            Random rand = new Random();
            int rand_num = rand.nextInt((100 - 1) + 1) + 1;
            tvNodeValueDigit.setText(String.valueOf(rand_num));

            node.measure(MeasureSpec.UNSPECIFIED,MeasureSpec.UNSPECIFIED);
            node.layout(0, 0, node.getMeasuredWidth(), node.getMeasuredHeight());

            Bitmap bitmap = Bitmap.createBitmap(node.getMeasuredWidth(), node.getMeasuredHeight(), Bitmap.Config.ARGB_8888);
            Canvas canvas = new Canvas(bitmap);
            node.draw(canvas);

            return bitmap;
        }

        @Override
        protected void onDraw(Canvas canvas) {
            super.onDraw(canvas);
            canvas.save();
            for (int i = 0; i < nodeList.size(); i++) {
                canvas.drawBitmap(nodeList.get(i).bitmap, nodeList.get(i).leftOffset, nodeList.get(i).topOffset, null);
            }
            canvas.restore();
        }
    }

}
