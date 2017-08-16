package com.hencoder.hencoderpracticedraw1.practice;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

public class Practice10HistogramView extends View {

    private Paint mPaint;
    private int width;
    private int height;

    public Practice10HistogramView(Context context) {
        super(context);
        init();
    }

    public Practice10HistogramView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public Practice10HistogramView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init() {

        mPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

//        综合练习
//        练习内容：使用各种 Canvas.drawXXX() 方法画直方图

        mPaint.setColor(Color.WHITE);
        canvas.drawLine(width / 9, height / 10, width / 9, height / 5 * 4, mPaint);
        canvas.drawLine(width / 9, height / 5 * 4, width / 9 * 8, height / 5 * 4, mPaint);
        mPaint.setTextSize(40);
        canvas.drawText("直方图", width / 2 - 60, height / 10 * 9 + 20, mPaint);

        mPaint.setTextSize(30);
        drawText(canvas, "Froyo", 1);
        drawText(canvas, "GB", 2);
        drawText(canvas, "ICS", 3);
        drawText(canvas, "JB", 4);
        drawText(canvas, "Kitkat", 5);
        drawText(canvas, "L", 6);
        drawText(canvas, "M", 7);

        mPaint.setColor(Color.GREEN);
        drawRect(canvas, 1, 1);
        drawRect(canvas, 2, 10);
        drawRect(canvas, 3, 20);
        drawRect(canvas, 4, 30);
        drawRect(canvas, 5, 50);
        drawRect(canvas, 6, 70);
        drawRect(canvas, 7, 25);
    }

    /**
     * @param canvas
     * @param str    绘制文字内容
     * @param x      起点位置
     */
    private void drawText(Canvas canvas, String str, float x) {
        x = width / 9 * x;
        canvas.drawText(str, getTextWidth(mPaint, str) > (width / 9) ? x : (x + width / 9 / 2 - getTextWidth(mPaint, str) / 2), height / 5 * 4 + 30, mPaint);
    }

    /**
     * @param canvas
     * @param x       起点位置
     * @param percent 高度百分比
     */
    private void drawRect(Canvas canvas, float x, float percent) {
        x = width / 9 * x;
        canvas.drawRect(x + 10, height / 5 * 4 - height / 10 * 7 / 100 * percent, x + width / 9 - 10, height / 5 * 4, mPaint);
    }

    private int getTextWidth(Paint paint, String str) {
        int iRet = 0;
        if (str != null && str.length() > 0) {
            int len = str.length();
            float[] widths = new float[len];
            paint.getTextWidths(str, widths);
            for (int j = 0; j < len; j++) {
                iRet += (int) Math.ceil(widths[j]);
            }
        }
        return iRet;
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        width = this.getMeasuredWidth();
        height = this.getMeasuredHeight();
    }
}
