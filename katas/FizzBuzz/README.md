# Fizz Buzz

## Grade - Total Beginner

## Introduction

Fizz Buzz is an ideal, simple introduction to TDD with the emphasis on the
process rather than the implementation. There is no input to process, just an
output to the console.

## Requirements

1. Return a list of numbers from 1 to 100 as a comma separated string

2. For each multiple of 3 output "Fizz" instead of the number

3. For each multiple of 5 output "Buzz" instead of the number

4. For multiples of 3 and 5 output "Fizzbuzz" instead of the number

## Guidance

### Getting Started

The first step is to make sure you have the tools you need. If you are using
Java then an ideal starting point is a Maven POM file with a dependency added
for junit. If Javascript is the weapon of choice then a node project with
mocha. In all cases creating a git repository is a must. Equally useful is a
modern IDE with static code analysis and code completion.

### First Test
The first requirement can be tested easily - there is no input just a single
string output. Treating the requirements separately and ignoring subsequent
requirements all this is needs is an assertion that the output is equal to a
known constant.

Composing the test requires a little bit of framework first. In the case of
Java with junit this would be to create a new test class and start adding in
the dependencies. The best approach to this is to start with adding the `@Test`
annotation, in a modern IDE this will immediately flag a problem since the code
analysis won't be able to identify the annotation. The fix is to add `import
org.junit.test` - the IDE should even be able to do this for you with a little
prompting. The test itself is a public void method following the annotation. The
naming of the method is vital and should be descriptive and readable. Something
like "fizzBuzzReturnsAStringOfNumbersOneToOneHundredSeparatedByCommas", it
describes the requirement and expected outcome, uses standard camel case and
doesn't attempt to abbreviate anything.

Doing the same in JavaScript with mocha follows a simple pattern. A new folder
"test" and a script to contain the tests, `fizzBuzzTest.js`. The template for a
mocha test is
```Javascript
describe("fizzbuzz", function() {
  it("returns a string of numbers one to one hundred separated by commas", function() {
    assert
  });
});
```
Mocha automatically provides the describe and it implementation so there is no
need to do anything other than write the code but the assertion starts to hit
the same problem seen in Java, the assertion library needs to be selected as a
NPM require statement and in the default case that is
`var assert = require('assert');`.

In both cases we have just been through a TDD cycle already, even while
composing the test. As soon as the test is broken by using something the IDE
doesn't recognise is followed by an action to fix the test. In this cycle
refactoring wasn't required.

So where did we run the tests you may ask? The IDE did that for us using static
code analysis, highlighting where the test was broken. Granted this isn't quite
the same as running the unit tests but following the same pattern makes sure
that every single change is correctly built. The temptation is to complete the
line of code before going back and resolving problems with the imports or
requires. That isn't wrong but it means stretching out the pain. Dealing with it
immediately means keeping the code as green as we can keep it and that includes
the tests themselves.

For JavaScript the assert statement completes easily, it just needs to add
parenthesis and a closing semi-colon. We still need the parameters for the
expected value and actual value of course.

For Java the cycle continues, keeping the assertion readable can be achieved
using the `Assert.assertThat` syntax but as soon as we enter Assert the IDE will
trip on static analysis again requiring another import. Again completing the
line requires parenthesis and a closing semi-colon.

Getting back to the test - the initial assertion is that the returned string
from our solution is a string of 100 numbers from one to one hundred. Choosing
how to represent this is actually a tricky question - the simplest option is to
just create a string by hand but it is something of a chore. Writing code to
generate the expected solution is the obvious solution but that would likely
result in the implementation code being generated in the test and solution. A
third option would be to utilise a tool to generate the string. Whatever option
is chosen it will form the expected value.

The actual value is a call to the implementation. The IDE will trip as soon as
the name is entered. Utilise the IDE to resolve the problem and create the
stub implementation for the solution.

Before populating the stub it is essential to finish the test itself. In Java
the test should look something like this (with the expected string abbreviated):
```Java
import org.junit.Assert;
import org.junit.Test;

import static org.hamcrest.coreMatchers.equalTo;
import static org.hamcrest.coreMatchers.is;

class fizzBuzzTest {
  @Test
  public void fizzBuzzReturnsAStringOfNumbersOneToOneHundredSeparatedByCommas() {
    Assert.assertThat(Solution.fizzBuzz(), is(equalTo("1,2,3,4...98,99,100")));
  }
}
```

The Javascript equivalent is not dissimilar:
```Javascript
var assert=require("assert");
var solution=requires("../fizzbuzz.js");

describe("fizzbuzz", function() {
  it("returns a string of numbers one to one hundred separated by commas", function () {
    assert.equals("1,2,3,4...98,99,100", solution.fizzbuzz());
  });
});
```

The next step is to run the test which should result in a failure as only a
stub implementation exists.

The simplest way to solve the problem is to just return the same string used in
the test.

Running the tests again results in the test passing.

The final step of the cycle is refactoring. There isn't an awful lot to do,
just the matter of moving the output string to a constant (if it isn't already).
