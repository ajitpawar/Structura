package com.davisosa.structura.view;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;

import com.davisosa.structura.R;

public class NodeView extends View {
    private final NodeDrawable mDrawable;
    private final Paint mPaint = new Paint();

    private int mBackgroundColor;
    private int mWidth;
    private int mHeight;

    public NodeView(Context context, AttributeSet attrs)
    {
        super(context, attrs);
        setWillNotDraw(false);

        Resources res = getResources();
        mBackgroundColor = res.getColor(R.color.blue_grey_200);

        mPaint.setAntiAlias(true);
        mPaint.setStyle(Paint.Style.FILL);

        mDrawable = new NodeDrawable(context);
        mDrawable.setCallback(this);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec)
    {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        final int size = Math.min(getMeasuredWidth(), getMeasuredHeight());
        setMeasuredDimension(size, size);
    }

    @Override
    protected void onSizeChanged(final int w, final int h, int oldw, int oldh)
    {
        super.onSizeChanged(w, h, oldw, oldh);
        mDrawable.setBounds(0, 0, w, h);
        mWidth = w;
        mHeight = h;
    }

    private int getColor() {
        return mBackgroundColor;
    }

    private void setColor(int color) {
        mBackgroundColor = color;
        invalidate();
    }

    @Override
    protected boolean verifyDrawable(Drawable who) {
        return who == mDrawable || super.verifyDrawable(who);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        mPaint.setColor(mBackgroundColor);
        final float radius = Math.min(mWidth, mHeight) / 2f;
        canvas.drawCircle(mWidth / 2f, mHeight / 2f, radius, mPaint);
        mDrawable.draw(canvas);
    }
}
