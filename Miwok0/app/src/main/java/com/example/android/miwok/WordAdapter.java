package com.example.android.miwok;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;

public class WordAdapter extends ArrayAdapter<Word> {
    public WordAdapter(Context context, ArrayList<Word> words) {
        super(context, 0, words);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Get the data item for this position
        Word word = getItem(position);

        // Check if an existing view is being reused, otherwise inflate the view
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.list_item, parent, false);
        }
        // Lookup view for data population
        ImageView imageView = (ImageView) convertView.findViewById(R.id.image);
        TextView eng = (TextView) convertView.findViewById(R.id.default_text_view);
        TextView miwok = (TextView) convertView.findViewById(R.id.miwok_text_view);

        // Populate the data into the template view using the data object
        imageView.setImageResource(word.imageCount);
        if(word.imageCount == 0){
            LinearLayout listItemLayout = (LinearLayout) convertView.findViewById(R.id.listLayout);
            listItemLayout.removeView(imageView);
        }
        eng.setText(word.english);
        miwok.setText(word.miwok);

        // Return the completed view to render on screen
        return convertView;
    }
}
