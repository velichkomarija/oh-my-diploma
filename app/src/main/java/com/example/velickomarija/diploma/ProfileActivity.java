package com.example.velickomarija.diploma;

import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Toast;

public class ProfileActivity extends AppCompatActivity {

    RadioGroup radioGroup;
    PreferencesLocal pref = new PreferencesLocal();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        radioGroup = (RadioGroup) findViewById(R.id.radioGroup);
        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId) {
                    case -1:
                        Toast.makeText(getApplicationContext(), "Ничего не выбрано",
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

    // щелчок кнопки
    public void onClick(View view) {
        // очистить все переключатели
        radioGroup.clearCheck();
    }

    private boolean saveName(View view) {
        //получаем ФИО
        boolean flag = true;
        EditText nameBox = (EditText) findViewById(R.id.nameInputField);
        try {
            String name = nameBox.getText().toString();
            if (name.equals(null) || name.equals("")) {
                throw new Exception();
            }
            pref.addProperty("PREF_NAME", name, ProfileActivity.this);
        } catch (Exception e) {
            showDialog(view, "Поле ФИО заполнено некорректно!");
            flag = false;
        }
        return flag;
    }

    private void saveMale(String text) {
        pref.addProperty("PREF_MALE", text, ProfileActivity.this);
    }


    private boolean saveAge(View view) {
        //получаем возраст
        boolean flag = true;
        EditText ageBox = (EditText) findViewById(R.id.ageInputField);
        String stringAge = ageBox.getText().toString();
        try {
            Integer age = Integer.parseInt(stringAge);
            if (age <= 0 || age > 100) {
                throw new Exception();
            }
            pref.addProperty("PREF_AGE", stringAge, ProfileActivity.this);
        } catch (Exception e) {
            showDialog(view, "Поле Возраст заполнено некорректно");
            flag = false;
        }
        return flag;
    }

    private boolean saveEducation(View view) {
        //получаем образование
        boolean flag = true;
        EditText educationBox = (EditText) findViewById(R.id.educationInputField);
        try {
            String education = educationBox.getText().toString();
            if (education.equals(null) || education.equals("")) {
                throw new Exception();
            }
            pref.addProperty("PREF_EDUCATION", education, ProfileActivity.this);
        } catch (Exception e) {
            showDialog(view, "Поле Образование не заполнено");
            flag = false;
        }
        return flag;
    }

    public void onClickToRegistrProfile(View view) {
        view.setClickable(false);
        //view.setBackgroundColor(Color.GRAY);
        boolean nameFlag = saveName(view);
        boolean ageFlag = saveAge(view);
        boolean educationFlag = saveEducation(view);
        if (nameFlag == true && ageFlag == true && educationFlag == true) {
            Intent intent = new Intent(this, TestingEnterSoundActivity.class);
            startActivity(intent);
        }
        view.setClickable(true);
        //view.setBackgroundColor(Color.parseColor("#37bc51"));
    }

    //диалоговое окно на ошибку
    private void showDialog(View v, String text) {
        AlertDialog.Builder builder = new AlertDialog.Builder(ProfileActivity.this);
        builder.setTitle("Важное сообщение!")
                .setMessage(text)
                .setIcon(R.drawable.ic_error_black_24dp)
                .setCancelable(false)
                .setNegativeButton("ОК",
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                dialog.cancel();
                            }
                        });
        AlertDialog alert = builder.create();
        alert.show();
    }
}
