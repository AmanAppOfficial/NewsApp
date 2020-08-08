package e.aman.newslatest.service;

import android.util.Log;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import java.util.List;

import e.aman.newslatest.model.Articles;
import e.aman.newslatest.model.News;
import e.aman.newslatest.utils.Constants;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class NewsRepository {
    public static final String BASE_URL = "https://newsapi.org";
    public static final String API_KEY = "e320ab727229441bb2f05eb88a6ded7d";
    private static Retrofit retrofit = null;
    final MutableLiveData<List<Articles>> articles = new MutableLiveData<>();


    public static Retrofit getRetrofitClient() {
        if (retrofit == null) {
            retrofit = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return retrofit;
    }


    public LiveData<List<Articles>> getTopHeadlines()
    {
        getRetrofitClient().create(NewsApi.class).getTopHeadlines(
                "google-news-in",
                API_KEY
        ).enqueue(new Callback<News>() {
            @Override
            public void onResponse(Call<News> call, Response<News> response) {

                List<Articles> newsList = response.body().getArticles();
                articles.setValue(newsList);

            }

            @Override
            public void onFailure(Call<News> call, Throwable t) {
                Log.e("error : " , t.getMessage());
            }
        });

        return articles;
    }

    public LiveData<List<Articles>> getIndiasLatest()
    {
        getRetrofitClient().create(NewsApi.class).getIndiasLatest(
                "in",
                API_KEY
        ).enqueue(new Callback<News>() {
            @Override
            public void onResponse(Call<News> call, Response<News> response) {

                List<Articles> newsList = response.body().getArticles();
                articles.setValue(newsList);

            }

            @Override
            public void onFailure(Call<News> call, Throwable t) {
                Log.e("error : " , t.getMessage());
            }
        });

        return articles;
    }

    public LiveData<List<Articles>> getEntertainment()
    {
        getRetrofitClient().create(NewsApi.class).getCategoryData(
                "in",
                Constants.CATEGORY_ENTERTAINMENT,
                API_KEY
        ).enqueue(new Callback<News>() {
            @Override
            public void onResponse(Call<News> call, Response<News> response) {

                List<Articles> newsList = response.body().getArticles();
                articles.setValue(newsList);

            }

            @Override
            public void onFailure(Call<News> call, Throwable t) {
                Log.e("error : " , t.getMessage());
            }
        });

        return articles;
    }

    public LiveData<List<Articles>> getSports()
    {
        getRetrofitClient().create(NewsApi.class).getCategoryData(
                "in",
                Constants.CATEGORY_SPORTS,
                API_KEY
        ).enqueue(new Callback<News>() {
            @Override
            public void onResponse(Call<News> call, Response<News> response) {

                List<Articles> newsList = response.body().getArticles();
                articles.setValue(newsList);

            }

            @Override
            public void onFailure(Call<News> call, Throwable t) {
                Log.e("error : " , t.getMessage());
            }
        });

        return articles;
    }

    public LiveData<List<Articles>> getBusiness()
    {
        getRetrofitClient().create(NewsApi.class).getCategoryData(
                "in",
                Constants.CATEGORY_BUSINESS,
                API_KEY
        ).enqueue(new Callback<News>() {
            @Override
            public void onResponse(Call<News> call, Response<News> response) {

                List<Articles> newsList = response.body().getArticles();
                articles.setValue(newsList);

            }

            @Override
            public void onFailure(Call<News> call, Throwable t) {
                Log.e("error : " , t.getMessage());
            }
        });

        return articles;
    }

}
