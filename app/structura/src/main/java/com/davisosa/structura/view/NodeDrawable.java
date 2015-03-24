package com.davisosa.structura.view;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.PixelFormat;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;

public class NodeDrawable extends Drawable
{
    private final Paint mPaint = new Paint();
    private final RectF mBounds = new RectF();

    private float mWidth;
    private float mHeight;

    public NodeDrawable(Context context) {
        final Resources res = context.getResources();
        mPaint.setAntiAlias(true);
        mPaint.setStyle(Paint.Style.FILL);
        mPaint.setColor(Color.WHITE);
    }


    @Override
    protected void onBoundsChange(Rect bounds) {
        super.onBoundsChange(bounds);
        mBounds.set(bounds);
        mWidth = mBounds.width();
        mHeight = mBounds.height();
    }

    @Override
    public void draw(Canvas canvas)
    {
        canvas.save();
        // TODO Fill in if needed
        canvas.restore();
    }

    @Override
    public void setAlpha(int alpha) {
        mPaint.setAlpha(alpha);
        invalidateSelf();
    }
    @Override
    public void setColorFilter(ColorFilter cf) {
        mPaint.setColorFilter(cf);
        invalidateSelf();
    }

    @Override
    public int getOpacity() {
        return PixelFormat.OPAQUE;
    }

}
