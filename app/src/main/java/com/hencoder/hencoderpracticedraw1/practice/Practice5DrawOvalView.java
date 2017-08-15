package com.hencoder.hencoderpracticedraw1.practice;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

public class Practice5DrawOvalView extends View {

    private Paint mPaint;

    public Practice5DrawOvalView(Context context) {
        super(context);
        init();
    }

    public Practice5DrawOvalView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public Practice5DrawOvalView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init() {

        mPaint = new Paint();
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

//        练习内容：使用 canvas.drawOval() 方法画椭圆

        int width = this.getMeasuredWidth() / 2;
        int height = this.getMeasuredHeight() / 2;

        RectF rect = new RectF(width - 200, height - 100, width + 200, height + 100);

        canvas.drawOval(rect, mPaint);
    }
}
