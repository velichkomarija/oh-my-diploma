package com.example.velickomarija.diploma.models;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.text.Html;
import android.view.View;

import com.example.velickomarija.diploma.R;

public class Functions {

    //диалоговое окно на ошибку
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

    public static void showDialog(final Class cl, String text, final View view) {
        AlertDialog.Builder builder = new AlertDialog.Builder(view.getContext());
        builder.setTitle("Важное сообщение!")
                .setMessage(text)
                .setIcon(R.drawable.ic_error_black_24dp)
                .setCancelable(false).setPositiveButton("Да, продолжить",
                new DialogInterface.OnClickListener() {

                    public void onClick(DialogInterface dialog, int id) {
                        dialog.cancel();
                        activityTOGo(cl, view);
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

    //переход между активити
    public static void activityTOGo(Class cl, View view) {
        Intent intent = new Intent(view.getContext(), cl);
        view.getContext().startActivity(intent);
    }
}
