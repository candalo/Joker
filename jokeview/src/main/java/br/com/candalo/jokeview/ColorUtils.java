package br.com.candalo.jokeview;


import android.support.annotation.ColorRes;

import java.util.Arrays;
import java.util.Random;

final class ColorUtils {

    private ColorUtils() {
    }

    @ColorRes
    static int getBackgroundColor() {
        int[] colorResources = {
                R.color.white,
                R.color.yellow,
                R.color.fuchsia,
                R.color.red,
                R.color.silver,
                R.color.gray,
                R.color.olive,
                R.color.purple,
                R.color.maroon,
                R.color.aqua,
                R.color.lime,
                R.color.teal,
                R.color.green,
                R.color.blue,
                R.color.navy,
                R.color.black
        };

        int position = new Random().nextInt(colorResources.length);

        return colorResources[position];
    }

    @ColorRes
    static int getTextColor(@ColorRes  int backgroundColorResource) {
        Integer[] backgroundsWithBlackText = {
                R.color.white,
                R.color.fuchsia,
                R.color.yellow,
                R.color.red,
                R.color.silver,
                R.color.lime,
                R.color.aqua,
        };
        Integer[] backgroundsWithWhiteText = {
                R.color.gray,
                R.color.olive,
                R.color.purple,
                R.color.maroon,
                R.color.teal,
                R.color.green,
                R.color.blue,
                R.color.navy,
                R.color.black
        };

        if (Arrays.asList(backgroundsWithBlackText).contains(backgroundColorResource)) {
            return R.color.black;
        }

        return R.color.white;
    }
}
