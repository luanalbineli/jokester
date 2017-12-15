package com.example.jokelibrary;

import java.util.Random;

public class JokeProvider {
    private static final String[] JOKES = new String[] {
            " Anton, do you think I’m a bad mother?\n" +
                    "\n" +
                    "My name is Paul.",
            "What is the difference between a snowman and a snowwoman?\n" +
                    "-\n" +
                    "Snowballs.",
            "My wife suffers from a drinking problem.\n" +
                    "-\n" +
                    "Oh is she an alcoholic?\n" +
                    "-\n" +
                    "No, I am, but she’s the one who suffers.",
            "I’m selling my talking parrot. Why? Because yesterday, the bastard tried to sell me.",
            "I can’t believe I forgot to go to the gym today. That’s 7 years in a row now.",
            "The inventor of AutoCorrect is a stupid mass hole. He can fake right off.",
            "A naked women robbed a bank. Nobody could remember her face."
    };

    private static final Random RANDOM = new Random();

    public static String getRandomJoke() {
        return JOKES[RANDOM.nextInt(JOKES.length)];
    }
}
