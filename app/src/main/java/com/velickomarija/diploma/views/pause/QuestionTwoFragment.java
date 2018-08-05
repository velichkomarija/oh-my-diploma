package com.velickomarija.diploma.views.pause;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.velickomarija.diploma.INavigation;
import com.velickomarija.diploma.R;
import com.velickomarija.diploma.models.Algorithms;
import com.velickomarija.diploma.models.PreferencesLocal;

public class QuestionTwoFragment extends Fragment implements INavigation {
    private TextView textView;
    private static final String TAG = "QUESTION_TWO";
    private PreferencesLocal preferencesLocal = new PreferencesLocal();
    private ProgressBar progressBar;
    private ImageView imageView;
    private Button buttonPlus, buttonMinus;
    private Algorithms algorithm = new Algorithms();
    private int[] arrayResult = new int[40];
    private int countQuestions = 1;

    /**
     * Метод-обработчик нажатия на физическую кнопку "Назад".
     */
    public void onBackPressed() {
        // do nothing
    }

    public void onClickNextQuestionPlus() {
        arrayResult[countQuestions - 1] = 1;
        clk();
    }

    public void onClickNextQuestionMinus() {
        arrayResult[countQuestions - 1] = 0;
        clk();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.questionnaire_two_fragment, container, false);
        textView = (TextView) view.findViewById(R.id.question_text);
        buttonMinus = (Button) view.findViewById(R.id.button_minus);
        buttonPlus = (Button) view.findViewById(R.id.button_plus);
        progressBar = view.findViewById(R.id.progress);
        imageView = view.findViewById(R.id.image);

        buttonMinus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onClickNextQuestionPlus();
            }
        });

        buttonPlus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onClickNextQuestionMinus();
            }
        });
        return view;
    }

    /**
     * Метод загрузки следующего высказывания.
     *
     * @param number номер высказывания.
     */
    private void goToNextQuestion(int number) {

        if (number <= 40) {
            String resource = "qq" + number;

            try {
                textView.setText((Integer) R.string
                        .class
                        .getField(resource)
                        .get(getResources()));
            } catch (Exception e) {
                e.printStackTrace();
            }

        } else {
            buttonMinus.setVisibility(View.GONE);
            buttonPlus.setVisibility(View.GONE);
            String result = algorithm.algorithmQuestionTwo(arrayResult);
            preferencesLocal.addProperty("PREF_RESULT_SECOND_QUESTION",
                    result,
                    getContext());
            replaceFragment("RESULT_TWO_QUESTION",
                    new ResultTwoQuestionFragment());
        }
    }

    private void clk() {
        time();
        countQuestions++;
        goToNextQuestion(countQuestions);
    }

    /**
     * Метод для обработки шкалы загрузки вопроса.
     */
    private void time() {
        textView.setVisibility(View.INVISIBLE);
        imageView.setVisibility(View.INVISIBLE);
        progressBar.setVisibility(View.VISIBLE);

        buttonMinus.setClickable(false);
        buttonPlus.setClickable(false);
        CountDownTimer start = new CountDownTimer(600, 150) {

            int progress = 25;

            public void onTick(long milliesUntilFinished) {
                progress = progress + 25;
                progressBar.setSecondaryProgress(progress);
            }

            public void onFinish() {
                progressBar.setVisibility(View.GONE);
                textView.setVisibility(View.VISIBLE);
                imageView.setVisibility(View.VISIBLE);
                buttonMinus.setClickable(true);
                buttonPlus.setClickable(true);
            }
        }.start();
    }

    @Override
    public void replaceFragment(String tag, Fragment fragment) {
        FragmentTransaction fragmentTransaction = getActivity().getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.container, fragment, tag);
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commitAllowingStateLoss();
    }
}
