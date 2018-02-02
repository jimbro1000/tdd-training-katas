package uk.org.dwp.digital.engineering.tenpinbowlingkata;

import java.util.ArrayList;
import java.util.List;

public class Game {
    private static final int MINIMUM_PINS = 0;
    List<Integer> rollResult = new ArrayList<>();

    public void roll(int pins) {
        if (pins >= MINIMUM_PINS && pins <= 10) {
            rollResult.add(pins);
        }
    }
}
