# SOLID Principles for Object-Oriented Software

## Introduction

In 2000, Robert Martin (*Uncle Bob*) introduced the concepts behind the
SOLID principles as a means to make code easier to understand and extend, but it
was Michael Feathers that introduced the SOLID acronym that has become popular
as representing those principles.

## Concepts In Brief

**Single Responsibility Principle** a class should have only a single
responsibility

**Open/closed principle** (software entities) should be open for extension, but
closed for modification

**Liskov substitution principle** objects in a program should be replaceable
with instances of their subtypes without altering the correctness of that
program

**Interface segregation principle** many client-specific interfaces are better than one general-purpose interface

**Dependency inversion principle** one should depend upon abstractions, **not**
concretions

## Single Responsibility Principle

Sometimes referred to as separation of concerns, this principle drives the
design of any class to be focussed on one responsibility.

## Open/Closed Principle

While there have been many variations on the meaning of this principle over the
years since it was first postulated by Bertrand Meyer in the late 80s, the
intent within SOLID is to ensure that a class can be extended by inheritance
but should not be left open to modification. The basis is that once a functional
set of operations is defined for a class it should not then be modified as this
will result in major rework anywhere the class is used. Any class inheriting may extend the functionality without
causing side effects.

## Liskov Substitution Principle

Prior to the establishment of the SOLID principles the open/closed principle
had been used to popularise the use of abstracted interfaces but within SOLID
this is covered by Liskov substitution whereby any class can be substituted by
a subtype. This also permits classes implementing an interface to be similarly exchanged.

## Interface Segregation Principle

While Liskov substitution promotes the use of abstract interfaces, the principle of interface segregation promotes the
separation of functional groups of interface definition.

## Dependency Inversion Principle

Dependency inversion demands that the dependency between classes is abstracted through the use of interfaces.

## Why SOLID?

A fundamental part of writing better code is making sure it is easier to understand, not just as to what it does but
also how to further develop the code for a new purpose or feature.

With only a little experience it is not difficult to write code that achieves a simple goal - writing code that can
survive complex requirements being added is another matter and this is where SOLID is so valuable. It isn't a magic
bullet, and it can't solve all of your coding problems, but it goes a long, long way to easing the pain of having to
completely redesign and rework code when those changes come along, or save hours of work hunting down all the code
affected by an otherwise simple change.

## What Does This Have to do With TDD?

SOLID is not a part of TDD, that should be pretty obvious, but it is hard to talk about the quality of code without
brushing on this topic.

Not every computer programming language is object-oriented and SOLID can have different practical meanings to different
languages or even frameworks within a language. The principles and ideas remain largely constant and this is all about
writing better code.

The really short version of SOLID is "does a piece of code have only one reason to change?" and "does a change affect
more than one piece of code?". If your code is failing these basic questions then something is likely wrong, and you
need to look at your design, tests and refactoring to see how you can fix it. The earlier you do this the easier it will
be.

The other point to remember is that this all came from the same heads that made TDD what it is - these things go
hand-in-hand as part of the broader, holistic view of software engineering.

## References

SOLID Wikipedia [https://en.wikipedia.org/wiki/SOLID]

Robert C Martin [http://cleancoder.com/products]

Michael Feathers [https://michaelfeathers.silvrback.com/]
