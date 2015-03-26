package com.davisosa.structura.view;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.PixelFormat;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.text.TextPaint;

import com.davisosa.structura.R;

public class NodeDrawable extends Drawable
{
    private final TextPaint mTextPaint = new TextPaint();
    private final RectF mBounds = new RectF();

    private final int mTextColor;
    private final int mTextSize;

    private float mWidth;
    private float mHeight;

    private int mId = 0;

    public NodeDrawable(Context context) {
        Resources res = context.getResources();

        mTextPaint.setAntiAlias(true);
        mTextPaint.setLinearText(true);
        mTextPaint.setSubpixelText(true);
        mTextPaint.setTextAlign(Paint.Align.CENTER);

        mTextColor = res.getColor(R.color.black_text);
        mTextSize = res.getDimensionPixelSize(R.dimen.text_size_large);

        mTextPaint.setColor(mTextColor);
        mTextPaint.setTextSize(mTextSize);
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
        canvas.translate(mBounds.centerX(), mBounds.centerY());

        // Draw centered text.
        float textHeight = mTextPaint.descent() - mTextPaint.ascent();
        float textOffset = (textHeight / 2) - mTextPaint.descent();
        canvas.drawText(String.valueOf(mId), 0, textOffset, mTextPaint);

        canvas.restore();
    }

    @Override
    public void setAlpha(int alpha) {
        mTextPaint.setAlpha(alpha);
        invalidateSelf();
    }

    @Override
    public void setColorFilter(ColorFilter cf) {
        mTextPaint.setColorFilter(cf);
        invalidateSelf();
    }

    @Override
    public int getOpacity() {
        return PixelFormat.OPAQUE;
    }

    public int getId() {
        return mId;
    }

    public void setId(int id) {
        mId = id;
    }
}