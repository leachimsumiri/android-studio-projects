package com.example.android.miwok;

import android.content.Context;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class ColorsFragment extends Fragment {
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        ViewGroup rootView = (ViewGroup) inflater.inflate(
                R.layout.word_list, container, false);

        ArrayList<Word> words = new ArrayList<Word>();
        words.add(new Word(R.drawable.color_red,"red", "weṭeṭṭi", R.raw.color_red));
        words.add(new Word(R.drawable.color_mustard_yellow, "mustard yellow", "chiwiiṭә", R.raw.color_mustard_yellow));
        words.add(new Word(R.drawable.color_dusty_yellow, "dusty yellow", "ṭopiisә", R.raw.color_dusty_yellow));
        words.add(new Word(R.drawable.color_green, "green", "chokokki", R.raw.color_green));
        words.add(new Word(R.drawable.color_black, "black", "kululli", R.raw.color_black));
        words.add(new Word(R.drawable.color_brown, "brown", "ṭakaakki", R.raw.color_brown));
        words.add(new Word(R.drawable.color_white, "white", "kelelli", R.raw.color_white));
        words.add(new Word(R.drawable.color_gray, "gray", "ṭopoppi", R.raw.color_gray));

        // Create the adapter to convert the array to views
        WordAdapter adapter = new WordAdapter(getContext(), words);

        // Attach the adapter to a ListView
        final ListView listView = (ListView) rootView.findViewById(R.id.list);
        listView.setAdapter(adapter);
        listView.setBackgroundColor(getResources().getColor(R.color.category_numbers));

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long id) {
                Word wordEntry = (Word) listView.getItemAtPosition(i);
                MediaPlayer mediaPlayer = MediaPlayer.create(getActivity().getApplicationContext(), wordEntry.getRawResId());
                mediaPlayer.start();
            }
        });

        return rootView;
    }
}
