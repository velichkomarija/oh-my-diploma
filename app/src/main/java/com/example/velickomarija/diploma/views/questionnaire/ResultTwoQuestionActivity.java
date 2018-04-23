package com.example.velickomarija.diploma.views.questionnaire;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ExpandableListView;
import android.widget.SimpleExpandableListAdapter;
import android.widget.TextView;

import com.example.velickomarija.diploma.R;
import com.example.velickomarija.diploma.models.Algorithms;
import com.example.velickomarija.diploma.models.TextUtils;
import com.example.velickomarija.diploma.views.image.TestingNextImageActivity;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class ResultTwoQuestionActivity extends AppCompatActivity {

    TextView textView;
    Algorithms algorithms = new Algorithms();
    // коллекция для групп
    ArrayList<Map<String, String>> groupDataList = new ArrayList<>();
    Map<String, String> map;
    String[] title = new String[]{"Предметно-действенное мышление",
            "Абстрактно-символическое мышление",
            "Словесно-логическое мышление",
            "Наглядно-образное мышление",
            "Креативность (творческое мышление)"};

    public void onBackPressed() {
        // do nothing
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result_two_question);

        textView = (TextView) findViewById(R.id.questionResult);
        float size = TextUtils.textSize(getBaseContext());
        textView.setTextSize(size * 1.7f);
        Bundle arguments = getIntent().getExtras();
        String result = arguments.get("result").toString();

        for (String group : title) {
            // заполняем список атрибутов для каждой группы
            map = new HashMap<>();
            map.put("groupName", group);
            groupDataList.add(map);
        }
        textView.setText(result);

        // список атрибутов групп для чтения
        String groupFrom[] = new String[]{"groupName"};
        // список ID view-элементов, в которые будет помещены атрибуты групп
        int groupTo[] = new int[]{android.R.id.text1};

        // создаем общую коллекцию для коллекций элементов
        ArrayList<ArrayList<Map<String, String>>> сhildDataList = new ArrayList<>();

        // в итоге получится сhildDataList = ArrayList<сhildDataItemList>

        // создаем коллекцию элементов для первой группы
        ArrayList<Map<String, String>> сhildDataItemList = new ArrayList<>();
        map = new HashMap<>();
        map.put("name", algorithms.getResQuestion11());
        сhildDataItemList.add(map);
        сhildDataList.add(сhildDataItemList);

        сhildDataItemList = new ArrayList<>();
        map = new HashMap<>();
        map.put("name", algorithms.getResQuestion22());
        сhildDataItemList.add(map);
        сhildDataList.add(сhildDataItemList);

        // создаем коллекцию элементов для третьей группы
        сhildDataItemList = new ArrayList<>();
        map = new HashMap<>();
        map.put("name", algorithms.getResQuestion33());
        сhildDataItemList.add(map);
        сhildDataList.add(сhildDataItemList);

        сhildDataItemList = new ArrayList<>();
        map = new HashMap<>();
        map.put("name", algorithms.getResQuestion44());
        сhildDataItemList.add(map);
        сhildDataList.add(сhildDataItemList);

        сhildDataItemList = new ArrayList<>();
        map = new HashMap<>();
        map.put("name", algorithms.getResQuestion55());
        сhildDataItemList.add(map);
        сhildDataList.add(сhildDataItemList);

        // список атрибутов элементов для чтения
        String childFrom[] = new String[]{"name"};
        // список ID view-элементов, в которые будет помещены атрибуты
        // элементов
        int childTo[] = new int[]{android.R.id.text1};

        SimpleExpandableListAdapter adapter = new SimpleExpandableListAdapter(
                this, groupDataList,
                R.layout.list_item, groupFrom,
                groupTo, сhildDataList, R.layout.list_item_chld,
                childFrom, childTo);

        ExpandableListView expandableListView = (ExpandableListView) findViewById(R.id.expListView);
        expandableListView.setAdapter(adapter);
    }

    public void onClickToGo(View view) {
        Intent intent = new Intent(this, TestingNextImageActivity.class);
        startActivity(intent);
    }
}

