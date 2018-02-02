package uk.org.dwp.digital.engineering.tenpinbowlingkata;

import java.util.ArrayList;
import java.util.List;

public class Game {
    private static final int MINIMUM_PINS = 0;
    private static final int MAXIMUM_PINS = 10;
    private static final int INCOMPLETE_GAME_SCORE = -1;
    List<Integer> rollResult = new ArrayList<>();

    public void roll(int pins) {
        if (pins >= MINIMUM_PINS && pins <= MAXIMUM_PINS) {
            rollResult.add(pins);
        }
    }

    public int score() {
        return INCOMPLETE_GAME_SCORE;
    }
}
