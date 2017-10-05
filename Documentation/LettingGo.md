# The Art Of Letting Go

One of the issues in development of code is that it gets messy, refactoring of
code results in blocks commented out, the code itself becomes idiosyncratic to
the individual working on it or just plain unreadable.

## What Are We Holding On To

A lot of the problem is that we naturally hold on to useful snippets of code or
lack the confidence to blindly remove old, stale code just in case we need it.

Then there is the matter of time pressures. Just getting the job done can save
a little bit of time up front but almost inevitably results in problems further
down the line.

One of the hardest thing is letting go of code that has been worked on and
crafted over an extended period of time but is no longer needed or has proven
to be a dead-end in light of new requirements. Creating an emotional attachment
to the work is hard not to do, especially if it has been a struggle but the
vital thing is to accept that it is the outcome we are working towards, not a
set of lines of code.

## Why Holding On Is Bad

The code needs to be simple, following our TDD tenets it should be just enough
to get the job done according to the tests that we've written. Once the tests
work refactoring is an opportunity to clean the code up with the confidence
that changes do not create new problems.

We have tools in place, code control, that allow us to make changes and revert
them should something go wrong and powerful refactoring tools built into our
IDEs. There is no practical reason to hold on to old code or leave code in an
unreadable state or unusable state.

## So What Is Clean Code?

A large part of clean code is actually clean design the implementation process
is all part of it. From the perspective of clean code, TDD is an essential
ingredient but the reverse is true also. The refactor component to the TDD
cycle is prime opportunity to tidy up code, both tests and solution. TDD enables
another key feature - that code doesn't get filled with unnecessary, unplanned
functionality.

## Points To Remember

  * avoid duplicated code
  * keep naming clear and readable
  * remove excess white space
  * remove dead code

Following the TDD cycle enables this behaviour and is poorer without it.
