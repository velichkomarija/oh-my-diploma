package com.velickomarija.diploma.views.common;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.velickomarija.diploma.R;
import com.velickomarija.diploma.models.TextUtils;

/**
 * Класс-активность, загружающая интерфейс приветственного окна приложения.
 */
public class MainActivity extends AppCompatActivity {

    private TextView text;
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
        setContentView(R.layout.activity_main);

        text = (TextView) this.findViewById(R.id.start_text_view);
        button = (Button) this.findViewById(R.id.next_button);

        float size = TextUtils.setNewTextSize(getBaseContext());
        text.setTextSize(size * 1.15f);
        button.setTextSize(size * 1.4f);
    }

    /**
     * Метод-обработчик нажатия на кнопку "Продолжить".
     *
     * @param view объект класса View.
     */
    public void onClickToRegistrationUser(View view) {
        Intent intent = new Intent(this, ProfileActivity.class);
        startActivity(intent);
    }

    /**
     * Метод обработчик нажатия аппаратной кнопки "Назад".
     */
    public void onBackPressed() {
        // do nothing
    }
}
