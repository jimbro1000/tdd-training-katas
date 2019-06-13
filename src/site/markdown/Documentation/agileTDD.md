# Agile and TDD #

Why do agile methodology and TDD fit? The short answer is because they are both
trying to achieve the same thing but that requires some explanation.

## What is the Goal? ##

Let's start by recapping what TDD is trying to achieve.

The goal of TDD is to make better code by making sure that we only build what
we need and that what we build is needed. The result is the simplest
implementation to satisfy the stated requirements.

What about agile? That is something of a bigger, broader subject - the main
goal is to make sure that the implementers (in this case developers) are in
control and are keeping things interesting but alongside this in the
commandments of agile development are some more relevant points:

  * Customer-centric
  * Flexible
  * Rapid
  * Operational
  * Rhythmic
  * Simple

Comparing these to TDD we see some significant overlap:

  * Customer-centric and Operational - the customer (customer's requirements)
  are the highest priority and remember to pay attention to implementation
  issues for the best results
  * Rapid and Rhythmic - keep delivery rapid and maintain a constant cadence
  * Flexible and Simple - welcome change but remember that less is more

It doesn't take much imagination to see how these match up with the goals of
TDD - requirements are the highest priority and the implementation issues are
first and foremost. The cadence of work should be rapid and constant. Keeping
it simple and flexible is essential, changes to requirements can mean huge
changes to the implementation but always remember that the code must be there
only to satisfy requirements.

## The Elusive MVP ##

While it is a general product development term, the MVP has special meaning in
agile methodology. The basic precept is to create something that can be
tested or validated to prove the idea and understanding of the requirements.
Typically this is the product required for the agile show and tell ceremony.

In functional terms it is to create something that satisfies a minimum set of
requirements to still qualify as a working product, from there the product is
iterated upon to create working products with increasing but always complete
functionality.

One of the simplest ways to achieve an MVP is to pick the minimum set of
requirements and build them. TDD is there to help and make sure that the
requirements are met and that only those requirements are met.

When it comes to iterating on the product the tests built provide an easy way
of making sure that the original requirements are maintained while new
requirements are added.

## Agile Requirements ##

Agile exists to empower the developers and simplify the construction of software
by taking a realistic, pragmatic view of what requirements are and how they are
implemented. A cornerstone of the process is well-written requirements, which
also happens to be a cornerstone of TDD (with good reason given the origins of
both).

So what is a well-written requirement?

The agile manifesto itself doesn't describe it, only that it should be
customer centric, but dig deeper and the concept of "user stories" becomes
apparent. Ultimately a user story is an atomic increment to the product. It
describes everything needed to make the transformation, no matter how small.

If the story has any ambiguities or vagueness it should be rejected until it
can be refined to the point of being precise. All too often a user story
presented to a development team is simply a group of smaller, related stories
that are better described as an epic. If this is the case then the story, by
Agile standards, is not "ready" and will require refinement and decomposition
into the atomic user stories that the developers require to progress.

A good measure for a user story being well-written is the INVEST checklist

  * Independent
  * Negotiable
  * Valuable
  * Estimable
  * Small
  * Testable

All of those six points are valuable but it is the last one that stands out in
the context of TDD. In order for the user story to be sufficiently well written
it must describe something that can be quantified and tested. An obvious
component of this is that the story should contain acceptance criteria *and*
the acceptance criteria be sufficiently detailed that it can be re-written as
one or more tests.

Conversely the negotiable point enforces that the user story should not be a
*specific contract for features*. This leaves the developer with the freedom to
interpret the story. It also means that the user story can change or even be
discarded.

Frequently the acceptance criteria will describe a "big test" - something that
cannot directly be applied to TDD but, instead, form a member of the higher
level tests that fill the test pyramid. If this is the case it will produce a
set of smaller TDD requirements and tests that must be completed in order to
satisfy the larger test.
