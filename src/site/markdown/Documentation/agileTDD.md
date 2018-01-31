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
