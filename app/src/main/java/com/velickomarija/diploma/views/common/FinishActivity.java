package com.velickomarija.diploma.views.common;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.velickomarija.diploma.R;
import com.velickomarija.diploma.models.TextUtils;

/**
 * Класс-активность выхода из приложения.
 */
public class FinishActivity extends AppCompatActivity {

    /**
     * Метод, вызываемый перед началом работы активности.
     *
     * @param savedInstanceState объект тпа Bundle, который может хранить состояние приложения
     *                           при перерисовке активности.
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_finish);
        float size = TextUtils.setNewTextSize(getBaseContext());
        TextView textView = findViewById(R.id.start_text_finish);
        Button button = findViewById(R.id.exit);
        textView.setTextSize(size * 2.0f);
        button.setTextSize(size * 1.4f);
    }

    /**
     * Метод обработчик нажатия аппаратной кнопки "Назад".
     */
    public void onBackPressed() {
        // do nothing
    }

    /**
     * Метод обработчик нажатия на кнопку "Выход".
     *
     * @param view объект класса View.
     */
    public void onClickExit(View view) {
        finishAffinity();
    }
}
