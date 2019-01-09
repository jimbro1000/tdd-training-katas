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
single unit. What needs testing is the interaction with an external object.

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

### Example

Assuming we had a very, very simple validation object with a basic requirement
to record an error log in the event that the message to verify is empty then we
can spy on the appender object and verify that the call to append a new log
entry is made.

```Java
import ch.qos.logback.classic.spi.ILoggingEvent;
import ch.qos.logback.core.Appender;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentMatcher;
import org.mockito.Matchers;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@RunWith(MockitoJUnitRunner.class)
public class ValidateLoggingTest {

  @Mock
  Appender appender;

  @Before
  public void setup() {
    ch.qos.logback.classic.Logger logger = (ch.qos.logback.classic.Logger) LoggerFactory.getLogger(Logger.ROOT_LOGGER_NAME);
    Mockito.when(appender.getName()).thenReturn("MOCK");
    Mockito.when(appender.isStarted()).thenReturn(true);
    logger.addAppender(appender);
  }

  @Test
  public void testValidateLogsAnErrorMessageIfTheMessageIsEmpty() {
    MessageValidator validator = new MessageValidator();
    validator.validate("");

    Mockito.verify(appender, Mockito.times(1)).doAppend(Matchers.argThat(new ArgumentMatcher() {
      @Override
      public boolean matches(Object argument) {
        boolean result = false;
        if (argument instanceof ILoggingEvent) {
          ILoggingEvent loggingEvent = (ILoggingEvent) argument;
          if (loggingEvent.getLevel() == Level.ERROR) {
            result = loggingEvent.getFormattedMessage().equals("This is an error log message");
          }
        }
        return result;
      }
    }));
  }
}
```

There are two key elements here - first that the Appender, not the Logger is
mocked. Second that the setup method needs to do a little work to apply the
mocked appender to the logger. Once this is done the test becomes simply to
test that the mocked appender is called.

The implementation code would be very simple too.

```Java
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MessageValidator {

  private final static Logger log = LoggerFactory.getLogger(MessageValidator.class);

  public void validate(String message) {
    if ("".equals(message)) {
      log.error("This is an error log message");
    }
  }
}
```
