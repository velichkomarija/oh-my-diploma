package com.velickomarija.diploma.views.questionnaire;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.velickomarija.diploma.INavigation;
import com.velickomarija.diploma.R;

public class QuestionEnter2Fragment extends Fragment implements INavigation {
    private static final String TAG = "QUESTION_SECOND_ENTER";

    private TextView textView;
    private Button button;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.testing_enter_fragment, container, false);
        textView = (TextView) view.findViewById(R.id.start_text);
        textView.setText(R.string.enter_two_questionnarie);

        button = (Button) view.findViewById(R.id.button_next);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                replaceFragment("QUESTION_SECOND", new QuestionTwoFragment());
            }
        });
        return view;
    }

    public void onBackPressed() {
        // do nothing
    }

    public QuestionEnter2Fragment() {

    }

    @Override
    public void replaceFragment(String tag, Fragment fragment) {
        FragmentTransaction fragmentTransaction = getActivity().getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.container, fragment, tag);
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commitAllowingStateLoss();
    }
}
