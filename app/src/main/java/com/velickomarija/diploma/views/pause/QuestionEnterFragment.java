package com.velickomarija.diploma.views.pause;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.velickomarija.diploma.INavigation;
import com.velickomarija.diploma.R;

/**
 * Класс, обеспечивающий отрисовку фрагмента инструкции к первой интерферирующей паузе.
 */
public class QuestionEnterFragment extends Fragment implements INavigation {
    private static final String TAG = "QUESTION_ENTER";

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
        View view = inflater.inflate(R.layout.question_enter_fragment_small_font, container, false);

        Button button = (Button) view.findViewById(R.id.go_testing);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                replaceFragment("QUESTION_ONE", new QuestionOneFragment());
            }
        });

        return view;
    }


    /**
     * Конструктор класса.
     */
    public QuestionEnterFragment() {
    }

    /**
     * Метод-обработчик нажатия на физическую кнопку "Назад".
     */
    public void onBackPressed() {
        // do nothing
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
