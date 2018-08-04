package com.velickomarija.diploma.views.common;

import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AlertDialog;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.velickomarija.diploma.INavigation;
import com.velickomarija.diploma.R;
import com.velickomarija.diploma.models.Algorithms;
import com.velickomarija.diploma.models.Functions;
import com.velickomarija.diploma.models.PreferencesLocal;
import com.velickomarija.diploma.models.ResultCreator;

public class ResultFragment extends Fragment implements INavigation {
    private final static String TAG = "RESULT_FRAGMENT";
    private PreferencesLocal preferencesLocal = new PreferencesLocal();
    private Algorithms algorithms = new Algorithms();

    /**
     * Метод-обработчик нажатия на физическую кнопку "Назад".
     */
    public void onBackPressed() {
        // do nothing
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.result_fragment, container, false);

        preferencesLocal.addProperty("PREF_C6",
                algorithms.getCorrectionC6(preferencesLocal.getProperty("PREF_C6")),
                getContext());

        preferencesLocal.addProperty("PREF_Z6",
                algorithms.getCorrectionC6(preferencesLocal.getProperty("PREF_Z6")),
                getContext());

        String[] results = countResult();

        ((TextView) view.findViewById(R.id.text_view_result_sound)).setText(results[0]);
        ((TextView) view.findViewById(R.id.result_Image)).setText(results[1]);
        ((TextView) view.findViewById(R.id.result_Total)).setText(results[2]);

        ((Button) view.findViewById(R.id.buttonNextPart)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onClickToExit(view);
            }
        });

        return view;
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
                getContext());
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
                getContext());
        result[1] = resString;

        resString = String.valueOf(resImage + resSound);
        preferencesLocal.addProperty("PREF_TOTAL",
                resString,
                getContext());
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
        String textMsg = "Отправить результаты для получения общей статистики?";

        builder.setTitle(R.string.important_message)
                .setMessage(textMsg)
                .setIcon(R.drawable.ic_error_black_24dp)
                .setCancelable(false).
                setPositiveButton(getString(R.string.yes),
                        new DialogInterface.OnClickListener() {

                            public void onClick(DialogInterface dialog, int id) {
                                ResultCreator.sendFile(getContext());
                                replaceFragment("FINISH_FRAGMENT", new FinishFragment());
                            }

                        })
                .setNegativeButton(getString(R.string.no),
                        new DialogInterface.OnClickListener() {

                            public void onClick(DialogInterface dialog, int id) {
                                dialog.cancel();
                                replaceFragment("FINISH_FRAGMENT", new FinishFragment());
                            }

                        }
                );
        builder.setMessage(Html.fromHtml("<font color='#000000'>" +
                textMsg +
                "</font>"));
        AlertDialog alert = builder.create();
        alert.show();
    }

    @Override
    public void replaceFragment(String tag, Fragment fragment) {
        FragmentTransaction fragmentTransaction = getActivity().getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.container, fragment, tag);
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commitAllowingStateLoss();
    }
}
