# Ten Pin Bowling Score Card

## Grade - Beginner

## Introduction
Ten pin bowling is a sport particularly popular in the USA where a player rolls
a bowling bowl down an "alley" in an attempt to knock over a set of ten pins at
the end.

The ten pin bowling game consists of 10 frames. In each frame the player has
two opportunities to knock down the 10 pins.  The score for the frame is the
total number of pins knocked down, plus bonuses for strikes and spares. At the
end of a frame the pins available to knock down is reset to 10.

Scoring is maintained on a score card that tracks the result of each roll of the
bowling ball, and the total score achieved.

| score card |     |     |     |     |     |     |     |     |     |       |
| ---------- | --- | --- | --- | --- | --- | --- | --- | --- | --- | ----- |
| frame      |  1  |  2  |  3  |  4  |  5  |  6  |  7  |  8  |  9  | 10    |
| score      | 1 4 | 4 5 | 6 / | 5 / | X   | 0 1 | 7 / | 6 / | X   | 2 / 6 |
|            | 5   | 14  | 29  | 49  | 60  | 61  | 77  | 97  | 117 | 133   |

A spare is when the player knocks down all 10 pins in two tries. The bonus for
that frame is the number of pins knocked down by the next roll. So in frame 3
above, the score is 10 (the total number knocked down) plus a bonus of 5 (the
number of pins knocked down on the next roll.)

A strike is given when the player knocks down all 10 pins on his first try. The
bonus for that frame is the value of the next two balls rolled in the following
frame. An example of this is shown in frame 5, here the score for frame 5 is 10
plus 1 from the next two rolls in frame 6.

In the tenth frame a player who rolls a spare or strike is allowed to roll the
extra balls to complete the frame. However no more than three balls can be
rolled for tenth frame. During the tenth frame, for bonus rolls only, if the
frame has been cleared (all ten pins knocked down) the frame will be reset to
ten standing pins.

For this kata the objective is to produce a game class that tracks the ongoing
score of a player and provides a final total score.

## Requirements
  * Write a class named “Game” that has two methods
  * roll(pins) is called each time the player rolls a ball.  
    * The argument (pins) is the number of pins knocked down on the roll and
      supplied as an integer
    * pins can never be more than 10 and never less than 0
  * score() is called only at the very end of the game. It returns the total
    score for that game as an integer
    * the minimum possible score is 0
    * the maximum possible score is 300
    * there are at most two rolls for each frame, except for the tenth frame
      which can have three rolls
    * if the first roll of a frame is 10 then a strike is recorded and the
      score for this roll will include the next two rolls added in
    * if a strike is recorded then a second roll for that frame is not
      permitted, unless it is the tenth frame
    * if the sum of pins for a single frame is 10 then a spare is recorded and
      the score for this roll will include the next roll added in
    * if the roll is the first for the tenth frame and a strike is recorded a
      bonus frame is permitted. If the bonus frame results in a strike a
      second bonus frame is also permitted
    * if the roll is the second for the tenth frame and a spare is recorded a
      single bonus frame is permitted, but only for a single roll
    * bonus frames do not include the addition of subsequent rolls where a
      strike or spare is recorded

## Examples
### Example 1
The player starts a new game and makes a series of rolls with the following outcomes:

| Roll | Pins | Frame |    Cum. Score    |
| ---- | ---- | ----- | ---------------- |
|  1   |  7   |   1   |   7              |
|  2   |  2   |   1   |   9              |
|  3   |  8   |   2   |  17              |
|  4   |  2   |   2   |  19+r(5)         |
|  5   | 10   |   3   |  39+r(6)+r(7)    |
|  6   |  9   |   4   |  58+r(7)         |
|  7   |  1   |   4   |  59+r(8)         |
|  8   |  6   |   5   |  71              |
|  9   |  2   |   5   |  73              |
| 10   | 10   |   6   |  83+r(11)+r(12)  |
| 11   | 10   |   7   | 103+2r(12)+r(13) |
| 12   | 10   |   8   | 133+2r(13)+r(14) |
| 13   |  0   |   9   | 133+r(14)        |
| 14   |  8   |   9   | 149              |
| 15   |  9   |  10   | 158              |
| 16   |  1   |  10   | 159+r(17)        |
| 17   |  8   |  10B  | 167              |

Within the calculation of the cumulative score forward scores are shown using r(*n*)
where *n* is the roll number. B in the frame column represents a bonus roll

### Example 2
The perfect game

| Roll | Pins | Frame |    Cum. Score    |
| ---- | ---- | ----- | ---------------- |
|  1   | 10   |   1   |  10+r(2)+r(3)    |
|  2   | 10   |   2   |  30+2r(3)+r(4)   |
|  3   | 10   |   3   |  60+2r(4)+r(5)   |
|  4   | 10   |   4   |  90+2r(5)+r(6)   |
|  5   | 10   |   5   | 120+2r(6)+r(7)   |
|  6   | 10   |   6   | 150+2r(7)+r(8)   |
|  7   | 10   |   7   | 180+2r(8)+r(9)   |
|  8   | 10   |   8   | 210+2r(9)+r(10)  |
|  9   | 10   |   9   | 240+2r(10)+r(11) |
| 10   | 10   |  10   | 270+2r(11)+r(12) |
| 11   | 10   |  10B  | 290+r(12)        |
| 12   | 10   |  10B  | 300              |

## References
This kata is based on another, provided (in part) by Uncle Bob with a step-by-step
[solution](http://butunclebob.com/ArticleS.UncleBob.TheBowlingGameKata).

While the original Uncle Bob kata and solution is relevant, this kata has evolved
and there are differences.

### Worked Solution
The "tenPinBowlingPart1" branch contains a start to finish example of tackling the
requirements of the kata. There is no commentary but it does consist of a number 
of commits with messages.
