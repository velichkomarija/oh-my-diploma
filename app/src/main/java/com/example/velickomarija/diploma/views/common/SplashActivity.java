package com.example.velickomarija.diploma.views.common;

import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import com.example.velickomarija.diploma.R;
import com.example.velickomarija.diploma.models.PreferencesLocal;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;

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
        initAllPreference();

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(SplashActivity.this, MainActivity.class);
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

    /**
     * Метод, выполняющий первичную инициализацию полей настроек приложения.
     */
    private void initAllPreference() {
        Context context = SplashActivity.this;
        PreferencesLocal preferencesLocal = new PreferencesLocal();
        //триггеры
        preferencesLocal.addProperty("PREF_NUM_SOUND", "1", context);
        preferencesLocal.addProperty("PREF_NUM_IMAGE", "none", context);
        //данные о пользователе
        preferencesLocal.addProperty("PREF_NAME", "none", context);
        preferencesLocal.addProperty("PREF_AGE", "none", context);
        preferencesLocal.addProperty("PREF_EDUCATION", "none", context);
        preferencesLocal.addProperty("PREF_MALE", "none", context);
        preferencesLocal.addProperty("PREF_ETC_INFORMATION", "none", context);
        //результат первых трех проб в слуховой памяти
        preferencesLocal.addProperty(" PREF_SOUNDRESULT1", "none", context);
        preferencesLocal.addProperty(" PREF_SOUNDRESULT2", "none", context);
        preferencesLocal.addProperty(" PREF_SOUNDRESULT3", "none", context);
        //результат первых проб зрительной памяти
        preferencesLocal.addProperty("PREF_IMAGE1", "none", context);
        preferencesLocal.addProperty("PREF_IMAGE2", "none", context);
        preferencesLocal.addProperty("PREF_IMAGE3", "none", context);
        //результат C1,C2,C4,C6, Z1,Z2,Z4,Z6
        preferencesLocal.addProperty("PREF_C1", "none", context);
        preferencesLocal.addProperty("PREF_C2", "none", context);
        preferencesLocal.addProperty("PREF_C4", "none", context);
        preferencesLocal.addProperty("PREF_C6", "0", context);
        preferencesLocal.addProperty("PREF_Z1", "none", context);
        preferencesLocal.addProperty("PREF_Z2", "none", context);
        preferencesLocal.addProperty("PREF_Z4", "none", context);
        preferencesLocal.addProperty("PREF_Z6", "0", context);
        //Отсроченные
        preferencesLocal.addProperty("PREF_SOUNDLASTRESULT1", "none", context);
        preferencesLocal.addProperty("PREF_С5", "none", context);
        preferencesLocal.addProperty("PREF_LASTIMAGERESULT2", "none", context);
        preferencesLocal.addProperty("PREF_SOUNDLASTRESULT2", "none", context);
        preferencesLocal.addProperty("PREF_LASTIMAGERESULT1", "none", context);
        preferencesLocal.addProperty("PREF_Z5", "none", context);
        //Старые слова
        preferencesLocal.addProperty("PREF_RESULTOLDWORDS", "none", context);
    }
}

