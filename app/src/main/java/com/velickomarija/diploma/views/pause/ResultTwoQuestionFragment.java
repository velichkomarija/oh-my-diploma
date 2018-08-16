package com.velickomarija.diploma.views.pause;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.widget.CardView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.velickomarija.diploma.INavigation;
import com.velickomarija.diploma.R;
import com.velickomarija.diploma.models.PreferencesLocal;
import com.velickomarija.diploma.views.image.TestingNextImageFragment;

public class ResultTwoQuestionFragment extends Fragment implements INavigation {
    private static final String TAG = "RESULT_TWO_QUESTION";
    private TextView textView;
    // коллекция для групп
    private PreferencesLocal preferencesLocal = new PreferencesLocal();
    private Button button;

    public ResultTwoQuestionFragment() {

    }

    /**
     * Метод-обработчик нажатия на физическую кнопку "Назад".
     */
    public void onBackPressed() {
        // do nothing
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.result_two_question_fragment, container, false);

        textView = view.findViewById(R.id.question_result);
        final String result = preferencesLocal.getProperty("PREF_RESULT_SECOND_QUESTION");
        textView.setText(result);

        setClickListener((CardView) view.findViewById(R.id.card_title_1), (CardView) view.findViewById(R.id.card_1));
        setClickListener((CardView) view.findViewById(R.id.card_title_2), (CardView) view.findViewById(R.id.card_2));
        setClickListener((CardView) view.findViewById(R.id.card_title_3), (CardView) view.findViewById(R.id.card_3));
        setClickListener((CardView) view.findViewById(R.id.card_title_4), (CardView) view.findViewById(R.id.card_4));
        setClickListener((CardView) view.findViewById(R.id.card_title_5), (CardView) view.findViewById(R.id.card_5));

        button = view.findViewById(R.id.btn_last_test);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                replaceFragment("NEXT_IMAGE", new TestingNextImageFragment());
            }
        });
        return view;
    }

    private void setClickListener(final CardView parent, final CardView child) {
        parent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (child.getVisibility() == View.GONE) {
                    child.setVisibility(View.VISIBLE);
                } else {
                    child.setVisibility(View.GONE);
                }
            }
        });
    }

    @Override
    public void replaceFragment(String tag, Fragment fragment) {
        FragmentTransaction fragmentTransaction = getActivity().getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.container, fragment, tag);
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commitAllowingStateLoss();
    }
}
