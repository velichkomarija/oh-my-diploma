package com.example.velickomarija.diploma.views.common;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.example.velickomarija.diploma.R;
import com.example.velickomarija.diploma.models.Functions;
import com.example.velickomarija.diploma.views.sound.TestingEnterSoundActivity;
import com.example.velickomarija.diploma.models.PreferencesLocal;
import com.example.velickomarija.diploma.models.TextUtils;

public class ProfileActivity extends AppCompatActivity {

    RadioGroup radioGroup;
    PreferencesLocal pref = new PreferencesLocal();
    TextView textName, textMale, textEducation, textAge, textEtc, start;
    RadioButton radioButton1, radioButton2;
    Spinner spinner;
    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        float size = TextUtils.setNewTextSize(getBaseContext());
        initParam(size);

        radioGroup = (RadioGroup) findViewById(R.id.radio_group);
        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId) {
                    case -1:
                        Toast.makeText(getApplicationContext(),
                                "Ничего не выбрано",
                                Toast.LENGTH_SHORT).show();
                        break;

                    case R.id.male:
                        saveMale("Мужской");
                        break;

                    case R.id.famale:
                        saveMale("Женский");
                        break;

                    default:
                        break;
                }
            }
        });
    }

    private void initParam(float size) {
        start = (TextView) findViewById(R.id.start_profile_text_view);
        textName = (TextView) findViewById(R.id.name_text_view);
        textMale = (TextView) findViewById(R.id.male_text_view);
        textAge = (TextView) findViewById(R.id.age_text_view);
        textEtc = (TextView) findViewById(R.id.etc_text_view);
        textEducation = (TextView) findViewById(R.id.education_text_view);

        radioButton1 = (RadioButton) findViewById(R.id.male);
        radioButton2 = (RadioButton) findViewById(R.id.famale);

        spinner = (Spinner) findViewById(R.id.education_input_field);
        spinner.setSelection(0);

        button = (Button) findViewById(R.id.next_button);

        button.setTextSize(size);
        textName.setTextSize(size);
        textMale.setTextSize(size);
        textAge.setTextSize(size);

        if (getResources().getDisplayMetrics().density >= 2.5f) {
            start.setTextSize(size);
        } else {
            start.setTextSize(size * 1.5f);
        }
        textEducation.setTextSize(size);
        textEtc.setTextSize(size);
        radioButton1.setTextSize(size);
        radioButton2.setTextSize(size);
    }

    // щелчок кнопки
    public void onClick(View view) {
        // очистить все переключатели
        radioGroup.clearCheck();
    }

    private boolean saveName(View view) {
        //получаем ФИО
        boolean flag = true;
        EditText nameBox = (EditText) findViewById(R.id.name_input_field);
        try {
            String name = nameBox.getText().toString();

            if (name.equals(null) ||
                    name.equals("")) {
                throw new Exception();
            }

            pref.addProperty("PREF_NAME",
                    name,
                    ProfileActivity.this);

        } catch (Exception e) {
            Functions.showErrorDialog(view, "Поле ФИО заполнено некорректно!");
            flag = false;
        }
        return flag;
    }

    private void saveMale(String text) {
        //получаем пол
        pref.addProperty("PREF_MALE", text, ProfileActivity.this);
    }

    private void saveEtcInformation() {
        //получаем другую информацию
        EditText etcInformationBox = (EditText) findViewById(R.id.etc_input_field);
        try {
            String etcInformation = etcInformationBox.getText().toString();

            pref.addProperty("PREF_ETC_INFORMATION",
                    etcInformation,
                    ProfileActivity.this);

        } catch (Exception e) {
            pref.addProperty("PREF_ETC_INFORMATION",
                    " ",
                    ProfileActivity.this);
        }
    }

    private boolean saveAge(View view) {
        //получаем возраст
        boolean flag = true;
        EditText ageBox = (EditText) findViewById(R.id.age_input_field);
        String stringAge = ageBox.getText().toString();

        try {
            Integer age = Integer.parseInt(stringAge);
            if (age <= 7 || age > 100) {
                throw new Exception();
            }

            pref.addProperty("PREF_AGE",
                    stringAge,
                    ProfileActivity.this);

        } catch (Exception e) {
            Functions.showErrorDialog(view, "Поле Возраст заполнено некорректно");
            flag = false;
        }
        return flag;
    }

    private void saveEducation() {
        //получаем образование
        String selected = spinner.getSelectedItem().toString();
        pref.addProperty("PREF_EDUCATION",
                selected,
                ProfileActivity.this);
    }

    public void onClickToRegistrateProfile(View view) {
        boolean nameFlag = saveName(view);
        boolean ageFlag = saveAge(view);

        saveEtcInformation();
        saveEducation();

        if (nameFlag == true && ageFlag == true) {
            Intent intent = new Intent(this, TestingEnterSoundActivity.class);
            startActivity(intent);
        }
    }
}
