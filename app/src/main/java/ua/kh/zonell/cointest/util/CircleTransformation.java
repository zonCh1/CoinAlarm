package ua.kh.zonell.cointest.util;

import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Shader;

import com.squareup.picasso.Transformation;

public class CircleTransformation implements Transformation {

    private int borderColor;
    private int borderSize;
    private int backgroundColor;
    private String key;

    public CircleTransformation(int borderColor, int borderSize) {
        this(borderColor, borderSize, Color.WHITE);
    }

    public CircleTransformation(int borderColor, int borderSize, int bgColor) {
        this.borderColor = borderColor;
        this.borderSize = borderSize;
        this.backgroundColor = bgColor;
        this.key = "circle(color=" + borderColor + ", size=" + borderSize + ")";
    }

    public Bitmap transform(Bitmap source) {
        int size = Math.min(source.getWidth(), source.getHeight());
        int x = (source.getWidth() - size) / 2;
        int y = (source.getHeight() - size) / 2;
        Bitmap squaredBitmap = Bitmap.createBitmap(source, x, y, size, size);
        if(squaredBitmap != source) {
            source.recycle();
        }

        Bitmap.Config config = source.getConfig();
        if(config == null) {
            config = Bitmap.Config.ARGB_8888;
        }

        Bitmap bitmap = Bitmap.createBitmap(size, size, config);
        Canvas canvas = new Canvas(bitmap);
        Paint paint = new Paint();
        BitmapShader shader = new BitmapShader(squaredBitmap, Shader.TileMode.CLAMP, Shader.TileMode.CLAMP);
        paint.setShader(shader);
        paint.setAntiAlias(true);
        float r = (float)size / 2.0F;
        if(this.borderSize > 0) {
            Paint bg = new Paint();
            bg.setColor(this.borderColor);
            bg.setAntiAlias(true);
            canvas.drawCircle(r, r, r, bg);
        }

        Paint bgPaint = new Paint();
        bgPaint.setAntiAlias(true);
        bgPaint.setColor(backgroundColor);

        canvas.drawCircle(r, r, r - (float)this.borderSize, bgPaint);
        canvas.drawCircle(r, r, r - (float)this.borderSize, paint);
        squaredBitmap.recycle();
        return bitmap;
    }

    public String key() {
        return this.key;
    }

}
