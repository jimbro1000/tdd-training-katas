# Advanced Test Driven Development

## Test Driven Design

One of the biggest complaints with TDD, that it is very organic and leads to
bad design, highlights where followers of TDD use the development cycle to
ignore design.

While the "red-green" part of the cycle is essential to actually building
working code, the "refactor" part tends to be neglected. Some refactoring may
be performed to tidy-up code or to maintain standards but the real value of
refactoring is overlooked.

### Real Refactoring

Using the unit tests to verify that refactoring of code is "safe" is the most
basic benefit of TDD but redesigning of the code is another matter and requires
another look at how tests are built and even where they are built.

The initial premise of TDD is that tests are performed in an open-box manner,
with full visibility of implementation code to the tests. This creates
closely-coupled tests and redesigning the code is likely to break them.

From a broader perspective there needs to be a set of closed-box tests as well
that verify the external behaviour that should remain immutable during the
redesign process. These loosely-coupled tests need to exist independently of the
code - in Java this would mean using a separate namespace to effectively close
the code implementation off and keep the external behaviours as the focus. These
tests start to overlap with higher level tests and the BDD space. Assuming BDD
is followed then they may well be one and the same instead of an independent set
of tests.

### When to Redesign

As with the development refactoring cycle the more you do it, in smaller steps,
the easier it gets. Saving up redesign and refactoring to occasional steps tends
to result in lengthy sessions - interrupting the natural flow. Keeping the
changes small maintains the flow but potentially limits redesign efforts.

Using the right design to start with obviously improves the chances of keeping
redesign steps small but this tends to come with experience, for a novice TDD
developer it is easy to end up with a solution that fulfils the requirements but
neglects quality design.

It is vital not to write-off redesign as technical debt - if the solution needs
to be redesigned then it should be tackled as soon as possible. Putting the task
off is likely to result in the task simply not happening and the "poor" design
persisting.

Leaving the task too long also leads to a potentially lengthy process of
re-writing the open-box tests. Getting the "good" design in early means limiting
the required re-writing of tests is limited.

### What to Redesign

Picking what to redesign, as already mentioned, is partially a matter of
experience but following SOLID principles is not going to lead you astray. The
process is essentially examining the code for emergent design - identifying
candidates for encapsulation or relationships.

Attempting to design the implementation in advance is likely to go against the
grain of TDD but it is easy to achieve the same result with over enthusiastic
redesign. The tenets of TDD still remain, to provide the minimum implementation
to satisfy the requirements but with an eye to safe, secure code that is easily
understood and well written.

One of the obvious tells that can be identified is where code is duplicated,
this would be naturally refactored out but where this starts to become more than
a few lines of code it is worth examining to see if it can be elevated, a
common interface defined, or to assist in separating out concerns.
