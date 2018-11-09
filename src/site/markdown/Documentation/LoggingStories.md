# How to Unit Test Logging

## Why Unit Test Logging?

Fundamentally logging is a side-effect of any code. It should never alter the
state of a process or alter the outcome in any way, as such it doesn't fall
under any kind of functional user story. The flip-side of this is that all code
in production should be covered by a unit test. Obviously these two views are
not easy to reconcile.

In most cases logging does not require a user story, especially when introduced
as a debug or trace level event. Instead the lines of logging code are present
to assist in identifying unexpected or undesired behaviour and to inform the
developer on how to reproduce a problem and compose a suitable unit test rather
than the other way around.

Eventually and inevitably you will be faced with a situation where info level
logging is a critical part of an application and requires a specific user
story to describe the behaviour - at this point you have to write a test to
describe the behaviour and initiate the composition of code to meet the
requirement.

## Is It a Unit Test?
Because logging does not modify the state of the class or module you are
building it would be simple to pass the story sideways and say it isn't a unit
test and should be part of integration testing - and you wouldn't be wrong but
you still need to describe that behaviour. If you have to describe the behaviour
at code level then it is still a unit test and falls within the scope of a
single unit.

## The Logistics of Logging

The component being tested is typically a log appender provisioned through a
factory method. Most modern Java code utilises slf4j or equivalent with levels 
of abstraction to hide and configure delivery of logs to a useful collection
point locally or remotely. Chief among those appenders is logback which gives
us immense flexibility on how and where to deliver logs.

When a logger object is provisioned by the slf4j logger factory it autowires a
number of elements and leaves the final delivery (appender) mechanism as a
configuration option - this is in turn provides a developer with an opportunity
to mock the appender and verify that the log call is made and supplied with
relevant content.
