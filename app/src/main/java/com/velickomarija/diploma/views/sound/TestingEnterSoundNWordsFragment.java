package com.velickomarija.diploma.views.sound;

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

/**
 * Класс, выполняющий отрисовку фрагмента узнавания новых слов. Тестирование слухоречевой памяти.
 */
public class TestingEnterSoundNWordsFragment extends Fragment implements INavigation {
    private Button button;
    private static final String TAG = "TESTING_SOUND_ENTER_N_WORDS";

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
        View view = inflater.inflate(R.layout.testing_enter_fragment, container, false);

        ((TextView) view.findViewById(R.id.start_text)).setText(R.string.enter_testing_new_words);

        button = (Button) view.findViewById(R.id.button_next);
        button.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                String text = "Будте внимательны, через 5 секунд будет воспроизведена запись для " +
                        "узнования слов, если готовы нажмите Продолжить";
                AlertDialog.Builder builder = new AlertDialog.Builder(view.getContext());
                builder.setTitle(getString(R.string.important_message))
                        .setMessage(text)
                        .setIcon(R.drawable.ic_error_black_24dp)
                        .setCancelable(false).setPositiveButton(getString(R.string.yes_go),
                        new DialogInterface.OnClickListener() {

                            public void onClick(DialogInterface dialog, int id) {
                                replaceFragment("TESTING_SOUND_N_WORDS", new TestingSoundNWordsFragment());
                            }

                        })
                        .setNegativeButton(getString(R.string.cancel),
                                new DialogInterface.OnClickListener() {

                                    public void onClick(DialogInterface dialog, int id) {
                                        dialog.cancel();
                                    }

                                }
                        );
                builder.setMessage(Html.fromHtml("<font color='#000000'>" + text + "</font>"));
                AlertDialog alert = builder.create();
                alert.show();
            }
        });

        return view;
    }

    /**
     * Конструктор класса.
     */
    public TestingEnterSoundNWordsFragment() {
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
