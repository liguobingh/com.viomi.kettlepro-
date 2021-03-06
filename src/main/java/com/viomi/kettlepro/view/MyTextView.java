package com.viomi.kettlepro.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.Shader;
import android.support.v4.content.ContextCompat;
import android.util.AttributeSet;
import android.widget.TextView;

import com.viomi.kettlepro.R;

public class MyTextView extends TextView {
    private LinearGradient mLinearGradient;
    private Paint mPaint;
    private int mViewWidth = 0;
    private Rect mTextBound = new Rect();
    private int startColor;
    private int endColor;

    public MyTextView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    private void init() {
        startColor = getResources().getColor(R.color.bg_gray);
        endColor = getResources().getColor(R.color.bg_gray);
        this.setTypeface(TypefaceCache.getFaceText(getContext(), 1));
    }

    @Override
    protected void onDraw(Canvas canvas) {
        mViewWidth = getMeasuredWidth();
        mPaint = getPaint();
        String mTipText = getText().toString();
        mPaint.getTextBounds(mTipText, 0, mTipText.length(), mTextBound);
        mLinearGradient = new LinearGradient(0, 0, mViewWidth, 0, new int[]{startColor, startColor}, null, Shader.TileMode.REPEAT);
        mPaint.setShader(mLinearGradient);
        canvas.drawText(mTipText, 10, getMeasuredHeight() - 10, mPaint);
    }

    public void refresView(int start, int end) {
        this.startColor = getResources().getColor(start);
        this.endColor = getResources().getColor(end);
        postInvalidate();
    }
}
