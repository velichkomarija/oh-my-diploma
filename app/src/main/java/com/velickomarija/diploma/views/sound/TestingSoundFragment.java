package com.velickomarija.diploma.views.sound;

import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AlertDialog;
import android.text.Html;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.velickomarija.diploma.INavigation;
import com.velickomarija.diploma.R;
import com.velickomarija.diploma.models.Algorithms;
import com.velickomarija.diploma.models.Constants;
import com.velickomarija.diploma.models.PreferencesLocal;
import com.velickomarija.diploma.views.image.TestingEnterImageFragment;
import com.velickomarija.diploma.views.image.TestingImageVariantFragment;

/**
 * Класс, отвечающий за отрисовку фрагмента тестирования слухоречевой памяти.
 */
public class TestingSoundFragment extends Fragment implements INavigation {
    private static final String TAG = "TESTING_SOUND";

    private PreferencesLocal preferencesLocal = new PreferencesLocal();
    private Algorithms algorithms = new Algorithms();
    private TextView textView;
    private EditText editText;
    private Button button;

    /**
     * Конструктор класса.
     */
    public TestingSoundFragment() {
    }

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
        View view = inflater.inflate(R.layout.testing_with_input_field_fragment, container, false);

        textView = (TextView) view.findViewById(R.id.text_sound_repeat);
        editText = (EditText) view.findViewById(R.id.edit_text_result_test1);

        button = (Button) view.findViewById(R.id.button_next);

        String property = preferencesLocal.getProperty(Constants.PREF_NUM_SOUND);

        if (property.equals("5")) {
            textView.setText(R.string.text_new_words);
        }
        if (property.equals("4") ||
                property.equals("6")) {
            textView.setText(R.string.text_sound_last);
        }

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onClickToGoTestingNextSound(view);
            }
        });
        return view;
    }

    /**
     * Метод-обработчик нажатия на кнопку "Продолжить".
     * Осуществляет переход к следующемй этапу тестирования слухоречевой памяти.
     *
     * @param view объект класса View.
     */
    private void onClickToGoTestingNextSound(View view) {

        int numParam = 1;

        if (!(preferencesLocal.getProperty(Constants.PREF_NUM_SOUND).equals("none"))) {
            try {
                numParam = Integer.parseInt(preferencesLocal.getProperty(Constants.PREF_NUM_SOUND));
            } catch (Exception e) {
                Toast toast = Toast.makeText(getContext(),
                        preferencesLocal.getProperty(Constants.PREF_NUM_SOUND),
                        Toast.LENGTH_LONG);
                toast.show();
            }
        }

        String text = editText.getText().toString();
        Log.d(TAG, "Input text: " + text);
        int res = algorithms.algorithmSoundMemoryC1(text, getContext());//верно
        String resString = String.valueOf(res);

        if (numParam == 6) {
            preferencesLocal.addProperty(Constants.PREF_SOUNDLASTRESULT2,
                    resString,
                    getContext());

            preferencesLocal.addProperty(Constants.PREF_C5,
                    initResString(resString),
                    getContext());

            showDialogSound(new TestingImageVariantFragment(),
                    "TESTING_IMAGE_VARIANT",
                    getString(R.string.message_title),
                    view,
                    "7");
        }

        if (numParam == 5) {

            resString = algorithms.algorithmSoundNewWords(text);
            if (resString.equals("11") || resString.equals("12")) {
                resString = "10";
            }
            preferencesLocal.addProperty(Constants.PREF_C4,
                    resString,
                    getContext());

            showDialogSound(new TestingImageVariantFragment(),
                    "TESTING_IMAGE_VARIANT",
                    getString(R.string.message_title),
                    view,
                    "6");
        }

        if (numParam == 4) {

            preferencesLocal.addProperty(Constants.PREF_SOUNDLASTRESULT1,
                    resString,
                    getContext());

            showDialogSound(new TestingEnterSoundNWordsFragment(),
                    "TESTING_SOUND_ENTER_N_WORDS",
                    getString(R.string.message_title),
                    view,
                    "5");
        }

        if (numParam == 3) {
            preferencesLocal.addProperty(Constants.PREF_SOUNDRESULT3,
                    resString,
                    getContext());

            String par1 = preferencesLocal.getProperty(Constants.PREF_SOUNDRESULT1);
            String par2 = preferencesLocal.getProperty(Constants.PREF_SOUNDRESULT2);
            String par3 = preferencesLocal.getProperty(Constants.PREF_SOUNDRESULT3);

            String result = algorithms.algorithmSoundMemoryC2(par1, par2, par3);

            preferencesLocal.addProperty(Constants.PREF_C2,
                    result,
                    getContext());

            preferencesLocal.addProperty(Constants.PREF_NUM_IMAGE,
                    "2",
                    getContext());

            showDialogSound(new TestingEnterImageFragment(),
                    "TESTING_ENTER_IMAGE",
                    getString(R.string.message_title),
                    view,
                    "4");
        }

        if (numParam == 2) {

            preferencesLocal.addProperty(Constants.PREF_SOUNDRESULT2,
                    resString,
                    getContext());

            showDialogSound(new TestingEnterSoundFragment(),
                    "TESTING_ENTER_SOUND",
                    getString(R.string.message_title),
                    view,
                    "3");
        }

        if (numParam == 1) {

            preferencesLocal.addProperty(Constants.PREF_C1,
                    initResString(resString),
                    getContext());

            preferencesLocal.addProperty(Constants.PREF_SOUNDRESULT1,
                    resString,
                    getContext());

            showDialogSound(new TestingEnterSoundFragment(),
                    "TESTING_ENTER_SOUND",
                    getString(R.string.message_title),
                    view,
                    "2");
        }
    }

    /**
     * Метод-обработчик нажатия на физическую кнопку "Назад".
     */
    public void onBackPressed() {
        // do nothing
    }

    /**
     * Метод для корректировки первичного результата тестирования.
     *
     * @param res
     * @return
     */
    private String initResString(String res) {
        if (res.equals("11")) {
            return "10";
        }
        return res;
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

    /**
     * Метод, отображающий окно-подтверждение на действие пользователя при тестировании слухоречевой памяти.
     *
     * @param fragment объект класса Fragment.
     * @param tag      тег франмента перехода.
     * @param text     текст сообщения-подтверждения.
     * @param view     объект класса View.
     * @param num      идентификатор следующей пробы.
     */
    public void showDialogSound(final Fragment fragment, final String tag, String text, final View view, final String num) {
        AlertDialog.Builder builder = new AlertDialog.Builder(view.getContext());
        builder.setTitle(getString(R.string.important_message))
                .setMessage(text)
                .setIcon(R.drawable.ic_error_black_24dp)
                .setCancelable(false).setPositiveButton(getString(R.string.yes_go),
                new DialogInterface.OnClickListener() {

                    public void onClick(DialogInterface dialog, int id) {
                        // dialog.cancel();
                        PreferencesLocal preferencesLocal = new PreferencesLocal();
                        preferencesLocal.addProperty(Constants.PREF_NUM_SOUND,
                                num,
                                view.getContext());
                        replaceFragment(tag, fragment);

                    }
                })
                .setNegativeButton(R.string.cancel,
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
}
