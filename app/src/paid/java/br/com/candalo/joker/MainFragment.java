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
import android.widget.ProgressBar;

import br.com.candalo.jokeview.JokeActivity;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;

public class MainFragment extends Fragment implements EndpointsAsyncTask.OnResultListener {

    @BindView(R.id.btn_tell_joke)
    Button tellJokeButton;
    @BindView(R.id.pb_joke)
    ProgressBar jokeProgressBar;
    private Unbinder unbinder;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_main, container, false);
        injectDependencies(view);
        return view;
    }

    private void injectDependencies(View view) {
        unbinder = ButterKnife.bind(this, view);
    }

    @Override
    public void onDestroyView() {
        unbinder.unbind();
        super.onDestroyView();
    }

    @OnClick(R.id.btn_tell_joke)
    void onClickTellJokeButton() {
        showLoading();
        new EndpointsAsyncTask(MainFragment.this).execute();
    }

    @Override
    public void onResult(String joke) {
        hideLoading();

        Intent intent = new Intent(getContext(), JokeActivity.class);
        intent.putExtra("jokeExtra", joke);
        startActivity(intent);
    }

    private void showLoading() {
        jokeProgressBar.setVisibility(View.VISIBLE);
        tellJokeButton.setVisibility(View.INVISIBLE);
    }

    private void hideLoading() {
        jokeProgressBar.setVisibility(View.INVISIBLE);
        tellJokeButton.setVisibility(View.VISIBLE);
    }
}
