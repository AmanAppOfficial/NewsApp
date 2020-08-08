package e.aman.newslatest.adapter;

import android.content.Context;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import java.util.List;

import e.aman.newslatest.R;
import e.aman.newslatest.model.Articles;


public class Newsdapter extends RecyclerView.Adapter<Newsdapter.MyViewHolder>
{

    private List<Articles> articlesList;
    private Context context;
    int lastPosition = -1;


    public Newsdapter(List<Articles> articlesList, Context context) {
        this.articlesList = articlesList;
        this.context = context;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new MyViewHolder( LayoutInflater.from(context).inflate(R.layout.news_row , parent , false));
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {

        if(articlesList.get(position).getDescription()!=null)
        holder.contentTextView.setText(articlesList.get(position).getDescription());
        if(articlesList.get(position).getTitle()!=null)
        holder.titleTextView.setText(articlesList.get(position).getTitle());
        if(articlesList.get(position).getUrlToImage()!=null)
        Picasso.get().load(Uri.parse(articlesList.get(position).getUrlToImage())).into(holder.imageView);

        if(position >lastPosition) {

            Animation animation = AnimationUtils.loadAnimation(context,
                    R.anim.item_animation_swipe_right);
            holder.itemView.startAnimation(animation);
            lastPosition = position;
        }

    }

    @Override
    public int getItemCount() {
        return articlesList.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder
    {
        private ImageView imageView;
        private TextView titleTextView , contentTextView;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            imageView = itemView.findViewById(R.id.image);
            titleTextView = itemView.findViewById(R.id.title);
            contentTextView = itemView.findViewById(R.id.content);
        }
    }
}
