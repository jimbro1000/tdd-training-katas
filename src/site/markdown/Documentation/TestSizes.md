# Test Sizes - The Testing Pyramid #

A cornerstone of TDD is, naturally, writing automated tests but there can often
be confusion about what a test should be doing and how big it should be.

An easy way of looking at tests is to regard them as a pyramid. At the top you
have just a few, big tests while at the bottom you have lots and lots of small
tests.

## What's at the Top? ##

The top of the pyramid is business-related testing, largely for the release and
post-release. Below this is the user acceptance tests, end-to-end tests and
system tests where the testing transitions from business to technology as the
focus.

## And at the Bottom? ##

The very bottom, as already mentioned, is unit tests - open box tests that
describe and verify how the implementation works.

Above the open box tests we have closed box tests, increasing in abstraction as
we move up the pyramid. First comes component testing - still very much about
implementation - then integration testing, the tests we associate with
behaviour driven development (BDD).

## So Where Do You Start ##

If we assume that development will follow BDD then it is there that we have to
start. Composing a number of behavioural tests that describe the overall
external behaviour, these in turn will define the design of the required
components, each of which will supply a number of fine-grained functional
requirements.

At each stage we can define automated tests that must be satisfied to prove the
system being built does as required. This should by now sound familiar.

Once a component has been identified and documented with tests it is possible
to begin the TDD process, working against the component requirements.

Following this process it is a quick and simple process to construct a large
number of tests that underpin the entire composition of the testing pyramid.

With the foundations in place the pyramid will grow vertically.
