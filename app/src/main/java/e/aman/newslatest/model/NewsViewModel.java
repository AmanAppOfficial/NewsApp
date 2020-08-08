package e.aman.newslatest.model;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import java.util.List;

import e.aman.newslatest.service.NewsRepository;

public class NewsViewModel extends ViewModel
{
    private LiveData<List<Articles>> liveCoupon;
    private NewsRepository newsRepository = new NewsRepository();

    public LiveData<List<Articles>> getTopHeadlines()
    {
        if (liveCoupon == null)
        {
            liveCoupon = newsRepository.getTopHeadlines();
        }
        return liveCoupon;
    }

    public LiveData<List<Articles>> getIndiasLatest()
    {
        if (liveCoupon == null)
        {
            liveCoupon = newsRepository.getIndiasLatest();
        }
        return liveCoupon;
    }

    public LiveData<List<Articles>> getEntertainment()
    {
        if (liveCoupon == null)
        {
            liveCoupon = newsRepository.getEntertainment();
        }
        return liveCoupon;
    }

    public LiveData<List<Articles>> getSports()
    {
        if (liveCoupon == null)
        {
            liveCoupon = newsRepository.getSports();
        }
        return liveCoupon;
    }

    public LiveData<List<Articles>> getBusiness()
    {
        if (liveCoupon == null)
        {
            liveCoupon = newsRepository.getBusiness();
        }
        return liveCoupon;
    }


}
