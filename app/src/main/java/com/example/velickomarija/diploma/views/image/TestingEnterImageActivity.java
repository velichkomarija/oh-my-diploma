package com.example.velickomarija.diploma.views.image;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.velickomarija.diploma.R;
import com.example.velickomarija.diploma.models.TextUtils;

/**
 * Класс-активность для отображения инструкции к тесту зрительной памяти.
 */
public class TestingEnterImageActivity extends AppCompatActivity {

    private TextView textView;
    private Button button;

    /**
     * Метод, вызываемый перед началом работы активности.
     *
     * @param savedInstanceState объект тпа Bundle, который может хранить состояние приложения
     *                           при перерисовке активности.
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_testing_enter_image);

        float size = TextUtils.setNewTextSize(getBaseContext());
        textView = (TextView) findViewById(R.id.start_text);
        button = (Button) findViewById(R.id.button_next);
        button.setTextSize(size * 1.4f);
        textView.setTextSize(size * 1.4f);
    }

    /**
     * Метод-обработчик нажатия на физическую кнопку "Назад".
     */
    public void onBackPressed() {
        // do nothing
    }

    /**
     * Метод-обработчик нажатия на копку "Продолжить".
     *
     * @param view объект класса View.
     */
    public void onClickToGoTestingImage(View view) {
        view.setClickable(false);
        Intent intent = new Intent(this, TestingImageActivity.class);
        view.setClickable(true);
        startActivity(intent);
    }
}
