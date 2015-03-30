package com.davisosa.structura.view;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.view.View;

import com.davisosa.structura.R;

public class EdgeView extends View {
    private final Paint mPaint = new Paint();

    private int mBackgroundColor;
    private int mWidth;
    private int mHeight;

    public EdgeView(Context context) {
        super(context);
        setWillNotDraw(false);

        Resources res = getResources();
        mBackgroundColor = res.getColor(R.color.black);

        mPaint.setAntiAlias(true);
        mPaint.setStyle(Paint.Style.FILL);
    }

    @Override
    protected void onSizeChanged(final int w, final int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
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
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        mPaint.setColor(mBackgroundColor);
        canvas.drawRect(0, 0, mWidth, mHeight, mPaint);
    }
}
