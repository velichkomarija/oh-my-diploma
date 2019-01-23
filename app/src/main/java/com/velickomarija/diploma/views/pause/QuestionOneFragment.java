package com.velickomarija.diploma.views.pause;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.velickomarija.diploma.INavigation;
import com.velickomarija.diploma.R;
import com.velickomarija.diploma.models.Algorithms;
import com.velickomarija.diploma.models.Functions;
import com.velickomarija.diploma.views.sound.TestingSoundFragment;

/**
 * Класс, отвечающий за отрисовку фрагмента первой интерферирующей паузы.
 */
public class QuestionOneFragment extends Fragment implements INavigation {
    private static final String TAG = "QUESTION_ONE";
    private TextView textView;
    private RadioGroup radioGroup;
    private Button button;
    private ImageView image;
    private Algorithms algorithm = new Algorithms();
    private int[] arrayResult = new int[20];
    private int res = -1;
    private boolean toGo = false;
    private int countQuestions = 1;

    /**
     * Метод, необходимый для связывания компонентов внутри фрагмента.
     *
     * @param inflater           объект класса LayoutInflater.
     * @param container          объект класса ViewGroup.
     * @param savedInstanceState объект класса Bundle.
     * @return объект класса View.
     */
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.questionnaire_one_fragment, container, false);
        textView = (TextView) view.findViewById(R.id.question_text);
        button = (Button) view.findViewById(R.id.button_end_test);
        image = (ImageView) view.findViewById(R.id.image);

        radioGroup = (RadioGroup) view.findViewById(R.id.radio_question);
        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                switch (i) {
                    case -1:

                        break;

                    case R.id.radioV1:
                        res = 1;
                        break;

                    case R.id.radioV2:
                        res = 2;
                        break;

                    case R.id.radioV3:
                        res = 3;
                        break;

                    case R.id.radioV4:
                        res = 4;
                        break;

                    case R.id.radioV5:
                        res = 5;
                        break;

                    default:
                        break;
                }
            }
        });

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onClickNextQuestion(view);
            }
        });
        return view;
    }

    /**
     * Метод-обработчик нажатия на радио-кнопки.
     *
     * @param view объект класса View.
     */
    public void onClick(View view) {
        // очистить все переключатели
        radioGroup.clearCheck();
    }

    /**
     * Метод-обработчик нажатия на физическую кнопку "Назад".
     */
    public void onBackPressed() {
        // do nothing
    }

    /**
     * Метод для загрузки следующего вопроса.
     *
     * @param number номер текущего вопроса.
     */
    private void goToNextQuestion(int number) {

        if (number <= 20) {
            String resource = "q" + number;

            try {
                textView.setText((Integer) R.string
                        .class
                        .getField(resource)
                        .get(getResources()));
            } catch (Exception e) {
                e.printStackTrace();
            }

            arrayResult[number - 2] = res;
            res = -1;
        } else {
            button.setClickable(false);
            button.setText(R.string.next_test);
            image.setImageResource(R.mipmap.result);
            String result = algorithm.algorithmQuestionOne(arrayResult);
            radioGroup.setVisibility(View.INVISIBLE);
            textView.setText(result);
            toGo = true;
            button.setClickable(true);
        }
    }

    /**
     * Метод-обработчик нажатия на кнопку "Следующий вопрос".
     *
     * @param view объект класса View.
     */
    public void onClickNextQuestion(View view) {

        if (res == -1) {
            Functions.showErrorDialog(view, "Ничего не выбрано!");
        } else {
            countQuestions++;
            radioGroup.clearCheck();
            goToNextQuestion(countQuestions);
        }

        if (countQuestions == 22) {
            replaceFragment("TESTING_SOUND", new TestingSoundFragment());
        }
    }

    /**
     * Метод для обеспечения перехода между фрагментами.
     *
     * @param tag      тег фрагмента.
     * @param fragment объект класса Fragment.
     */
    @Override
    public void replaceFragment(String tag, Fragment fragment) {
        FragmentTransaction fragmentTransaction = getActivity().getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.container, fragment, tag);
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commitAllowingStateLoss();
    }
}
