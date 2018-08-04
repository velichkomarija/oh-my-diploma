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
        View view = inflater.inflate(R.layout.enter_test_fragment, container, false);

        TextView text = view.findViewById(R.id.start_text_view);

        text.setText(R.string.finish_text);
        float size = TextUtils.setNewTextSize(getContext());
        text.setTextSize(size * 2.0f);

        Button exitButton = view.findViewById(R.id.next_button);
        exitButton.setText(R.string.exit);

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
