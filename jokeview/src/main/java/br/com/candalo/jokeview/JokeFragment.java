package br.com.candalo.jokeview;


import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class JokeFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_joke, container, false);

        TextView jokeTextView = view.findViewById(R.id.tv_joke);
        jokeTextView.setText(getJoke());

        setupStyle(view, jokeTextView);

        return view;
    }

    private String getJoke() {
        if (getActivity() != null) {
            return getActivity().getIntent().getStringExtra("jokeExtra");
        }
        return getString(R.string.joke_error);
    }

    private void setupStyle(View view, TextView jokeTextView) {
        int backgroundColor = ColorUtils.getBackgroundColor();
        int textColor = ColorUtils.getTextColor(backgroundColor);

        view.setBackgroundColor(getResources().getColor(backgroundColor));
        jokeTextView.setTextColor(getResources().getColor(textColor));
    }
}
