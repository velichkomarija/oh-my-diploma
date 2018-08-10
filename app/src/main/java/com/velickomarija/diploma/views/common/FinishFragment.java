package com.velickomarija.diploma.views.common;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.velickomarija.diploma.R;
import com.velickomarija.diploma.models.TextUtils;

public class FinishFragment extends Fragment {
    private static final String TAG = "FINISH_FRAGMENT";

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.finish_fragment, container, false);

        Button exitButton = view.findViewById(R.id.exit_button);
        Button feedbackButton = view.findViewById(R.id.feedback_button);

        exitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getActivity().finishAffinity();
            }
        });
        return view;
    }

    /**
     * Метод обработчик нажатия аппаратной кнопки "Назад".
     */
    public void onBackPressed() {
        // do nothing
    }
}
