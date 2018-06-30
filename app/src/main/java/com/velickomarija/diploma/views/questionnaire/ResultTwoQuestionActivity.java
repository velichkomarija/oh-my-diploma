package com.velickomarija.diploma.views.questionnaire;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ExpandableListView;
import android.widget.SimpleExpandableListAdapter;
import android.widget.TextView;

import com.velickomarija.diploma.R;
import com.velickomarija.diploma.models.Algorithms;
import com.velickomarija.diploma.models.TextUtils;
import com.velickomarija.diploma.views.image.TestingNextImageActivity;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * Класс-активность для отображения результаов второго опросника.
 */
public class ResultTwoQuestionActivity extends AppCompatActivity {

    private TextView textView;
    private Algorithms algorithms = new Algorithms();
    // коллекция для групп
    private ArrayList<Map<String, String>> groupDataList = new ArrayList<>();
    private Map<String, String> map;
    private String[] title = new String[]{"Предметно-действенное мышление",
            "Абстрактно-символическое мышление",
            "Словесно-логическое мышление",
            "Наглядно-образное мышление",
            "Креативность (творческое мышление)"};

    /**
     * Метод-обработчик нажатия на физическую кнопку "Назад".
     */
    public void onBackPressed() {
        // do nothing
    }

    /**
     * Метод, вызываемый перед началом работы активности.
     *
     * @param savedInstanceState объект тпа Bundle, который может хранить состояние приложения
     *                           при перерисовке активности.
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result_two_question);

        textView = (TextView) findViewById(R.id.question_result);
        float size = TextUtils.setNewTextSize(getBaseContext());
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

    /**
     * Метод-обработчик нажатия на кнопку "Продолжить".
     *
     * @param view объект класса View.
     */
    public void onClickToGo(View view) {
        Intent intent = new Intent(this, TestingNextImageActivity.class);
        startActivity(intent);
    }
}

