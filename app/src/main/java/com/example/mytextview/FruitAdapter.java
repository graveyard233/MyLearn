package com.example.mytextview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.List;

public class FruitAdapter extends ArrayAdapter {
    private int resourceId;


    public FruitAdapter(@NonNull Context context, int textViewResourceId,
                        @NonNull List<Fruit> objects) {
        super(context, textViewResourceId, objects);
        resourceId = textViewResourceId;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        Fruit fruit = (Fruit) getItem(position);//获取当前项的fruit实例

        View view;
        if (convertView == null){
            view = LayoutInflater.from(getContext()).inflate(resourceId,parent,false);
        } else {
            view = convertView;
        }

        ImageView fruitImage = (ImageView) view.findViewById(R.id.fruitImage);
        TextView fruitName = (TextView) view.findViewById(R.id.fruitName);
        if (fruit != null){
            fruitImage.setImageResource(fruit.getImageId());
            fruitName.setText(fruit.getName());
        }

        return view;
    }
}
