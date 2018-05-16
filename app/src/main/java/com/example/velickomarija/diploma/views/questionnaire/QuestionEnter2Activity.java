package com.example.velickomarija.diploma.views.questionnaire;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.velickomarija.diploma.R;
import com.example.velickomarija.diploma.models.TextUtils;

/**
 * Класс-активность для вывода инструкции к опроснику №2.
 */
public class QuestionEnter2Activity extends AppCompatActivity {
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
        setContentView(R.layout.activity_question_enter);

        float size = TextUtils.setNewTextSize(getBaseContext());
        textView = (TextView) findViewById(R.id.start_text);
        button = (Button) findViewById(R.id.go_testing);
        button.setTextSize(size * 1.4f);
        textView.setText(R.string.enter_two_questionnarie);
        textView.setTextSize(size * 1.4f);
    }

    /**
     * Метод-обработчик нажатия на физическую кнопку "Назад".
     */
    public void onBackPressed() {
        // do nothing
    }

    /**
     * Метод-обработчик нажатия на кнопку "Продолжить".
     *
     * @param view объект класса View.
     */
    public void onClickToGoAnswerQuestion(View view) {
        Intent intent = new Intent(this, QuestionTwoActivity.class);
        startActivity(intent);
    }
}
