package uk.org.dwp.digital.engineering.tenpinbowlingkata;

import java.util.ArrayList;
import java.util.List;

public class Game {
    private static final int MINIMUM_PINS = 0;
    private static final int MAXIMUM_PINS = 10;
    private static final int INCOMPLETE_GAME_SCORE = -1;
    private static final int PINS_IN_FRAME = 10;
    private static final int FRAMES_IN_GAME = 10;
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
        int pinsLeftInFrame = PINS_IN_FRAME;
        int cumulative_score = 0;
        for (int index = 0; index < rollResult.size(); ++index) {
            int pins = rollResult.get(index);
            if (pinsLeftInFrame < PINS_IN_FRAME) {
                if (pinsLeftInFrame == pins) {
                    cumulative_score += rollResult.get(index + 1);
                }
                framesCompleted = frame;
                ++frame;
                pinsLeftInFrame = PINS_IN_FRAME;
            } else {
                pinsLeftInFrame -= pins;
            }
            cumulative_score += pins;
        }
        if (framesCompleted == FRAMES_IN_GAME) {
            final_score = cumulative_score;
        }
        return final_score;
    }
}
