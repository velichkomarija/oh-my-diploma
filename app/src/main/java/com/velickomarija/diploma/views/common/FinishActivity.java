package com.velickomarija.diploma.views.common;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
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
        setContentView(R.layout.enter_test_fragment);
        float size = TextUtils.setNewTextSize(getBaseContext());
        TextView textView = findViewById(R.id.start_text_view);
        textView.setText(R.string.finish_text);
        Button button = findViewById(R.id.next_button);
        button.setText(R.string.exit);
        textView.setTextSize(size * 2.0f);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finishAffinity();
            }
        });
    }

    /**
     * Метод обработчик нажатия аппаратной кнопки "Назад".
     */
    public void onBackPressed() {
        // do nothing
    }
}
