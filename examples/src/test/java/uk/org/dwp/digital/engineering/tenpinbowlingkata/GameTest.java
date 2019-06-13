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

    @Test
    public void methodRollIgnoresPinValuesLessThanZero() {
        game.roll(2);
        game.roll(-1);
        Assert.assertThat("Expected roll to store 2 for the first roll", game.rollResult.get(0), is(equalTo(2)));
        Assert.assertThat("Expected roll to ignore the second roll", game.rollResult.size(), is(equalTo(1)));
    }

    @Test
    public void methodRollIgnoresPinValuesGreaterThanTen() {
        game.roll(11);
        game.roll(5);
        Assert.assertThat("Expected roll to ignore the first roll", game.rollResult.size(), is(equalTo(1)));
        Assert.assertThat("Expected roll to store 5 for the second roll", game.rollResult.get(0), is(equalTo(5)));
    }

    @Test
    public void scoreReturnsNegativeOneIfTheGameIsNoRollsAreMade() {
        Assert.assertThat("Expected a score of -1", game.score(), is(equalTo(-1)));
    }

    @Test
    public void scoreReturnsNegativeOneIfTheGameIsIncomplete() {
        game.roll(1);
        Assert.assertThat("Expected a score of -1", game.score(), is(equalTo(-1)));
    }

    @Test
    public void scoreAddsThePinsValuesTogether() {
        game.roll(1);
        game.roll(1);
        game.roll(1);
        game.roll(1);
        game.roll(1);
        game.roll(1);
        game.roll(1);
        game.roll(1);
        game.roll(1);
        game.roll(1);
        game.roll(1);
        game.roll(1);
        game.roll(1);
        game.roll(1);
        game.roll(1);
        game.roll(1);
        game.roll(1);
        game.roll(1);
        game.roll(1);
        game.roll(1);
        Assert.assertThat("Expected a score of 20", game.score(), is(equalTo(20)));
    }

    @Test
    public void aSpareRollResultsInTheNextRollBeingAddedBack() {
        game.roll(1);
        game.roll(9);
        game.roll(1);
        game.roll(1);
        game.roll(1);
        game.roll(1);
        game.roll(1);
        game.roll(1);
        game.roll(1);
        game.roll(1);
        game.roll(1);
        game.roll(1);
        game.roll(1);
        game.roll(1);
        game.roll(1);
        game.roll(1);
        game.roll(1);
        game.roll(1);
        game.roll(1);
        game.roll(1);
        Assert.assertThat("Expected a score of 29", game.score(), is(equalTo(29)));
    }

    @Test
    public void aSpareBallInTheTenthFrameResultsInASingleBonusRoll() {
        game.roll(1);
        game.roll(1);
        game.roll(1);
        game.roll(1);
        game.roll(1);
        game.roll(1);
        game.roll(1);
        game.roll(1);
        game.roll(1);
        game.roll(1);
        game.roll(1);
        game.roll(1);
        game.roll(1);
        game.roll(1);
        game.roll(1);
        game.roll(1);
        game.roll(1);
        game.roll(1);
        game.roll(1);
        game.roll(9);
        game.roll(1);
        Assert.assertThat("Expected a score of 29", game.score(), is(equalTo(29)));
    }

    @Test
    public void aStrikeRollResultsInTheNextTwoRollsBeingAddedBack() {
        game.roll(10);
        game.roll(1);
        game.roll(1);
        game.roll(1);
        game.roll(1);
        game.roll(1);
        game.roll(1);
        game.roll(1);
        game.roll(1);
        game.roll(1);
        game.roll(1);
        game.roll(1);
        game.roll(1);
        game.roll(1);
        game.roll(1);
        game.roll(1);
        game.roll(1);
        game.roll(1);
        game.roll(1);
        Assert.assertThat("Expected a score of 30", game.score(), is(equalTo(30)));
    }

    @Test
    public void aStrikeRollInTheLastFrameResultsInTwoBonusRolls() {
        game.roll(1);
        game.roll(1);
        game.roll(1);
        game.roll(1);
        game.roll(1);
        game.roll(1);
        game.roll(1);
        game.roll(1);
        game.roll(1);
        game.roll(1);
        game.roll(1);
        game.roll(1);
        game.roll(1);
        game.roll(1);
        game.roll(1);
        game.roll(1);
        game.roll(1);
        game.roll(1);
        game.roll(10);
        game.roll(1);
        game.roll(1);
        Assert.assertThat("Expected a score of 30", game.score(), is(equalTo(30)));
    }

    @Test
    public void scoreCorrectlyTreatsAZeroAndThenAnyRollAsTheCompletionOfAFrame() {
        game.roll(0);
        game.roll(1);
        game.roll(1);
        game.roll(1);
        game.roll(1);
        game.roll(1);
        game.roll(1);
        game.roll(1);
        game.roll(1);
        game.roll(1);
        game.roll(1);
        game.roll(1);
        game.roll(1);
        game.roll(1);
        game.roll(1);
        game.roll(1);
        game.roll(1);
        game.roll(1);
        game.roll(1);
        game.roll(1);
        Assert.assertThat("Expected a score of 19", game.score(), is(equalTo(19)));
    }

    @Test
    public void scoreCorrectlyTreatsAZeroAndThenTenInAFrameAsASpare() {
        game.roll(0);
        game.roll(10);
        game.roll(1);
        game.roll(1);
        game.roll(1);
        game.roll(1);
        game.roll(1);
        game.roll(1);
        game.roll(1);
        game.roll(1);
        game.roll(1);
        game.roll(1);
        game.roll(1);
        game.roll(1);
        game.roll(1);
        game.roll(1);
        game.roll(1);
        game.roll(1);
        game.roll(1);
        game.roll(1);
        Assert.assertThat("Expected a score of 29", game.score(), is(equalTo(29)));
    }
}
