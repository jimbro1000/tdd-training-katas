package uk.org.dwp.digital.engineering.tenpinbowlingkata;

import org.junit.Assert;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;

public class GameTest {
    @Test
    public void methodRollAcceptsPinsAsAnIntegerAndStoresTheValue() {
        Game game = new Game();
        game.roll(1);
        Assert.assertThat("Expected roll to store a value of 1", game.rollResult, is(equalTo(1)));
    }
}
