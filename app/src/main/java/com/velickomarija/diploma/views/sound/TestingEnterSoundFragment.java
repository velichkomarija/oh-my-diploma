package com.velickomarija.diploma.views.sound;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.velickomarija.diploma.INavigation;
import com.velickomarija.diploma.R;
import com.velickomarija.diploma.models.Constants;
import com.velickomarija.diploma.models.PreferencesLocal;

/**
 * Класс, отвечающий за отрисовку фрагмента инструкции к этапу тестирования слухоречевой памяти.
 */
public class TestingEnterSoundFragment extends Fragment implements INavigation {
    private static final String TAG = "TESTING_ENTER_SOUND";

    private MediaPlayer mPlayer;
    private Button startButton;
    private ImageView image;
    private PreferencesLocal preferencesLocal = new PreferencesLocal();
    private TextView textNotation;

    /**
     * Конструктор класса.
     */
    public TestingEnterSoundFragment() {
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
        View view = inflater.inflate(R.layout.testing_enter_fragment, container, false);

        textNotation = (TextView) view.findViewById(R.id.start_text);
        startButton = (Button) view.findViewById(R.id.button_next);
        image = (ImageView) view.findViewById(R.id.image_sound);

        if (preferencesLocal.getProperty(Constants.PREF_NUM_SOUND).equals("2") ||
                preferencesLocal.getProperty(Constants.PREF_NUM_SOUND).equals("3")) {
            textNotation.setText(R.string.enter_testing_manifest_sound);
        } else {
            textNotation.setText(R.string.enter_testing_manifest);
        }

        startButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startButton.setEnabled(false);
                startButton.setVisibility(View.GONE);
                textNotation.setVisibility(View.GONE);
                image.setVisibility(View.VISIBLE);

                if (preferencesLocal.getProperty(Constants.PREF_NUM_SOUND).equals("2") ||
                        preferencesLocal.getProperty(Constants.PREF_NUM_SOUND).equals("3")) {
                    sound(R.raw.test_15sec, 15500);
                } else {
                    sound(R.raw.test_20sec, 20500);
                }
            }
        });

        return view;
    }

    /**
     * Метод-обработчик нажатия на физическую кнопку "Назад".
     */
    public void onBackPressed() {
        // do nothing
    }

    /**
     * Метод для воспроизведения аудиозаписи со словами для запоминания.
     *
     * @param sound аудиозапись со словами.
     * @param time  время воспроизведения аудиозаписи.
     */
    public void sound(int sound, long time) {
        mPlayer = MediaPlayer.create(getContext(), sound);
        mPlayer.start();
        //  textNotation.setText("Воспроизведение аудиозаписи");
        //  textNotation.setTextSize(TextUtils.setNewTextSize(getContext()) * 3);

        CountDownTimer start = new CountDownTimer(time, 500) {
            int countSound = 1;

            public void onTick(long milliesUntilFinished) {
                //do nothing
                if (countSound == 3) {
                    image.setImageResource(R.mipmap.ic_sound_finish);
                    countSound = 1;
                } else if (countSound == 2) {
                    image.setImageResource(R.mipmap.ic_sound_next);
                    countSound = 3;
                } else {
                    image.setImageResource(R.mipmap.ic_sound);
                    countSound = 2;
                }
            }

            public void onFinish() {
                replaceFragment("TESTING_SOUND", new TestingSoundFragment());
            }

        }.start();
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
