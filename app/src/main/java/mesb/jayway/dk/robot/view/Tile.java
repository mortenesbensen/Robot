package mesb.jayway.dk.robot.view;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;

/**
 * Created by Morten on 28/06/2017.
 */

public class Tile {

    private int mCol;
    private int mRow;
    private Paint mPaint;
    private int mBgColor;
    private int mBorderColor;
    private Rect rect;

    public Tile(int col, int row, int bgColor, int borderColor) {
        this.mCol = col;
        this.mRow = row;
        this.mBgColor = bgColor;
        this.mBorderColor = borderColor;
        this.mPaint = new Paint();
    }

    public void draw(Canvas canvas) {
        mPaint.setStyle(Paint.Style.FILL);
        mPaint.setColor(mBgColor);
        canvas.drawRect(rect, mPaint);

        mPaint.setStyle(Paint.Style.STROKE);
        mPaint.setColor(mBorderColor);
        canvas.drawRect(rect, mPaint);
    }

    public void setRect(Rect rect) {
        this.rect = rect;
    }
}
