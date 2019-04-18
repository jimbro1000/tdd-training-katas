# String Calculator

## Grade - Beginner

## Introduction
The string calculator is a simple tool to calculate the sum of a sequence of
numbers presented as a string.

The requirements are conveniently presented in the order of expected
implementation, adding complexity over time. Some of the requirements are
deliberately vague to allow the kata to be performed in different programming
languages.

## Requirements

1. Input is always in the form of a string, the result is always in the form of
a number

2. An empty string returns zero (e.g. "" returns 0)

3. A single number returns the value (e.g. "4" returns 4)

4. Two numbers, comma-delimited, returns the sum (e.g. "2,3" returns 5)

5. Two numbers, newline-delimited, returns the sum (e.g. "2\n4" returns 6)

6. Three numbers, delimited either way, returns the sum (e.g. "2,3\n4" returns 9)

7. Negative input values result in an exception being thrown

8. Input values over 1,000 are ignored

9. A single char delimiter can be defined on the first line by prefixing the
character with a double forward slash (e.g. "//#\n2#3" returns 5)

10. A multi-char delimiter can be defined on the first line by prefixing the
delimiter with a double forward slash (e.g. "//||\n3||5" returns 8)

_Note: by convention a newline in the input string is illustrated by \n in the
examples above._
