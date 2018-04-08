package com.example.velickomarija.diploma.models;

import android.content.Context;
import android.util.DisplayMetrics;

/*
    Работа с размером экрана
 */
public class TextUtils {
    public static float textSize(Context context) {
        float textSize;
        DisplayMetrics metrics = context.getResources().getDisplayMetrics();
        float density = metrics.density;
        float width = metrics.widthPixels * metrics.scaledDensity;
        if (density >= 3.0f) {
            textSize = width / 350;
        } else if (density < 3.0f && density > 2.0f) {
            textSize = width / 275;
        } else if (density == 2.0f) {
            textSize = width / 175;
        } else if (density < 2.0f && density > 1.5f) {
            textSize = width / 150;
        } else {
            textSize = width / 100;
        }
        return textSize;
    }

}
