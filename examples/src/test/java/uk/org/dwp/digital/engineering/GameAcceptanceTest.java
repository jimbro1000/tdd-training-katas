package uk.org.dwp.digital.engineering;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import uk.org.dwp.digital.engineering.tenpinbowlingkata.Game;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;

public class GameAcceptanceTest {
    private Game game;
    @Before
    public void setup() {
        game = new Game();
    }
    @Test
    public void exampleScoreCard() {
        game.roll(1);
        game.roll(4);
        game.roll(4);
        game.roll(5);
        game.roll(6);
        game.roll(4);
        game.roll(5);
        game.roll(5);
        game.roll(10);
        game.roll(0);
        game.roll(1);
        game.roll(7);
        game.roll(3);
        game.roll(6);
        game.roll(4);
        game.roll(10);
        game.roll(2);
        game.roll(8);
        game.roll(6);
        Assert.assertThat("Expected a score of 133", game.score(), is(equalTo(133)));
    }

    @Test
    public void secondExampleScoreCard() {
        game.roll(7);
        game.roll(2);
        game.roll(8);
        game.roll(2);
        game.roll(10);
        game.roll(9);
        game.roll(1);
        game.roll(6);
        game.roll(2);
        game.roll(10);
        game.roll(10);
        game.roll(10);
        game.roll(0);
        game.roll(8);
        game.roll(9);
        game.roll(1);
        game.roll(8);
        Assert.assertThat("Expected a score of 167", game.score(), is(equalTo(167)));
    }

    @Test
    public void perfectGameExampleScoreCard()
    {
        game.roll(10);
        game.roll(10);
        game.roll(10);
        game.roll(10);
        game.roll(10);
        game.roll(10);
        game.roll(10);
        game.roll(10);
        game.roll(10);
        game.roll(10);
        game.roll(10);
        game.roll(10);
        Assert.assertThat("Expected a score of 300", game.score(), is(equalTo(300)));
    }
}
