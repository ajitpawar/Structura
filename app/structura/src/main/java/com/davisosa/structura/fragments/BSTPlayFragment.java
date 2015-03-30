package com.davisosa.structura.fragments;

import android.content.res.Resources;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.Fragment;
import android.util.Pair;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.LinearLayout;

import com.afollestad.materialdialogs.MaterialDialog;
import com.davisosa.structura.R;
import com.davisosa.structura.model.BST;
import com.davisosa.structura.view.EdgeView;
import com.davisosa.structura.view.NodeView;
import com.nispok.snackbar.Snackbar;
import com.nispok.snackbar.SnackbarManager;

import java.util.concurrent.atomic.AtomicInteger;

import timber.log.Timber;

/**
 * A simple {@link android.support.v4.app.Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link com.davisosa.structura.fragments.BSTPlayFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link com.davisosa.structura.fragments.BSTPlayFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class BSTPlayFragment extends Fragment {
    private LinearLayout mNodeLayout;

    private Button mInsBtn;
    private Button mDelBtn;
    private Button mSearchBtn;

    private BST mNodes = new BST();
    private Handler mHandler = new Handler();
    private Sequencer mSequencer = new Sequencer();

    private OnFragmentInteractionListener mListener;

    public BSTPlayFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @return A new instance of fragment LLPlayFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static BSTPlayFragment newInstance() {
        BSTPlayFragment fragment = new BSTPlayFragment();
        Bundle args = new Bundle();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, final ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        FrameLayout root = (FrameLayout) inflater.inflate(R.layout.fragment_bst_play,
                container, false);
        mNodeLayout = (LinearLayout) root.findViewById(R.id.node_layout);
        final Resources res = getResources();

        mInsBtn = (Button) root.findViewById(R.id.btn_insert);
        mInsBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                NodeView nodeView = new NodeView(getActivity());
                int nid = mSequencer.next();
                nodeView.setId(nid);

                EdgeView edgeView = null;

                if (mNodeLayout.getChildCount() > 0)
                {
                    resetNodeColors();
                    edgeView = new EdgeView(getActivity());
                    mNodes.insert(Pair.create(nodeView, edgeView));

                    BST.BSTNode x = mNodes.searchNode(nid);

                    //rotate the node's edge about the parent node's bottom center
                    float pivotX = x.parent.pair.first.getBottom();
                    float pivotY = (x.parent.pair.first.getRight() - x.parent.pair.first.getLeft())/2;
                    edgeView.setPivotX(pivotX);
                    edgeView.setPivotY(pivotY);

                    float theta = 0;

//                    //TODO add translations accordingly(below and left of/right of) - might need to add ID to edgeview
//                    //rotate the edge to left or right based on which child the node is of its parent
//                    if (x.parent.left != null)
//                    {
//                        if (x.parent.left.pair.first.getId() == x.pair.first.getId()) {
//                            theta = (float)45.0;
//                            Timber.d("left child");
//                        }
//                    }
//
//                    else if (x.parent.right != null)
//                    {
//                        Timber.d("right child");
//                        theta = (float)-45.0;
//                    }

                    //TODO Edgeview not being drawn
                    edgeView.setRotation(theta);
                    mNodeLayout.addView(edgeView, res.getDimensionPixelSize(R.dimen.edge_width),res.getDimensionPixelSize(R.dimen.edge_height));
                }
                else
                {
                    mDelBtn.setEnabled(true);
                    mSearchBtn.setEnabled(true);
                    mNodes.insert(Pair.create(nodeView, edgeView));
                }

                mNodeLayout.addView(nodeView, res.getDimensionPixelSize(R.dimen.node_width), res.getDimensionPixelSize(R.dimen.node_height));
                if (mNodeLayout.getChildCount() >= 61) {
                    mInsBtn.setEnabled(false);
                }
            }
        });

        mDelBtn = (Button) root.findViewById(R.id.btn_delete);
        mDelBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                resetNodeColors();
                showDeleteDialog();
            }
        });

        mSearchBtn = (Button) root.findViewById(R.id.btn_search);
        mSearchBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                resetNodeColors();
                showSearchDialog();
            }

        });

        return root;
    }

    private void showDeleteDialog() {
        new MaterialDialog.Builder(getActivity())
                .title(R.string.dialog_delete_title)
                .positiveText(android.R.string.ok)
                .negativeText(android.R.string.cancel)
                .customView(R.layout.dialog_num_input, false)
                .callback(new MaterialDialog.ButtonCallback() {
                    @Override
                    public void onPositive(MaterialDialog dialog) {
                        FrameLayout root = (FrameLayout) dialog.getCustomView();
                        EditText input = (EditText) root.findViewById(R.id.input);
                        Resources res = getResources();
                        int id = 0;
                        try {
                            id = Integer.valueOf(input.getText().toString());
                        } catch (NumberFormatException nfe) {
                            Timber.w("User didn't input node value.");
                            SnackbarManager.show(
                                    Snackbar.with(getActivity())
                                            .text(res.getString(R.string.err_no_node_value))
                                            .duration(Snackbar.SnackbarDuration.LENGTH_SHORT));
                        }

                        if (id > 0 && !removeNode(id)) {
                            SnackbarManager.show(
                                    Snackbar.with(getActivity())
                                            .text(res.getString(R.string.err_node_not_found, id))
                                            .duration(Snackbar.SnackbarDuration.LENGTH_SHORT));
                        }

                        if (mNodeLayout.getChildCount() < 31) {
                            mInsBtn.setEnabled(true);
                        }
                    }
                })
                .show();
    }

    private void showSearchDialog() {
        new MaterialDialog.Builder(getActivity())
                .title(R.string.dialog_search_title)
                .positiveText(android.R.string.ok)
                .negativeText(android.R.string.cancel)
                .customView(R.layout.dialog_num_input, false)
                .callback(new MaterialDialog.ButtonCallback() {
                    @Override
                    public void onPositive(MaterialDialog dialog) {
                        FrameLayout root = (FrameLayout) dialog.getCustomView();
                        EditText input = (EditText) root.findViewById(R.id.input);
                        Resources res = getResources();
                        int id = 0;
                        try {
                            id = Integer.valueOf(input.getText().toString());
                        } catch (NumberFormatException nfe) {
                            Timber.w("User didn't input node value.");
                            SnackbarManager.show(
                                    Snackbar.with(getActivity())
                                            .text(res.getString(R.string.err_no_node_value))
                                            .duration(Snackbar.SnackbarDuration.LENGTH_SHORT));
                        }

                        if (id > 0 && !findNode(id)) {
                            SnackbarManager.show(
                                    Snackbar.with(getActivity())
                                            .text(res.getString(R.string.err_node_not_found, id))
                                            .duration(Snackbar.SnackbarDuration.LENGTH_SHORT));
                        }
                    }
                })
                .show();
    }

    /**
     * Removes the node with the specified ID,
     * and colors each visited node including the desired node.
     *
     * @param id node ID
     * @return {@code true} if node was found, {@code false} otherwise.
     */
    private boolean removeNode(int id) {

        if (!findNode(id)){
            return false;
        }

        final Resources res = getResources();
        Pair<NodeView,EdgeView> pair = mNodes.search(id);
        boolean removed = mNodes.delete(id, res.getColor(R.color.grey_500),
                res.getColor(R.color.red_400));

        if (pair.second == null && mNodes.root != null)
        {
            mNodeLayout.removeView(pair.first);
            mNodeLayout.removeView(mNodes.root.pair.second);
            mNodes.root.pair = new Pair<>(mNodes.root.pair.first, (EdgeView) null);
        }

        else
        {
            mNodeLayout.removeView(pair.second);
            mNodeLayout.removeView(pair.first);
        }
        return removed;
    }

    /**
     * Finds the node with the specified ID,
     * and colors each visited node including the desired node.
     *
     * @param id node ID
     * @return {@code true} if node was found, {@code false} otherwise.
     */
    private boolean findNode(int id) {
        final Resources res = getResources();
        boolean found = mNodes.search(id, res.getColor(R.color.grey_500),
                res.getColor(R.color.blue_400));
        return found;
    }

    private void resetNodeColors() {
        mNodes.resetColors();
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

    private class Sequencer {
        private final AtomicInteger mSequenceNumber = new AtomicInteger(0);

        public int next() {
            return mSequenceNumber.incrementAndGet();
        }
    }
}