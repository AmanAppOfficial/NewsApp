package e.aman.newslatest;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import com.squareup.picasso.BuildConfig;

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
        choiceList.add(Constants.CATEGORY_TECHNOLOGY);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu, menu);
        // return true so that the menu pop up is opened
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.share) {

            try {
                Intent shareIntent = new Intent(Intent.ACTION_SEND);
                shareIntent.setType("text/plain");
                shareIntent.putExtra(Intent.EXTRA_SUBJECT, "Latest News");
                String shareMessage= "\nLet me recommend you this application\n\n";
                shareMessage = shareMessage + "https://play.google.com/store/apps/details?id=" + "e.aman.newslatest" +"\n\n";
                shareIntent.putExtra(Intent.EXTRA_TEXT, shareMessage);
                startActivity(Intent.createChooser(shareIntent, "choose one"));
            } catch(Exception e) {
            }

            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
