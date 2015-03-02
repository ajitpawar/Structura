package com.davisosa.structura;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.os.CountDownTimer;
import android.os.Handler;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Created by ishan on 15-03-02.
 */
public class NodeView extends View {
    int count = 0;
    int defaulttNodeTop = 50;
    int defaultNodeLeft = 120;
    List<LLNode> nodeList = new ArrayList<LLNode>();
    LLNode currentSearchNode = null;
    Context nvContext;
    Activity parentActivity;

    public NodeView(Context context, Activity activity) {
        super(context);
        nvContext = context;
        parentActivity = activity;
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
            if ( Math.floor(nodeList.size()/3) % 2 == 1 ) {
                leftOffset = (int) (defaultNodeLeft + (300 * Math.abs(2 - (nodeList.size() - (3 * (Math.floor(nodeList.size() / 3)))))));
            } else {
                leftOffset = (int) (defaultNodeLeft + (300 * (nodeList.size() - (3 * (Math.floor(nodeList.size() / 3))))));
            }
        }

        Random rand = new Random();
        int rand_num = rand.nextInt((100 - 1) + 1) + 1;
        int value = rand_num;
        // TODO: convert to enum
        int arrowDirection = 0; // -1 -> none, 0 -> horizontal, 1 -> vertical, 3 -> both
        if ( Math.floor(nodeList.size()/3) % 2 == 0 ) {
            if ( (nodeList.size()+1 - 3) % 3 == 0 ) {
                arrowDirection = 1;
            }
        } else {
            if ( (nodeList.size() - (3*(Math.floor(nodeList.size() / 3)))) == 2 ) {
                arrowDirection = 3;
            } else if ( ( nodeList.size() - (3*(Math.floor(nodeList.size() / 3)))) == 0 ) {
                arrowDirection = -1;
            }
        }
        Bitmap bitmap = getNodeBitmap(arrowDirection, value);

        return new LLNode(bitmap, value, leftOffset, topOffset);
    }

    public void deleteNode() {
        if (nodeList.size() == 0) {
            return;
        }
        nodeList.remove(nodeList.size() - 1);
        invalidate();
    }

    public void findNode(int value) {
        Boolean found = false;
        int index = 0;
        Handler handler = new Handler();

        final int maxIndex;

        while (!found && index < nodeList.size()) {
            if (nodeList.get(index).value == value) {
                found = true;
            }
            index++;
        }

        final String toastText = (found) ? "Found!" : "Uhoh! We do not have a node with that value.";
        maxIndex = (found) ? index : nodeList.size();

        for (int i = 0; i < maxIndex; i++) {
            final int finalIndex = i;
            Runnable runnable = new Runnable() {

                @Override
                public void run() {
                    highlightNode(finalIndex);
                    if (finalIndex == maxIndex - 1) {
                        Toast.makeText(nvContext, toastText, Toast.LENGTH_LONG).show();
                        new CountDownTimer(3500, 1000) {
                            public void onTick(long millisUntilFinished) {

                            }
                            public void onFinish() {
                                currentSearchNode = null;
                                invalidate();
                            }

                        }.start();
                    }
                };

            };

            handler.postDelayed(runnable, 2000*i);
        }
    }

    public void highlightNode(int index) {
        System.out.println(index);
        LLNode currentNode = nodeList.get(index);
        Bitmap bitmap = currentNode.bitmap;

        Bitmap newBitmap = Bitmap.createBitmap(bitmap.getWidth()-100, bitmap.getHeight(), Bitmap.Config.ARGB_4444);
        Canvas canvas = new Canvas(newBitmap);
        canvas.drawColor(Color.argb(100, 57, 202, 116));

        currentSearchNode = new LLNode(newBitmap, 0, currentNode.leftOffset, currentNode.topOffset);
        invalidate();
    }

    public Bitmap getNodeBitmap(int arrowDirection, int nodeValue) {
        View node = parentActivity.getLayoutInflater().inflate(R.layout.ll_node, null);

        TextView tvNodeValueDigit = (TextView) node.findViewById(R.id.tvNodeValueDigit);
        tvNodeValueDigit.setText(String.format("%02d", nodeValue));

        node.measure(MeasureSpec.UNSPECIFIED, MeasureSpec.UNSPECIFIED);
        node.layout(0, 0, node.getMeasuredWidth(), node.getMeasuredHeight());

        int width = node.getMeasuredWidth() + 100;
        int height = (arrowDirection == 1 || arrowDirection == 3) ? node.getMeasuredHeight() + 50 : node.getMeasuredHeight();

        Bitmap bitmap = Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(bitmap);
        node.draw(canvas);

        Paint paint = new Paint();
        paint.setColor(Color.BLACK);
        paint.setStrokeWidth(6);
        if (arrowDirection == 0) {
            canvas.drawLine(node.getMeasuredWidth() - 15, 120, node.getMeasuredWidth() + 70, 120, paint);
        } else if (arrowDirection == 1) {
            canvas.drawLine(node.getMeasuredWidth() - 30, 120, node.getMeasuredWidth() - 30, 300, paint);
        } else if (arrowDirection == 3) {
            canvas.drawLine(node.getMeasuredWidth() - 15, 120, node.getMeasuredWidth() + 70, 120, paint);
            canvas.drawLine(node.getMeasuredWidth() - 30, 120, node.getMeasuredWidth() - 30, 300, paint);
        }


        return bitmap;
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.save();
        for (int i = 0; i < nodeList.size(); i++) {
            canvas.drawBitmap(nodeList.get(i).bitmap, nodeList.get(i).leftOffset, nodeList.get(i).topOffset, null);
        }
        if (currentSearchNode != null) {
            canvas.drawBitmap(currentSearchNode.bitmap, currentSearchNode.leftOffset, currentSearchNode.topOffset, null);
        }
        canvas.restore();
    }
}
