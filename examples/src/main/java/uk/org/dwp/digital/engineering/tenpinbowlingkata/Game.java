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
        int final_score = INCOMPLETE_GAME_SCORE;
        if (rollResult.size() > 0) {
            int cumulative_score = 0;
            for (Integer pins : rollResult) {
                cumulative_score += pins;
            }
            final_score = cumulative_score;
        }
        return final_score;
    }
}
