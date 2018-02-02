package uk.org.dwp.digital.engineering.tenpinbowlingkata;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;

public class GameTest {
    private Game game;
    @Before
    public void setup() {
        game = new Game();
    }

    @Test
    public void methodRollAcceptsPinsAsAnIntegerAndStoresTheValue() {
        game.roll(1);
        Assert.assertThat("Expected roll to store a value of 1", game.rollResult.get(0), is(equalTo(1)));
    }

    @Test
    public void methodRollStoresPinsAsASequenceOfValues() {
        game.roll(2);
        game.roll(8);
        Assert.assertThat("Expected roll to store a value of 2 for the first roll", game.rollResult.get(0), is(equalTo(2)));
        Assert.assertThat("Expected roll to store a value of 8 for the second roll", game.rollResult.get(1), is(equalTo(8)));
    }
}
