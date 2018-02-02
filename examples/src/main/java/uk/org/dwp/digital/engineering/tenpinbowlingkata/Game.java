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
        int framesCompleted = 0;
        int frame = 1;
        int pinsLeftInFrame = 10;
        int cumulative_score = 0;
        for (Integer pins : rollResult) {
            if (pinsLeftInFrame < 10) {
                framesCompleted = frame;
                ++frame;
                pinsLeftInFrame = 10;
            } else {
                pinsLeftInFrame -= pins;
            }
            cumulative_score += pins;
        }
        if (framesCompleted == 10) {
            final_score = cumulative_score;
        }
        return final_score;
    }
}
