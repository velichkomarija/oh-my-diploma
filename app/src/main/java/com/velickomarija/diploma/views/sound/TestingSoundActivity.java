package com.velickomarija.diploma.views.sound;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.velickomarija.diploma.R;
import com.velickomarija.diploma.models.Algorithms;
import com.velickomarija.diploma.models.Functions;
import com.velickomarija.diploma.models.PreferencesLocal;
import com.velickomarija.diploma.models.TextUtils;
import com.velickomarija.diploma.views.image.TestingEnterImageActivity;
import com.velickomarija.diploma.views.image.TestingImageVariantActivity;
import com.velickomarija.diploma.views.questionnaire.QuestionEnterActivity;

public class TestingSoundActivity extends AppCompatActivity {

    private PreferencesLocal preferencesLocal = new PreferencesLocal();
    private Algorithms algorithms = new Algorithms();

    private TextView textView;
    private EditText editText;
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
        setContentView(R.layout.activity_testing_sound);
        float size = TextUtils.setNewTextSize(getBaseContext());

        textView = (TextView) findViewById(R.id.text_sound_repeat);
        editText = (EditText) findViewById(R.id.edit_text_result_test1);

        button = (Button) findViewById(R.id.button_next);
        textView.setTextSize(size * 1.3f);
        editText.setTextSize(size * 1.4f);
        button.setTextSize(size * 1.4f);

        if (preferencesLocal.getProperty("PREF_NUM_SOUND").equals("5")) {
            textView.setText(R.string.text_new_words);
        }
        if (preferencesLocal.getProperty("PREF_NUM_SOUND").equals("4")) {
            textView.setText(R.string.text_sound_last);
        }
    }

    /**
     * Метод-обработчик нажатия на физическую кнопку "Назад".
     */
    @Override
    public void onBackPressed() {
        // do nothing
    }


    /**
     * Метод-обработчик нажатия на кнопку "Продолжить".
     *
     * @param view объект класса View.
     */
    public void onClickToGoTestingNextSound(View view) {

        int numParam = 1;

        if (!(preferencesLocal.getProperty("PREF_NUM_SOUND").equals("none"))) {
            try {
                numParam = Integer.parseInt(preferencesLocal.getProperty("PREF_NUM_SOUND"));
            } catch (Exception e) {
                Toast toast = Toast.makeText(getApplicationContext(),
                        preferencesLocal.getProperty("PREF_NUM_SOUND"),
                        Toast.LENGTH_LONG);
                toast.show();
            }
        }

        EditText textBox = (EditText) findViewById(R.id.edit_text_result_test1);
        String text = textBox.getText().toString();
        int res = algorithms.algorithmSoundMemoryC1(text, getBaseContext());//верно
        String resString = String.valueOf(res);

        if (numParam == 5) {

            resString = algorithms.algorithmSoundNewWords(text);
            if (resString.equals("11") || resString.equals("12")) {
                resString = "10";
            }
            preferencesLocal.addProperty("PREF_C4",
                    resString,
                    TestingSoundActivity.this);

            Functions.showDialogSound(TestingImageVariantActivity.class,
                    "Вы уверены в ответе?",
                    view,
                    "6");
        }

        if (numParam == 4) {

            preferencesLocal.addProperty("PREF_SOUNDLASTRESULT1",
                    resString,
                    TestingSoundActivity.this);

            preferencesLocal.addProperty("PREF_C5",
                    initResString(resString),
                    TestingSoundActivity.this);

            Functions.showDialogSound(   QuestionEnterActivity.class,
                    "Вы уверены в ответе?",
                    view,
                    "5");
        }

        if (numParam == 3) {
            preferencesLocal.addProperty("PREF_SOUNDRESULT3",
                    resString,
                    TestingSoundActivity.this);

            String par1 = preferencesLocal.getProperty("PREF_SOUNDRESULT1");
            String par2 = preferencesLocal.getProperty("PREF_SOUNDRESULT2");
            String par3 = preferencesLocal.getProperty("PREF_SOUNDRESULT3");

            String result = algorithms.algorithmSoundMemoryC2(par1, par2, par3);

            preferencesLocal.addProperty("PREF_C2",
                    result,
                    TestingSoundActivity.this);

            preferencesLocal.addProperty("PREF_NUM_IMAGE",
                    "2",
                    TestingSoundActivity.this);

            Functions.showDialogSound(TestingEnterImageActivity.class,
                    "Вы уверены в ответе?",
                    view,
                    "4");
        }

        if (numParam == 2) {

            preferencesLocal.addProperty("PREF_SOUNDRESULT2",
                    resString,
                    TestingSoundActivity.this);

            Functions.showDialogSound(TestingEnterSoundActivity.class,
                    "Вы уверены в ответе?",
                    view,
                    "3");
        }

        if (numParam == 1) {

            preferencesLocal.addProperty("PREF_C1",
                    initResString(resString),
                    TestingSoundActivity.this);

            preferencesLocal.addProperty("PREF_SOUNDRESULT1",
                    resString,
                    TestingSoundActivity.this);

            Functions.showDialogSound(TestingEnterSoundActivity.class,
                    "Вы уверены в ответе?",
                    view,
                    "2");
        }
    }

    /**
     * Метод для корректеровки результата.
     *
     * @param res первичный результат.
     * @return Скорректированный результат.
     */
    private String initResString(String res) {
        if (res.equals("11")) {
            return "10";
        }
        return res;
    }
}
