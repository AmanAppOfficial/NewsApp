package e.aman.newslatest.service;


import e.aman.newslatest.model.News;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface NewsApi
{
    @GET("/v2/top-headlines")
    Call<News> getTopHeadlines(
            @Query("sources") String sources,
            @Query("apiKey") String apiKey
    );

    @GET("/v2/top-headlines")
    Call<News> getIndiasLatest(
            @Query("country") String country,
            @Query("apiKey") String apiKey
    );

    @GET("/v2/top-headlines")
    Call<News> getCategoryData(
            @Query("country") String country,
            @Query("category") String category,
            @Query("apiKey") String apiKey
    );



}
