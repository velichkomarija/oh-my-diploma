package com.velickomarija.diploma.views.pause;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ExpandableListView;
import android.widget.SimpleExpandableListAdapter;
import android.widget.TextView;

import com.velickomarija.diploma.INavigation;
import com.velickomarija.diploma.R;
import com.velickomarija.diploma.models.Algorithms;
import com.velickomarija.diploma.models.PreferencesLocal;
import com.velickomarija.diploma.views.image.TestingNextImageFragment;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class ResultTwoQuestionFragment extends Fragment implements INavigation {
    private static final String TAG = "RESULT_TWO_QUESTION";
    private TextView textView;
    private Algorithms algorithms = new Algorithms();
    // коллекция для групп
    private ArrayList<Map<String, String>> groupDataList = new ArrayList<>();
    private Map<String, String> map;
    private PreferencesLocal preferencesLocal = new PreferencesLocal();
    private String[] title = new String[]{"Предметно-действенное мышление",
            "Абстрактно-символическое мышление",
            "Словесно-логическое мышление",
            "Наглядно-образное мышление",
            "Креативность (творческое мышление)"};

    private Button button;

    public ResultTwoQuestionFragment() {

    }

    /**
     * Метод-обработчик нажатия на физическую кнопку "Назад".
     */
    public void onBackPressed() {
        // do nothing
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.result_two_question_fragment, container, false);

        textView = view.findViewById(R.id.question_result);
        final String result = preferencesLocal.getProperty("PREF_RESULT_SECOND_QUESTION");
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
                getContext(),
                groupDataList,
                R.layout.list_item,
                groupFrom,
                groupTo,
                сhildDataList,
                R.layout.list_item_chld,
                childFrom,
                childTo);

        ExpandableListView expandableListView = (ExpandableListView) view.findViewById(R.id.expListView);
        expandableListView.setAdapter(adapter);

        button = view.findViewById(R.id.btn_last_test);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                replaceFragment("NEXT_IMAGE", new TestingNextImageFragment());
            }
        });
        return view;
    }

    @Override
    public void replaceFragment(String tag, Fragment fragment) {
        FragmentTransaction fragmentTransaction = getActivity().getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.container, fragment, tag);
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commitAllowingStateLoss();
    }
}
