package com.example.velickomarija.diploma;

import android.content.Context;
import android.util.DisplayMetrics;

//todo
public class TextUtils {
    public static float textSize(Context context) {
        float textSize;
        DisplayMetrics metrics = context.getResources().getDisplayMetrics();
        float density = metrics.density;
        float width = metrics.widthPixels*metrics.scaledDensity;
        if (density >= 3.0f) {
            textSize = width/300;
        } else if (density == 2.0f) {
            textSize = width/125;
        } else {
            textSize = width/75;
        }
        return textSize;
    }

}
