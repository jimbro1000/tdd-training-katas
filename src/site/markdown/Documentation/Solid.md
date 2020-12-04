# SOLID Principles for Object Oriented Software

## Introduction

In 2000, Robert Martin (*Uncle Bob*) introduced the concepts behind the
SOLID principles as a means to make code easier to understand and extend, but it
was Michael Feathers that introduced the SOLID acronym that has become popular
as representing those principles.

## Concepts

**Single Responsibility Principle** a class should have only a single
responsibility

**Open/closed principle** (software entities) should be open for extension, but
closed for modification

**Liskov substitution principle** objects in a program should be replaceable
with instances of their subtypes without altering the correctness of that
program

**Interface segregation principle** many client-specific interfaces are better
than one general-purpose interface

**Dependency inversion principle** one should depend upon abstractions, [not]
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
will result in major rework anywhere the class is used. Any class inheriting
may extend the functionality without causing side-effects.

## Liskov Substitution Principle

Prior to the establishment of the SOLID principles the open/closed principle
had been used to popularise the use of abstracted interfaces but within SOLID
this is covered by Liskov substitution whereby any class can be substituted by
a subtype. This also permits classes implementing an interface to be similarly
exchanged.

## Interface Segregation Principle

While Liskov subtitution promotes the use of abstract interfaces, the principle
of interface segregation promotes the separation of functional groups of
interface definition.

## Dependency Inversion Principle

Dependency inversion demands that the dependency between classes is abstracted
through the use of interfaces.

## References

SOLID Wikipedia [https://en.wikipedia.org/wiki/SOLID]

Robert C Martin [http://cleancoder.com/products]

Michael Feathers [https://michaelfeathers.silvrback.com/]
