# Parking Bill Calculator

## Grade - Beginner

## Introduction
The parking bill calculator is a simple service to calculate the bill due for a
single parking ticket based on the time of entry and the time of exit (or more
accurately payment).

At the car park, each vehicle entering is issued a parking ticket encoded with
the entry time. When the vehicle leaves the operator must first pay by scanning
the ticket. The is calculated based on the entry time and the time of payment.

The service accepts a string holding the entry time and exit time and returns
the calculated charge as a number.

The car park opens at 6am and closes at 8pm. It is assumed that all vehicles
exit the car park by the time it closes.

## Requirements

  1. Input is always a string and the result is always returned as a numeric
  value

  2. Input is a string containing two comma separated time values in the form
  HH:MM,HH:MM. The first value is the entry time, the second time is the exit
  time

  3. If the duration (the time between entry and exit) is less than five minutes
  the charge is 0 - it is assumed that no parking took place

  4. For the first hour the parking fee is 2

  5. For the second, third and fourth hours, each hour after the first incurs 
  an additional charge of 3

  6. For each hour after the fourth hour an additional charge of 5 is added

  7. If the entry time is omitted a summary fee of 100 is charged
