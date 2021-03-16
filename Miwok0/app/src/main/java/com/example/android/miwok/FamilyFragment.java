package com.example.android.miwok;

import android.annotation.SuppressLint;
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

public class FamilyFragment extends Fragment {
    @SuppressLint("ResourceAsColor")
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        ViewGroup rootView = (ViewGroup) inflater.inflate(
                R.layout.word_list, container, false);

        ArrayList<Word> words = new ArrayList<Word>();
        words.add(new Word(R.drawable.family_father,"father", "әpә", R.raw.family_father));
        words.add(new Word(R.drawable.family_mother, "mother", "әṭa", R.raw.family_mother));
        words.add(new Word(R.drawable.family_son, "son", "angsi", R.raw.family_son));
        words.add(new Word(R.drawable.family_daughter, "daughter", "tune", R.raw.family_daughter));
        words.add(new Word(R.drawable.family_older_brother, "older brother", "taachi", R.raw.family_older_brother));
        words.add(new Word(R.drawable.family_younger_brother, "younger brother", "cahlitti", R.raw.family_younger_brother));
        words.add(new Word(R.drawable.family_older_sister, "older sister", "teṭe", R.raw.family_older_sister));
        words.add(new Word(R.drawable.family_younger_sister, "younger sister", "kolliti", R.raw.family_younger_sister));
        words.add(new Word(R.drawable.family_grandmother, "grandmother", "ama", R.raw.family_grandmother));
        words.add(new Word(R.drawable.family_grandfather, "grandfather", "paapa", R.raw.family_grandfather));

        // Create the adapter to convert the array to views
        WordAdapter adapter = new WordAdapter(getContext(), words);

        // Attach the adapter to a ListView
        final ListView listView = (ListView) rootView.findViewById(R.id.list);
        listView.setAdapter(adapter);
        listView.setBackgroundColor(getResources().getColor(R.color.category_family));

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
