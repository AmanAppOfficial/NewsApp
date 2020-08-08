package e.aman.newslatest;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

import e.aman.newslatest.adapter.SelectionAdapter;
import e.aman.newslatest.utils.Constants;

public class SelectionActivity extends AppCompatActivity {

    private List choiceList = new ArrayList<>();
    private SelectionAdapter selectionAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_selection);

        loadSelectionList();

        RecyclerView selectionRecyclerView = findViewById(R.id.recyclerview_selection);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(SelectionActivity.this);
        selectionRecyclerView.setLayoutManager(linearLayoutManager);

        selectionAdapter = new SelectionAdapter(choiceList , SelectionActivity.this);
        selectionRecyclerView.setAdapter(selectionAdapter);



    }

    private void loadSelectionList() {
        choiceList.add("Top Headlines");
        choiceList.add("India's Latest");
        choiceList.add(Constants.CATEGORY_ENTERTAINMENT);
        choiceList.add(Constants.CATEGORY_SPORTS);
        choiceList.add(Constants.CATEGORY_BUSINESS);
    }
}
