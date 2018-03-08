package br.com.candalo.jokesupplier;

import java.util.Random;

public class JokeSupplier {

    public static String tellAJoke() {
        String[] jokes = Joke.getList();
        int position = new Random().nextInt(jokes.length);
        return jokes[position];
    }

}
