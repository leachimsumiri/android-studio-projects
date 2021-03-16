package com.example.android.miwok;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;

import java.util.ArrayList;

public class PhrasesFragment extends Fragment {
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        ViewGroup rootView = (ViewGroup) inflater.inflate(
                R.layout.word_list, container, false);

        ArrayList<Word> words = new ArrayList<Word>();
        words.add(new Word(0,"Where are you going?", "minto wuksus", R.raw.phrase_where_are_you_going));
        words.add(new Word(0, "What is your name?", "tinnә oyaase'nә", R.raw.phrase_what_is_your_name));
        words.add(new Word(0,"My name is...", "oyaaset...", R.raw.phrase_my_name_is));
        words.add(new Word(0, "How are you feeling?", "michәksәs?", R.raw.phrase_how_are_you_feeling));
        words.add(new Word(0,"I’m feeling good.", "kuchi achit", R.raw.phrase_im_feeling_good));
        words.add(new Word(0, "Are you coming?", "әәnәs'aa?", R.raw.phrase_are_you_coming));
        words.add(new Word(0,"Yes, I’m coming.", "hәә’ әәnәm", R.raw.phrase_yes_im_coming));
        words.add(new Word(0, "I’m coming.", "әәnәm", R.raw.phrase_im_coming));
        words.add(new Word(0,"Let’s go.", "yoowutis", R.raw.phrase_lets_go));
        words.add(new Word(0, "Come here.", "әnni'nem", R.raw.phrase_come_here));

        // Create the adapter to convert the array to views
        WordAdapter adapter = new WordAdapter(getContext(), words);

        // Attach the adapter to a ListView
        final ListView listView = (ListView) rootView.findViewById(R.id.list);
        listView.setAdapter(adapter);
        listView.setBackgroundColor(getResources().getColor(R.color.category_phrases));

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
