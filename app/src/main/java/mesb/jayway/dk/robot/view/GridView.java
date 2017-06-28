package mesb.jayway.dk.robot.view;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.view.View;

import mesb.jayway.dk.robot.R;
import mesb.jayway.dk.robot.robot.RobotPosition;

/**
 * Created by Morten on 28/06/2017.
 */

public class GridView extends View {

    private int mCols;
    private int mRows;
    private Tile[][] mGrid;
    private Tile mRobotTile;

    public GridView(Context context) {
        super(context);

    }

    public void drawGrid(int cols, int rows) {
        mCols = cols;
        mRows = rows;

        int bgColor = getResources().getColor(R.color.robot_blue, null);
        int borderColor = getResources().getColor(R.color.robot_blue_light, null);

        // Initalize a new grid to draw on
        mGrid = new Tile[cols][rows];

        // Fill with tiles
        for(int i = 0; i < mCols; i++) {
            for(int j = 0; j < mRows; j++) {
                mGrid[i][j] = new Tile(i,j,bgColor,borderColor);
            }
        }

        this.invalidate();
    }

    /**
     * Places a robot on a tile and redraws the scene
     * @param position
     */
    public void drawRobot(RobotPosition position) {
        if(mRobotTile != null)
            mRobotTile.removeRobot();

        mRobotTile = mGrid[position.getColumn()][position.getRow()];
        Bitmap robotImage = BitmapFactory.decodeResource(getResources(), R.mipmap.ic_launcher);


        mRobotTile.setRobot(position.getDirection(), robotImage);
        this.invalidate();
    }

    @Override
    protected void onDraw(Canvas canvas) {

        if(mCols != 0 && mRows != 0) {
            // Draw all tiles
            int tileWidth = getWidth() / mCols;
            int tileHeight = getHeight() / mRows;

            // Fill with tiles
            for(int i = 0; i < mCols; i++) {
                for (int j = 0; j < mRows; j++) {
                    int xPos = i * tileWidth;
                    int yPos = j * tileHeight;
                    mGrid[i][j].setRect(new Rect(xPos, yPos, xPos + tileWidth, yPos + tileHeight));
                    mGrid[i][j].draw(canvas);
                }
            }
        }
    }
}
