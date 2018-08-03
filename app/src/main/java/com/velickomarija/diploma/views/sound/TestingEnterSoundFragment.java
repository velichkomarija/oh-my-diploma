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
import android.widget.TextView;

import com.velickomarija.diploma.INavigation;
import com.velickomarija.diploma.R;
import com.velickomarija.diploma.models.PreferencesLocal;
import com.velickomarija.diploma.models.TextUtils;

public class TestingEnterSoundFragment extends Fragment implements INavigation {
    private static final String TAG = "TESTING_ENTER_SOUND";

    private MediaPlayer mPlayer;
    private Button startButton;
    private PreferencesLocal preferencesLocal = new PreferencesLocal();
    private TextView textView;

    public TestingEnterSoundFragment() {
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.testing_enter_fragment, container, false);

        textView = (TextView) view.findViewById(R.id.start_text);
        startButton = (Button) view.findViewById(R.id.button_next);

        if (preferencesLocal.getProperty("PREF_NUM_SOUND").equals("2") ||
                preferencesLocal.getProperty("PREF_NUM_SOUND").equals("3")) {
            textView.setText(R.string.enter_testing_manifest_sound);
        } else {
            textView.setText(R.string.enter_testing_manifest);
        }

        startButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startButton.setEnabled(false);
                startButton.setVisibility(View.INVISIBLE);

                if (preferencesLocal.getProperty("PREF_NUM_SOUND").equals("2") ||
                        preferencesLocal.getProperty("PREF_NUM_SOUND").equals("3")) {
                    sound(R.raw.test_15sec, 15500);
                } else {
                    sound(R.raw.test_20sec, 20500);
                }
            }
        });

        return view;
    }

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
        textView.setText("Воспроизведение аудиозаписи");
        textView.setTextSize(TextUtils.setNewTextSize(getContext()) * 3);

        CountDownTimer start = new CountDownTimer(time, 500) {

            public void onTick(long milliesUntilFinished) {
                //do nothing
            }

            public void onFinish() {
                replaceFragment("TESTING_SOUND", new TestingSoundFragment());
            }

        }.start();
    }

    @Override
    public void replaceFragment(String tag, Fragment fragment) {
        FragmentTransaction fragmentTransaction = getActivity().getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.container, fragment, tag);
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commitAllowingStateLoss();
    }
}
