package mesb.jayway.dk.robot.view.grid;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;

import mesb.jayway.dk.robot.robot.Direction;
import mesb.jayway.dk.robot.util.BitmapRotator;

/**
 * Represents one tile in the GridView
 *
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

    /**
     * Draws the tile on the canvas
     */
    public void draw(Canvas canvas) {
        canvas.drawRect(mRect, mBgPaint);
        canvas.drawRect(mRect, mBorderPaint);

        if (mRobot != null) {
            canvas.drawBitmap(mRobot, mRect.left + ((mRect.width() - mRobot.getWidth()) / 2), mRect.top + ((mRect.height() - mRobot.getHeight()) / 2), mBgPaint);
        }
    }

    /**
     * Set a robot on this tile
     */
    public void setRobot(Direction direction, Bitmap robot) {
        mRobot = BitmapRotator.rotate(robot, direction);
    }

    /**
     * Remove the robot again
     */
    public void removeRobot() {
        mRobot = null;
    }


    public void setRect(Rect rect) {
        this.mRect = rect;
    }
}
