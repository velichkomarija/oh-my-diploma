package com.example.velickomarija.diploma.models;

import android.content.Context;
import android.net.Uri;
import android.support.annotation.NonNull;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;

import java.io.File;
import java.io.FileWriter;

public class ResultCreator {

    public static void generateFileResult(Context context) {
        File fileName = null;
        String sdState = android.os.Environment.getExternalStorageState();
        if (sdState.equals(android.os.Environment.MEDIA_MOUNTED)) {
            File sdDir = android.os.Environment.getExternalStorageDirectory();
            fileName = new File(sdDir, "cache/result.txt");
        } else {
            fileName = context.getCacheDir();
        }
        if (!fileName.exists())
            fileName.mkdirs();
        try {
            FileWriter f = new FileWriter(fileName);
            f.write(generateFullResult());
            f.flush();
            f.close();
            Uri file = Uri.fromFile(fileName);
            sendFile("cache/result.txt", file);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static String generateFullResult() {
        StringBuffer stringBuffer = new StringBuffer();
        PreferencesLocal preferencesLocal = new PreferencesLocal();
        stringBuffer.append("Информация о тестируемом:")
                .append(preferencesLocal.getProperty("PREF_NAME") + "/")
                .append(preferencesLocal.getProperty("PREF_AGE") + "/")
                .append(preferencesLocal.getProperty("PREF_EDUCATION"))
                .append(preferencesLocal.getProperty("PREF_ETC_INFORMATION"))
                .append("\n\n");

        stringBuffer.append("Результаты тестирования слухоречевой памяти: \n")
                .append("Параметр C1: ")
                .append(preferencesLocal.getProperty("PREF_C1"))
                .append("\n")
                .append("Параметр C2: ")
                .append(preferencesLocal.getProperty("PREF_C2"))
                .append("\n")
                .append("Параметр C4: ")
                .append(preferencesLocal.getProperty("PREF_C4"))
                .append("\n")
                .append("Параметр C6: ")
                .append(preferencesLocal.getProperty("PREF_C6"))
                .append("\n")
                .append("Сумма: ")
                .append(preferencesLocal.getProperty("PREF_TOTAL_SOUND"))
                .append("\n\n");

        stringBuffer.append("Результаты тестирования зрительной памяти: \n")
                .append("Параметр Z1: ")
                .append(preferencesLocal.getProperty("PREF_Z1"))
                .append("\n")
                .append("Параметр Z2: ")
                .append(preferencesLocal.getProperty("PREF_Z2"))
                .append("\n")
                .append("Параметр Z4: ")
                .append(preferencesLocal.getProperty("PREF_Z4"))
                .append("\n")
                .append("Параметр Z6: ")
                .append(preferencesLocal.getProperty("PREF_Z6"))
                .append("\n")
                .append("Сумма: ")
                .append(preferencesLocal.getProperty("PREF_TOTAL_IMAGE"))
                .append("\n\n");

        stringBuffer.append("Результаты тестирования: ")
                .append(preferencesLocal.getProperty("PREF_TOTAL"));

        return stringBuffer.toString();
    }

    private static void sendFile(String file, Uri fileUri) {
        FirebaseStorage storage = FirebaseStorage.getInstance();
        StorageReference rootRef = storage.getReference();
        StorageReference mountainsRef = rootRef.child(file);
        mountainsRef.putFile(fileUri)
                .addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
                    @Override
                    public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {
                        // Get a URL to the uploaded content
                        Uri downloadUrl = taskSnapshot.getDownloadUrl();
                    }
                })
                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception exception) {
                        // Handle unsuccessful uploads
                        // ...
                    }
                });
    }
}
