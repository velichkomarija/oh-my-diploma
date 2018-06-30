package com.velickomarija.diploma.models;

import android.content.Context;
import android.util.DisplayMetrics;

/**
 * Класс, для работы со шрифтами приложения.
 */
public class TextUtils {

    /**
     * Класс, корректирующий размер шрифта в зависимости от плотности пикселей.
     *
     * @param context контекст выполнения программы.
     * @return размер шрифта.
     */
    public static float setNewTextSize(Context context) {
        float textSize;
        DisplayMetrics metrics = context.getResources().getDisplayMetrics();
        float density = metrics.density;
        float width = metrics.widthPixels * metrics.scaledDensity;
        if (density >= 3.0f) {
            textSize = width / 350;
        } else if (density < 3.0f && density > 2.5f) {
            textSize = width / 300;
        } else if (density <= 2.5f && density > 2.0f) {
            textSize = width / 250;
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
