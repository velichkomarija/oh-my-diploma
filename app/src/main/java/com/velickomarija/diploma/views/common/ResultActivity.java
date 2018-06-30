package com.velickomarija.diploma.views.common;

import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Html;
import android.view.View;
import android.widget.TextView;

import com.velickomarija.diploma.R;
import com.velickomarija.diploma.models.Algorithms;
import com.velickomarija.diploma.models.Functions;
import com.velickomarija.diploma.models.PreferencesLocal;
import com.velickomarija.diploma.models.ResultCreator;

/**
 * Класс-активность, отображающая результаты тестирования.
 */
public class ResultActivity extends AppCompatActivity {

    private TextView sound, image, total;
    private PreferencesLocal preferencesLocal = new PreferencesLocal();
    private Algorithms algorithms = new Algorithms();

    /**
     * Метод-обработчик нажатия на физическую кнопку "Назад".
     */
    public void onBackPressed() {
        // do nothing
    }

    /**
     * Метод, вызываемый перед началом работы активности.
     *
     * @param savedInstanceState объект тпа Bundle, который может хранить состояние приложения
     *                           при перерисовке активности.
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        sound = findViewById(R.id.text_view_result_sound);
        image = findViewById(R.id.result_Image);
        total = findViewById(R.id.result_Total);

        preferencesLocal.addProperty("PREF_C6",
                algorithms.getCorrectionC6(preferencesLocal.getProperty("PREF_C6")),
                getBaseContext());

        preferencesLocal.addProperty("PREF_Z6",
                algorithms.getCorrectionC6(preferencesLocal.getProperty("PREF_Z6")),
                getBaseContext());

        String[] results = countResult();

        sound.setText(results[0]);
        image.setText(results[1]);
        total.setText(results[2]);

    }

    /**
     * Метод, расчитывающий конечные результаты тестирования.
     *
     * @return Массив с результатами тестирования.
     */
    private String[] countResult() {
        String[] result = new String[3];
        int resSound = 0;

        for (int i = 0; i < 6; i++) {
            String nameProperty = "PREF_C" + (i + 1);
            try {
                resSound = resSound + Integer.parseInt(preferencesLocal.getProperty(nameProperty));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        String resString = String.valueOf(resSound);
        preferencesLocal.addProperty("PREF_TOTAL_SOUND",
                resString,
                ResultActivity.this);
        result[0] = resString;

        int resImage = 0;
        for (int i = 0; i < 6; i++) {
            String nameProperty = "PREF_Z" + (i + 1);
            try {
                resImage = resImage + Integer.parseInt(preferencesLocal.getProperty(nameProperty));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        resString = String.valueOf(resImage);
        preferencesLocal.addProperty("PREF_TOTAL_IMAGE",
                resString,
                ResultActivity.this);
        result[1] = resString;

        resString = String.valueOf(resImage + resSound);
        preferencesLocal.addProperty("PREF_TOTAL",
                resString,
                ResultActivity.this);
        result[2] = resString;

        return result;
    }

    /**
     * Метод-обработчик нажатия кнопки "Продолжить".
     *
     * @param view объект класса View.
     */
    public void onClickToExit(final View view) {
        AlertDialog.Builder builder = new AlertDialog.Builder(view.getContext());
        builder.setTitle("Важное сообщение!")
                .setMessage("Отправить результаты для получения общей статистики?")
                .setIcon(R.drawable.ic_error_black_24dp)
                .setCancelable(false).setPositiveButton("Да",
                new DialogInterface.OnClickListener() {

                    public void onClick(DialogInterface dialog, int id) {
                        ResultCreator.sendFile(ResultActivity.this);
                        Functions.activityToGo(FinishActivity.class, view);
                    }

                })
                .setNegativeButton("Нет",
                        new DialogInterface.OnClickListener() {

                            public void onClick(DialogInterface dialog, int id) {
                                dialog.cancel();
                                Functions.activityToGo(FinishActivity.class, view);
                            }

                        }
                );
        builder.setMessage(Html.fromHtml("<font color='#000000'>" +
                "Отправить результаты для получения общей статистики?" +
                "</font>"));
        AlertDialog alert = builder.create();
        alert.show();
    }
}
