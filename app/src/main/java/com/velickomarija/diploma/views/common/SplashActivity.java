package com.velickomarija.diploma.views.common;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;

import com.velickomarija.diploma.R;
import com.velickomarija.diploma.models.PreferencesLocal;

/**
 * Класс-активность, отвечающая за загрузку заставки приложения.
 */
public class SplashActivity extends AppCompatActivity {

    /**
     * Метод, вызываемый перед началом работы активности.
     *
     * @param savedInstanceState объект тпа Bundle, который может хранить состояние приложения
     *                           при перерисовке активности.
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(SplashActivity.this, UserActivity.class);
                startActivity(intent);
                finish();
            }
        }, 3000);
    }

    /**
     * Метод-обработчик нажатия на физическую кнопку "Назад".
     */
    public void onBackPressed() {
        // do nothing
    }
}

