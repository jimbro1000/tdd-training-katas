# Ten Pin Bowling Score Card

## Grade - Beginner

## Introduction
The ten pin bowling game consists of 10 frames. In each frame the player has
two opportunities to knock down 10 pins.  The score for the frame is the total
number of pins knocked down, plus bonuses for strikes and spares. At the end of
a frame the number of pins available to knock down is reset to 10.

<table>
  <tr><td colspan=30>Score Card</td></tr>
  <tr>
  <td colspan=2 align="right">1</td>
  <td>4</td>
  <td colspan=2 align="right">4</td>
  <td>5</td>
  <td colspan=2 align="right">6</td>
  <td>/</td>
  <td colspan=2 align="right">5</td>
  <td>/</td>
  <td colspan=2> </td>
  <td>X</td>
  <td colspan=2 align="right">0</td>
  <td>1</td>
  <td colspan=2 align="right">7</td>
  <td>/</td>
  <td colspan=2 align="right">6</td>
  <td>/</td>
  <td colspan=2 align="right"></td>
  <td>X</td>
  <td>2</td>
  <td>/</td>
  <td>6</td>
  </tr>
  <tr>
  <td colspan=3 align="center">5</td>
  <td colspan=3 align="center">14</td>
  <td colspan=3 align="center">29</td>
  <td colspan=3 align="center">49</td>
  <td colspan=3 align="center">60</td>
  <td colspan=3 align="center">61</td>
  <td colspan=3 align="center">77</td>
  <td colspan=3 align="center">97</td>
  <td colspan=3 align="center">117</td>
  <td colspan=3 align="center">133</td>  
  <tr>
</table>

A spare is when the player knocks down all 10 pins in two tries. The bonus for
that frame is the number of pins knocked down by the next roll. So in frame 3
above, the score is 10 (the total number knocked down) plus a bonus of 5 (the
number of pins knocked down on the next roll.)

A strike is when the player knocks down all 10 pins on his first try. The bonus
for that frame is the value of the next two balls rolled.

In the tenth frame a player who rolls a spare or strike is allowed to roll the
extra balls to complete the frame.  However no more than three balls can be
rolled in tenth frame.

## Requirements
  * Write a class named “Game” that has two methods
  * roll(pins) is called each time the player rolls a ball.  The argument is
  the number of pins knocked down supplied as an integer
    * pins can never be more than 10 and never less than 0
    * there are at most two rolls for each frame, except for the tenth frame
      which can have three rolls
    * if the first roll of a frame is 10 then a strike is recorded and the
      score for this roll will include the next two rolls added in a second roll
      for this frame is not permitted
    * if the sum of pins for a single frame is 10 then a spare is recorded and
      the score for this roll will include the next roll added in
    * if the roll is the first for the tenth frame and a strike is recorded a
      bonus frame is permitted. If the bonus frame results in a strike a
      second bonus frame is also permitted.
    * if the roll is the second for the tenth frame and a spare is recorded a
      single bonus frame is permitted, but only for a single roll
    * bonus frames do not include the addition of subsequent rolls where a
      strike or spare is recorded
  * score() is called only at the very end of the game.  It returns the total
  score for that game as an integer
    * the minimum possible score is 0
    * the maximum possible score is 300

## References
This kata is provided by Uncle Bob with a step-by-step
[solution](http://butunclebob.com/ArticleS.UncleBob.TheBowlingGameKata)
