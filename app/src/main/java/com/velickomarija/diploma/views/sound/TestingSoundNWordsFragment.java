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
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.velickomarija.diploma.INavigation;
import com.velickomarija.diploma.R;
import com.velickomarija.diploma.models.Algorithms;
import com.velickomarija.diploma.models.Constants;
import com.velickomarija.diploma.models.PreferencesLocal;

/**
 * Класс, отвечающий за отрисовку фрагмента тестирования слухоречевой памяти с новыми словами.
 */
public class TestingSoundNWordsFragment extends Fragment implements INavigation {
    private static final String TAG = "TESTING_SOUND_N_WORDS";
    private TextView mTimer;
    private MediaPlayer mPlayer;
    private Animation animation;
    private boolean clk = false;
    private Button button;
    private Algorithms algorithms = new Algorithms();
    private PreferencesLocal preferencesLocal = new PreferencesLocal();

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
        View view = inflater.inflate(R.layout.testing_sound_nwords_fragment, container, false);
        animation = AnimationUtils.loadAnimation(getContext(), R.anim.anim);
        timing(view);

        button = view.findViewById(R.id.sound_new_words_sound_btn);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                clk = true;
                view.startAnimation(animation);
            }
        });

        return view;
    }

    /**
     * Метод, расичтывающий временной интервал тестирования.
     *
     * @param view объект класса View.
     */
    private void timing(View view) {
        mTimer = (TextView) view.findViewById(R.id.text_view_time);

        final ImageView image = (ImageView) view.findViewById(R.id.image_sound);
        CountDownTimer start = new CountDownTimer(6000, 1000) {
            public void onTick(long milliesUntilFinished) {
                button.setVisibility(View.GONE);
                mTimer.setText(String.valueOf(milliesUntilFinished / 1000));
            }

            public void onFinish() {
                mTimer.setVisibility(View.GONE);
                image.setVisibility(View.VISIBLE);
                button.setVisibility(View.VISIBLE);
                soundTiming();
            }
        }.start();
    }

    /**
     * Метод для воспроизведения аудиозаписи.
     */
    private void soundTiming() {
        final StringBuffer stringBuffer = new StringBuffer();
        mPlayer = MediaPlayer.create(getContext(), R.raw.test_60sec);
        mPlayer.start();
        final CountDownTimer start = new CountDownTimer(64000, 100) {

            public void onTick(long milliesUntilFinished) {
                if (clk) {
                    clk = false;
                    stringBuffer.append(milliesUntilFinished / 10 + " ");
                }
            }

            public void onFinish() {
                String str = stringBuffer.toString();
                String res = algorithms.algorithmFindOldWordsInNew(str, getContext());
                preferencesLocal.addProperty(Constants.PREF_RESULTOLDWORDS,
                        res,
                        getContext());
                replaceFragment("TESTING_SOUND", new TestingSoundFragment());
            }
        }.start();
    }


    /**
     * Метод-обработчик нажатия на физическую кнопку "Назад".
     */
    public void onBackPressed() {
        // do nothing
    }

    /**
     * Конструктор класса.
     */
    public TestingSoundNWordsFragment() {
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
