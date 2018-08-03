package com.velickomarija.diploma.models;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.text.Html;
import android.view.View;

import com.velickomarija.diploma.R;

/**
 * Класс, определяющий базовый функционал переходов между активностями и сообщений-подсказок.
 */
public class Functions {

    /**
     * Метод, отображающий диалоговое окно в случае ошибочного действия пользователя.
     *
     * @param v    объект типа View.
     * @param text текст сообщения об ошибке.
     */
    public static void showErrorDialog(View v, String text) {
        AlertDialog.Builder builder = new AlertDialog.Builder(v.getContext());
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
        builder.setMessage(Html.fromHtml("<font color='#000000'>" + text + "</font>"));
        AlertDialog alert = builder.create();
        alert.show();
    }

    /**
     * Метод, реализующий переход к следующей активности.
     *
     * @param cl   параметр, указывающий на следующую активность для перехода.
     * @param view объект типа View.
     */
    public static void activityToGo(Class cl, View view) {
        Intent intent = new Intent(view.getContext(), cl);
        view.getContext().startActivity(intent);
    }
}
