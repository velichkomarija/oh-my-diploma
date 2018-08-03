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
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.velickomarija.diploma.INavigation;
import com.velickomarija.diploma.R;
import com.velickomarija.diploma.models.Algorithms;
import com.velickomarija.diploma.models.PreferencesLocal;
import com.velickomarija.diploma.views.image.TestingEnterImageFragment;
import com.velickomarija.diploma.views.image.TestingImageVariantFragment;
import com.velickomarija.diploma.views.questionnaire.QuestionEnterFragment;

public class TestingSoundFragment extends Fragment implements INavigation {
    private static final String TAG = "TESTING_SOUND";

    private PreferencesLocal preferencesLocal = new PreferencesLocal();
    private Algorithms algorithms = new Algorithms();

    private TextView textView;
    private EditText editText;
    private Button button;

    public TestingSoundFragment() {
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.testing_with_input_field_fragment, container, false);

        textView = (TextView) view.findViewById(R.id.text_sound_repeat);
        editText = (EditText) view.findViewById(R.id.edit_text_result_test1);

        button = (Button) view.findViewById(R.id.button_next);

        if (preferencesLocal.getProperty("PREF_NUM_SOUND").equals("5")) {
            textView.setText(R.string.text_new_words);
        }
        if (preferencesLocal.getProperty("PREF_NUM_SOUND").equals("4")) {
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

    private void onClickToGoTestingNextSound(View view) {

        int numParam = 1;

        if (!(preferencesLocal.getProperty("PREF_NUM_SOUND").equals("none"))) {
            try {
                numParam = Integer.parseInt(preferencesLocal.getProperty("PREF_NUM_SOUND"));
            } catch (Exception e) {
                Toast toast = Toast.makeText(getContext(),
                        preferencesLocal.getProperty("PREF_NUM_SOUND"),
                        Toast.LENGTH_LONG);
                toast.show();
            }
        }

        String text = editText.getText().toString();
        int res = algorithms.algorithmSoundMemoryC1(text, getContext());//верно
        String resString = String.valueOf(res);

        if (numParam == 5) {

            resString = algorithms.algorithmSoundNewWords(text);
            if (resString.equals("11") || resString.equals("12")) {
                resString = "10";
            }
            preferencesLocal.addProperty("PREF_C4",
                    resString,
                    getContext());

            showDialogSound(new TestingImageVariantFragment(),
                    "TESTING_IMAGE_VARIANT",
                    "Вы уверены в ответе?",
                    view,
                    "6");
        }

        if (numParam == 4) {

            preferencesLocal.addProperty("PREF_SOUNDLASTRESULT1",
                    resString,
                    getContext());

            preferencesLocal.addProperty("PREF_C5",
                    initResString(resString),
                    getContext());

            showDialogSound(new QuestionEnterFragment(),
                    "QUESTION_ENTER",
                    "Вы уверены в ответе?",
                    view,
                    "5");
        }

        if (numParam == 3) {
            preferencesLocal.addProperty("PREF_SOUNDRESULT3",
                    resString,
                    getContext());

            String par1 = preferencesLocal.getProperty("PREF_SOUNDRESULT1");
            String par2 = preferencesLocal.getProperty("PREF_SOUNDRESULT2");
            String par3 = preferencesLocal.getProperty("PREF_SOUNDRESULT3");

            String result = algorithms.algorithmSoundMemoryC2(par1, par2, par3);

            preferencesLocal.addProperty("PREF_C2",
                    result,
                    getContext());

            preferencesLocal.addProperty("PREF_NUM_IMAGE",
                    "2",
                    getContext());

            showDialogSound(new TestingEnterImageFragment(),
                    "TESTING_ENTER_IMAGE",
                    "Вы уверены в ответе?",
                    view,
                    "4");
        }

        if (numParam == 2) {

            preferencesLocal.addProperty("PREF_SOUNDRESULT2",
                    resString,
                    getContext());

            showDialogSound(new TestingEnterSoundFragment(),
                    "TESTING_ENTER_SOUND",
                    "Вы уверены в ответе?",
                    view,
                    "3");
        }

        if (numParam == 1) {

            preferencesLocal.addProperty("PREF_C1",
                    initResString(resString),
                    getContext());

            preferencesLocal.addProperty("PREF_SOUNDRESULT1",
                    resString,
                    getContext());

            showDialogSound(new TestingEnterSoundFragment(),
                    "TESTING_ENTER_SOUND",
                    "Вы уверены в ответе?",
                    view,
                    "2");
        }
    }

    public void onBackPressed() {
        // do nothing
    }

    private String initResString(String res) {
        if (res.equals("11")) {
            return "10";
        }
        return res;
    }

    @Override
    public void replaceFragment(String tag, Fragment fragment) {
        FragmentTransaction fragmentTransaction = getActivity().getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.container, fragment, tag);
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commitAllowingStateLoss();
    }

    public void showDialogSound(final Fragment fragment, final String tag, String text, final View view, final String num) {
        AlertDialog.Builder builder = new AlertDialog.Builder(view.getContext());
        builder.setTitle("Важное сообщение!")
                .setMessage(text)
                .setIcon(R.drawable.ic_error_black_24dp)
                .setCancelable(false).setPositiveButton("Да, продолжить",
                new DialogInterface.OnClickListener() {

                    public void onClick(DialogInterface dialog, int id) {
                        // dialog.cancel();
                        PreferencesLocal preferencesLocal = new PreferencesLocal();
                        preferencesLocal.addProperty("PREF_NUM_SOUND",
                                num,
                                view.getContext());
                        replaceFragment(tag, fragment);

                    }
                })
                .setNegativeButton("Отмена",
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
