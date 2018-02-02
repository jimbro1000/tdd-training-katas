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
        boolean gameComplete = false;
        int index = 0;
        while (index < rollResult.size() && !gameComplete) {
            int pins = rollResult.get(index);
            if (pinsLeftInFrame < PINS_IN_FRAME) {
                if (pinsLeftInFrame == pins) {
                    cumulative_score += rollResult.get(index + 1);
                    if (frame == FRAMES_IN_GAME) {
                        ++index;
                    }
                }
                framesCompleted = frame;
                ++frame;
                pinsLeftInFrame = PINS_IN_FRAME;
            } else {
                if (PINS_IN_FRAME == pins) {
                    cumulative_score += rollResult.get(index + 1);
                    cumulative_score += rollResult.get(index + 2);
                    framesCompleted = frame;
                    ++frame;
                    pinsLeftInFrame = PINS_IN_FRAME;
                } else {
                    pinsLeftInFrame -= pins;
                }
            }
            cumulative_score += pins;
            if (framesCompleted == FRAMES_IN_GAME) {
                gameComplete = true;
            }
            ++index;
        }
        if (gameComplete && index == rollResult.size()) {
            final_score = cumulative_score;
        }
        return final_score;
    }
}
