package e.aman.newslatest;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.ProgressBar;

import java.util.List;

import e.aman.newslatest.adapter.Newsdapter;
import e.aman.newslatest.model.Articles;
import e.aman.newslatest.model.NewsViewModel;
import e.aman.newslatest.utils.Constants;


public class MainActivity extends AppCompatActivity {

    private NewsViewModel newsViewModel;
    private ProgressBar progressBar;
    private Newsdapter adapter;
    String type;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        type = getIntent().getExtras().getString("type");


        progressBar = findViewById(R.id.progressbar);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(MainActivity.this);
        RecyclerView recyclerView = findViewById(R.id.recyclerview);
        recyclerView.setLayoutManager(linearLayoutManager);



        newsViewModel = ViewModelProviders.of(MainActivity.this).get(NewsViewModel.class);

        loadData(newsViewModel , recyclerView);

    }

    private void loadData(NewsViewModel newsViewModel, RecyclerView recyclerView) {
        if(type.equals("Top Headlines"))
        {

            newsViewModel.getTopHeadlines().observe(MainActivity.this, new Observer<List<Articles>>() {
                @Override
                public void onChanged(List<Articles> articles) {
                    progressBar.setVisibility(View.INVISIBLE);
                    adapter = new Newsdapter(articles , MainActivity.this);
                    recyclerView.setAdapter(adapter);

                }
            });
        }
        else if(type.equals("India's Latest"))
        {
            newsViewModel.getIndiasLatest().observe(MainActivity.this, new Observer<List<Articles>>() {
                @Override
                public void onChanged(List<Articles> articles) {
                    progressBar.setVisibility(View.INVISIBLE);
                    adapter = new Newsdapter(articles , MainActivity.this);
                    recyclerView.setAdapter(adapter);

                }
            });
        }
        else if(type.equals(Constants.CATEGORY_ENTERTAINMENT))
        {
            newsViewModel.getEntertainment().observe(MainActivity.this, new Observer<List<Articles>>() {
                @Override
                public void onChanged(List<Articles> articles) {
                    progressBar.setVisibility(View.INVISIBLE);
                    adapter = new Newsdapter(articles , MainActivity.this);
                    recyclerView.setAdapter(adapter);

                }
            });
        }
        else if(type.equals(Constants.CATEGORY_SPORTS))
        {
            newsViewModel.getSports().observe(MainActivity.this, new Observer<List<Articles>>() {
                @Override
                public void onChanged(List<Articles> articles) {
                    progressBar.setVisibility(View.INVISIBLE);
                    adapter = new Newsdapter(articles , MainActivity.this);
                    recyclerView.setAdapter(adapter);

                }
            });
        }
        else if(type.equals(Constants.CATEGORY_BUSINESS))
        {
            newsViewModel.getBusiness().observe(MainActivity.this, new Observer<List<Articles>>() {
                @Override
                public void onChanged(List<Articles> articles) {
                    progressBar.setVisibility(View.INVISIBLE);
                    adapter = new Newsdapter(articles , MainActivity.this);
                    recyclerView.setAdapter(adapter);

                }
            });
        }


    }
}
