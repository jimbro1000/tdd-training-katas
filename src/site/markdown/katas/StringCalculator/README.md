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
an integer number

2. An empty input string returns zero (e.g. "" returns 0)

3. A single number in the input returns the value (e.g. "4" returns 4)

4. Two input numbers, comma-delimited, returns the sum of the numbers (e.g. "2,3" returns 5)

5. Two input numbers, newline-delimited, returns the sum of the numbers (e.g. "2\n4" returns 6)

6. Three or more input numbers, delimited either way, returns the sum of all of the numbers (e.g. "2,3\n4" returns 9)

7. Negative input numbers result in an exception being thrown

8. Input numbers over 1,000 are ignored (treated as 0)

9. A single char delimiter can be defined on the first line by prefixing the
character with a double forward slash (e.g. "//#\n2#3" returns 5)

10. A multi-char delimiter can be defined on the first line by prefixing the
delimiter with a double forward slash (e.g. "//||\n3||5" returns 8)

_Note: by convention a newline in the input string is illustrated by \n in the
examples above._
