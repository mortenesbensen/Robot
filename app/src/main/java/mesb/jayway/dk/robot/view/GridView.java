package mesb.jayway.dk.robot.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.view.View;

import mesb.jayway.dk.robot.R;

/**
 * Created by Morten on 28/06/2017.
 */

public class GridView extends View {

    private int mCols;
    private int mRows;
    private Tile[][] mGrid;


    public GridView(Context context, int cols, int rows) {
        super(context);

        mCols = cols;
        mRows = rows;

        // Initalize a new grid to draw on
        mGrid = new Tile[cols][rows];

        int bgColor = getResources().getColor(R.color.robot_blue, null);
        int borderColor = getResources().getColor(R.color.robot_blue_light, null);

        // Fill with tiles
        for(int i = 0; i < mCols; i++) {
            for(int j = 0; j < mRows; j++) {
                mGrid[i][j] = new Tile(i,j,bgColor,borderColor);
            }
        }
    }

    public void DrawRobot() {

    }

    @Override
    protected void onDraw(Canvas canvas) {

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
