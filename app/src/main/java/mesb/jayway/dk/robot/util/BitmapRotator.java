package mesb.jayway.dk.robot.util;

import android.graphics.Bitmap;
import android.graphics.Matrix;

import mesb.jayway.dk.robot.robot.Direction;

/**
 * Rotates a bitmap based on a direction
 * <p>
 * Created by Morten on 28/06/2017.
 */

public class BitmapRotator {

    public static Bitmap rotate(Bitmap source, Direction direction) {
        int degrees = 1;
        switch (direction) {
            case S:
                degrees = 180;
                break;
            case E:
                degrees = 90;
                break;
            case W:
                degrees = 270;
        }

        Matrix matrix = new Matrix();
        matrix.postRotate(degrees);
        return Bitmap.createBitmap(source, 0, 0, source.getWidth(), source.getHeight(), matrix, true);
    }
}
