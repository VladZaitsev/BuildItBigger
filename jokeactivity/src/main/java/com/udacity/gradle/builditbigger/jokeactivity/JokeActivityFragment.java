package com.udacity.gradle.builditbigger.jokeactivity;

import android.content.Intent;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class JokeActivityFragment extends Fragment {

    public JokeActivityFragment() {

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_joke, container, false);
        TextView jokeTv = root.findViewById(R.id.joke_txt);

        Intent intent = getActivity().getIntent();
        String jokeContent = intent.getStringExtra(JokeActivity.EXTRA_JOKE);

        if (jokeContent != null) {
            jokeTv.setText(jokeContent);
        }
        return root;
    }
}
