# Disc Intersections

## Grade - Intermediate

## Introduction
This kata requires an answer to a fairly simple problem - given an array of
numbers where each number represents the radius of a circle and the index of
the array represents the position of the circle along a line, find the
total number of intersections between circles.

It requires some thought on how to identify the intersections but ultimately
this isn't a huge problem until you scale the number of items in the array. It
quickly becomes a complex calculation that can take a significant time to solve.
Adding time complexity to the requirements means the initial solution to the
problem is unlikely to resemble the final solution.

Test time complexity requires sampling of the solution run-time and requires
the developer to step away from pure unit-tests and look at how to capture the
performance of the tests in the form of micro-benchmarks.

The simplest answer here is to just record the run-time of each test and compare
this against the number of elements in the input. Tools exist to support micro-benchmarking and recording of performance but how does this get included
in the build automation?

## Requirements

  1. The solution accepts input in the form of an array of integers. Each
  element of the array represents a circle, the element value is the radius of
  the circle and the element index is the relative position of the centre of the
  circle along a straight line.

  2. The solution returns the number of intersecting circles (including overlap
  where one circle is fully contained within another). Two circles touching is
  included in the count.

  3. If the number of intersections exceeds 10,000,000 the solution returns -1.

  4. The number of elements in the array will not exceed 100,000

  5. The smallest possible radius is 0 - this represents a point. An
  intersection between a point and the edge of a circle is included in the sum.
  A point  wholly contained in a circle is included in the sum.

  6. The time to find the solution should, at worst case, be in the order of
  N\*log(N) where N is the number of elements in the array. NB.: time complexity
  is normally stated as being a function `O()` so in this case it is O(N\*log(N)).

## References
This kata is borrowed from a [codility lesson](https://codility.com/programmers/lessons/6-sorting/number_of_disc_intersections) on the subject of sorting (_**big hint**_)

[JMH](http://openjdk.java.net/projects/code-tools/jmh) from openJDK can provide micro-benchmarking tools - there is also a JMH plugin for IntelliJ
