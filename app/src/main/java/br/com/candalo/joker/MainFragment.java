package br.com.candalo.joker;


import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import br.com.candalo.jokeview.JokeActivity;

public class MainFragment extends Fragment implements EndpointsAsyncTask.OnResultListener {

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_main, container, false);

        Button tellJokeButton = view.findViewById(R.id.btn_tell_joke);
        tellJokeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                Intent intent = new Intent(getContext(), JokeActivity.class);
//                startActivity(intent);
                new EndpointsAsyncTask(MainFragment.this).execute();
            }
        });

        return view;
    }

    @Override
    public void onResult(String joke) {
        Toast.makeText(getContext(), joke, Toast.LENGTH_SHORT).show();
    }
}
