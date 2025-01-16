# Phone Bill Calculator

## Grade - Intermediate

## Introduction

The phone bill calculator is a slightly more advanced kata. Not only are the
requirements not cleanly stated but the required solution takes a little more
thought.

The calculator accepts a list of phone call durations, each against a specific
phone number. The output is the total charge including a discount for the phone
number with the total longest call duration

## Requirements

Phone logs are given as a string S consisting of N lines separated by newline
characters.

Each line describes one phone call using thee following format
`hh:mm:ss,nnn-nnn-nnn`, where `hh:mm:ss` denotes the duration of the call (in
"hh" hours, "mm" minutes and "ss" seconds) and `nnn-nnn-nnn` denotes the
nine-digit phone number of the recipient (with no leading zeros).

Each call is billed separately. The billing rules are as follows:

  * If the call was shorter than 5 minutes, then you pay 3 cents for every
  started second of the call (e.g. for duration "00:01:07" you pay
  67 * 3 = 201 cents).
  * If the call was at least 5 minutes then you pay 150 cents per every minute
  started (e.g. for duration "00:05:00" you pay 5 * 150 = 750 cents)
  * All calls to the phone number with the longest total duration call are free,
  if two calls to different phone numbers tie then the numerically smallest
  phone number wins)

Write a function that, given a string describing phone call logs, returns the
amount of money you have to pay.

For example, given string S with N = 3 lines:
```
00:01:07,400-234-090
00:05:01,701-080-080
00:05:00,400-234-090
```
The function should return 900 (the total duration for number 400-234-090 is
6 minutes 7 seconds, and the total duration for number 701-080-080 is 5 minutes
1 second; therefore, the free promotion applies to the former phone number).

Assume that:
  * N is an integer within the range [1..100];
  * every phone call duration follows the format "hh:mm:ss" strictly
  (00 <= hh <= 99, 00 <= mm, ss <= 59);
  * each line follows the format "hh:mm:ss,nnn-nnn-nnn" strictly; there are no
  empty lines and spaces.
