package mesb.jayway.dk.robot.view;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;

import mesb.jayway.dk.robot.R;
import mesb.jayway.dk.robot.robot.Direction;
import mesb.jayway.dk.robot.util.BitmapRotater;

/**
 * Created by Morten on 28/06/2017.
 */

public class Tile {

    private int mCol;
    private int mRow;
    private Paint mBgPaint;
    private Paint mBorderPaint;
    private Rect mRect;
    private Bitmap mRobot;

    public Tile(int col, int row, int bgColor, int borderColor) {
        this.mCol = col;
        this.mRow = row;
        this.mBgPaint = new Paint();
        this.mBgPaint.setStyle(Paint.Style.FILL);
        this.mBgPaint.setColor(bgColor);
        this.mBorderPaint = new Paint();
        this.mBorderPaint.setStyle(Paint.Style.STROKE);
        this.mBorderPaint.setColor(borderColor);
    }

    public void draw(Canvas canvas) {
        canvas.drawRect(mRect, mBgPaint);
        canvas.drawRect(mRect, mBorderPaint);

        if(mRobot != null) {
            canvas.drawBitmap(mRobot, mRect.left, mRect.top, mBgPaint);
        }
    }

    public void setRobot(Direction direction, Bitmap robot) {
        mRobot = BitmapRotater.rotate(robot, direction);
    }

    public void removeRobot() {
        mRobot = null;
    }

    public void setRect(Rect rect) {
        this.mRect = rect;
    }
}
