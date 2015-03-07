package com.davisosa.structura.model;

import android.graphics.Bitmap;

/**
 * Created by ishan on 15-03-01.
 */
public class LLNode {
    public Bitmap bitmap;
    public int value;
    public int leftOffset;
    public int topOffset;

    public LLNode(Bitmap bitmap, int value, int leftOffset, int topOffset) {
        this.bitmap = bitmap;
        this.value = value;
        this.leftOffset = leftOffset;
        this.topOffset = topOffset;
    }
}
