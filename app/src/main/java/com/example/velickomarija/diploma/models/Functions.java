package com.example.velickomarija.diploma.models;

import android.content.DialogInterface;
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
}
