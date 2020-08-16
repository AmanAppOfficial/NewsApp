package e.aman.newslatest;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ProgressBar;

import com.squareup.picasso.BuildConfig;

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

    private void loadData(NewsViewModel newsViewModel, RecyclerView recyclerView) {    //load data into recycler view based on type or category seleccted
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
        else if(type.equals(Constants.CATEGORY_TECHNOLOGY))
        {
            newsViewModel.getTech().observe(MainActivity.this, new Observer<List<Articles>>() {
                @Override
                public void onChanged(List<Articles> articles) {
                    progressBar.setVisibility(View.INVISIBLE);
                    adapter = new Newsdapter(articles , MainActivity.this);
                    recyclerView.setAdapter(adapter);

                }
            });
        }


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
                //e.toString();
            }

            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
