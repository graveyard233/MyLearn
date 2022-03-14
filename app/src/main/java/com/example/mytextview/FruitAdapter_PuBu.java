package com.example.mytextview;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class FruitAdapter_PuBu extends RecyclerView.Adapter<FruitAdapter_PuBu.ViewHolder>{

    private List<Fruit> myFruit;

    public FruitAdapter_PuBu(List<Fruit> myFruit) {
        this.myFruit = myFruit;
    }

    static class ViewHolder extends RecyclerView.ViewHolder{
        View fruitView;
        ImageView imageView;
        TextView textView;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            fruitView = itemView;
            imageView = itemView.findViewById(R.id.fruitImage2);
            textView = itemView.findViewById(R.id.fruitName2);
        }
    }

    @NonNull
    @Override
    public FruitAdapter_PuBu.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.fruit_item_pubu,parent,false);
        final ViewHolder viewHolder = new ViewHolder(view);
        viewHolder.fruitView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int position = viewHolder.getAbsoluteAdapterPosition();
                Fruit fruit = myFruit.get(position);
                Toast.makeText(view.getContext(),
                        "你点了" + fruit.getName(),Toast.LENGTH_SHORT).show();
            }
        });
        viewHolder.imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int position = viewHolder.getAbsoluteAdapterPosition();
                Fruit fruit = myFruit.get(position);
                Toast.makeText(view.getContext(),
                        "你点了图片" + fruit.getName(),Toast.LENGTH_SHORT).show();
            }
        });
        return  viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull FruitAdapter_PuBu.ViewHolder holder, int position) {
        Fruit fruit = myFruit.get(position);
        holder.textView.setText(fruit.getName());
        holder.imageView.setImageResource(fruit.getImageId());
    }

    @Override
    public int getItemCount() {
        return myFruit.size();
    }


}
