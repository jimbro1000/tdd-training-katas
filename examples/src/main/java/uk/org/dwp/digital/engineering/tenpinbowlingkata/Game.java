package uk.org.dwp.digital.engineering.tenpinbowlingkata;

import java.util.ArrayList;
import java.util.List;

public class Game {
    List<Integer> rollResult = new ArrayList<>();

    public void roll(int pins) {
        rollResult.add(pins);
    }
}
