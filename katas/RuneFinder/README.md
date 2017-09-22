# RUNE FINDER TDD KATA

## Grade - Beginner

## Introduction

The rune finder kata presents a simple problem, to find a missing rune (digit)
from an equation.

## Requirements

You are helping an archaeologist decipher some runes. He knows that his ancient
society used a base 10 system, and that they never start a number with a
leading zero. He's figured out most of the digits as well as a few operators,
but he needs your help to figure out the rest.

The professor will give you a simple math expression, of the form
```
[number][op][number]=[number]
```

He has converted all of the runes he knows into digits. The only operators he
knows are addition (+), subtraction (-), and multiplication (\*), so those are
the only ones that will appear. Each number will be in the range from -1000000
to 1000000, and will consist of only the digits 0-9, possibly a leading -, and
maybe a few ?s, if there are ?s in an expression, they represent a digit rune
that the professor doesn't know (never an operator, and never a leading -). All
of the ?s in an expression will represent the same digit (0-9), and it won't be
one of the other given digits in the expression. No number will begin with a 0
unless the number itself is 0, therefore 00 would not be a valid number.

Given an expression, find the value of the rune represented by the question
mark, if more than one digit works, give the lowest one. If no digit works,
well that's bad news for the professor - it means that he's got some of his
runes wrong, output -1 in that case.

Complete the method to solve the expression to find the value of the unknown
run. The method takes a string as a parameter representing the expression and
will return a number value representing the unknown rune or -1 if no such rune
exists.

e.g.
Given the expression '1+1=?' the function should return 2  
Given the expression '123*45?=5?088' the function should return 6
Given the expression '103+?=103' the function should return -1
