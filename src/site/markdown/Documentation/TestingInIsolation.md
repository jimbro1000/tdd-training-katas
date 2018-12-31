# Unit Testing

While the basic test operation of TDD is unit testing, it is all too common
for people to forget what unit testing actually means but still follow the TDD
cycle.

For those that don't remember, unit testing means testing the unit (typically a
class) in isolation so that you only test the "unit" and nothing else. Simple
enough in principle but it is all too easy to create tests that break the
isolation rule. Any time a class under test utilises another class the isolation
is broken, this is forgivable where the dependency is on a base class or a
trusted library (but still something to be avoided if possible). Where the
dependency is on another class the complexity of behaviour increases and the
ability to create a predictable, controlled environment is severely diminished
making the outcome of any test potentially chaotic.

## Mocking the Dependency

The simple way to isolate your test class is to use mocking to prevent test
execution escaping to other classes. There are some things that need to be
understood about mocking and the different types of "mocks" are used.

Martin Fowler provided a detailed explanation of the differences back in 2004: 
[Mocks Aren't Stubs](https://martinfowler.com/articles/mocksArentStubs.html)

### Stubs

A stub object is a replacement for a functional class/object with very simple
scripted responses to cover some necessary scenario typically irrespective of
input.

### Dummy

A dummy object contains no behaviour and exists only to satisfy an otherwise
redundant value. There is no internal logic and usually returned values are
null or defaults.

### Fake

A fake object provides a complex, functional but controlled substitute for a
dependency. In most scenarios this would be a representation of an external or
dependent system rather than just a class.

### Mock

A true mock (rather than the blanket term) are pre-programmed objects required
to satisfy the expectations of a given scenario.

## Mocks vs Stubs

From the brief descriptions above it should be pretty obvious that the
distinctions between the mock types are narrow and developers frequently
describe mocks as stubs and vice-versa or a stub as a dummy. While this does
lead to some confusion the important bit is that you use them.

## Mocking in Java

The defacto unit test framework in Java, jUnit, does not provide a mocking
mechanism, instead the Mockito framework is typically used to provide the
mocking capability. Mockito is a powerful tool in the unit test arsenal and it
is vital that it is used appropriately.

There are other frameworks like JMockit for mocking and others again that extend
the capabilities of Mockito, such as PowerMock.

## Mocking in JavaScript

The proliferation of testing frameworks in JavaScript means there is a lot to
chose from but popular tools like Jasmine and Jest provide solid starting
points. Some provide mocking as standard while others need to be used in
combination.

## Checking Isolation

While it is normal to run *all* of your unit tests in each and every TDD cycle
when it comes to checking isolation it is necessary to limit the execution to
a single class. The test report should show test coverage (ideally near 100%)
for just that class. If the coverage shows anything outside of the test class
then the isolation is broken.

The practicalities of doing this class by class process is problematic. It is
fine when there is just a few classes under test but in a large, complex
system it is impractical to test each class by itself.
