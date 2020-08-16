package e.aman.newslatest.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import e.aman.newslatest.MainActivity;
import e.aman.newslatest.R;

public class SelectionAdapter extends RecyclerView.Adapter<SelectionAdapter.MyViewHolder>
{

    List<String> choiceList;
    Context context;
    int lastPosition = -1;


    public SelectionAdapter(List<String> choiceList, Context context) {
        this.choiceList = choiceList;
        this.context = context;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new MyViewHolder(LayoutInflater.from(context).inflate(R.layout.selection_row , parent , false));
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {

        holder.choiceText.setText(choiceList.get(position));

        setImage(position , holder);

        holder.cardView.setOnClickListener(v -> {
            Intent i = new Intent(context , MainActivity.class);
            i.putExtra("type" , choiceList.get(position));
            context.startActivity(i);
        });

        if(position >lastPosition) {

            Animation animation = AnimationUtils.loadAnimation(context,
                    R.anim.item_animation_swipe_right);
            holder.itemView.startAnimation(animation);
            lastPosition = position;
        }

    }

    private void setImage(int position, MyViewHolder holder) {
        if(position == 0)
            holder.selectionImage.setImageResource(R.drawable.top);
        else if(position == 1)
            holder.selectionImage.setImageResource(R.drawable.ind);
        else if(position == 2)
            holder.selectionImage.setImageResource(R.drawable.entertainment);
        else if(position == 3)
            holder.selectionImage.setImageResource(R.drawable.sport);
        else if(position == 4)
            holder.selectionImage.setImageResource(R.drawable.business);
        else if(position == 5)
            holder.selectionImage.setImageResource(R.drawable.tech);


    }

    @Override
    public int getItemCount() {
        return choiceList.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder
    {
        private TextView choiceText;
        private CardView cardView;
        private ImageView selectionImage;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            choiceText = itemView.findViewById(R.id.choiceTextView);
            cardView = itemView.findViewById(R.id.choiceCard);
            selectionImage = itemView.findViewById(R.id.selection_image);

        }
    }
}
