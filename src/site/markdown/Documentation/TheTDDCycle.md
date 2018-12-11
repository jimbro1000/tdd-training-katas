# The TDD Cycle - Red-Green-Refactor

The core of TDD is the "red-green-refactor" cycle - each
cycle is the creation of a test, the code necessary to satisfy the test
followed by refactoring the tests and code to make sure it is all relevant
and conforms with development standards. Every cycle follows the same 
pattern.

## Painting it Red

The first step in the cycle is the creation of a new test, in doing so the
test suite becomes broken as the new test should fail. If the tests continue
to execute cleanly the new test is either failing to test something new or is
itself incorrect.

With most modern IDE's it is possible to set execution of tests to be automated,
such that manual intervention is not required - you simply write the test and
the error quickly becomes apparent.

## Moving to Green

The idea of the green phase of the cycle is to implement (or change) just enough
code to fix test execution so that it does not fail. In the early stages of
development this is likely to be simply returning fixed dummy values that
satisfy the test, building up a wire frame of code that will enable further
changes. As the tests become more complex, so does the code but at all times it
only ever does enough to satisfy the tests.

## Refactoring Green Tests and Code

Once the tests all operate cleanly the cycle moves to refactoring. Some code
will become redundant, some tests will also become redundant - refactoring
gives us the chance to dispose of waste in the code. The important detail is
that at the end the tests are all still green. That is *all* of the tests, not
just the new test.

## What does this really look like?

When first getting started it is easy to operate the cycle but the size of each
change can be quite large, that is fine but it can be quite hard to become lost
in the code or start attempting more than is needed to achieve the immediate
goal.

The art of TDD is keeping the changes small and focused. If you start to really
break it down the changes amount to just one or two lines of code at a time. The
point at which the test code becomes red you switch to making it green but that
does not necessarily mean creating a whole test. With modern IDEs it is clear when
the test code is broken - fixing that test code is the primary concern. This
will sometimes happen while composing the test - for example referencing a class
that does not yet exist (typically the very first test will hit this). The step
to fix the test is to create the class. The test that is being worked on is not
complete even when the class is created but a mini red-green-refactor cycle has
taken place. The end result is that the code is always left in a suitable state.

### An example in code (java)
The developer starts with a new junit test - with nothing in place this is a new
class.

```java
package tdd.example.first;

public class TddCycleTest {
  @Test
}
```

Everything goes smoothly until the `@Test` annotation is used - at which point the
IDE starts to complain. The test is now red and the focus switches to making it
green.

```java
package tdd.example.first;

import org.junit.Test;

public class TddCycleSolutionTest {
  @Test
}
```

A simple import resolves the problem, the test is now green and there is the
opportunity to refactor but at this point nothing needs to be changed so the
developer resumes composing the test.

```java
package tdd.example.first;

import org.junit.Test;

public class TddCycleSolutionTest {
  @Test
  public void whenGivenAnEmptyStringTheSolutionReturnsAZero() {
    TddCycleSolution tddCycleSolution;
  }
}
```

As the test is built up the next problem comes when the class being tested is
referenced for the first time. The class does not exist yet so the IDE starts to
complain.

```java
package tdd.example.first;

public class TddCycleSolution {

}
```

Creating a stub for the missing class turns the test green again even though it
does not actually do anything yet. The simplest change to resolve the problem is
made. Once again there is nothing to refactor so the developer returns to the
test.

```java
package tdd.example.first;

import org.junit.Test;

public class TddCycleSolutionTest {
  @Test
  public void whenGivenAnEmptyStringTheSolutionReturnsAZero() {
    TddCycleSolution tddCycleSolution = new TddCycleSolution();
    Assert;
  }
}
```

As soon as the developer references the Assert class the IDE starts to complain
the developer could complete the line and fix any other problems that arise but
it is prudent to resolve the issue immediately.

```java
package tdd.example.first;

import org.junit.Assert;
import org.junit.Test;

public class TddCycleSolutionTest {
  @Test
  public void whenGivenAnEmptyStringTheSolutionReturnsAZero() {
    TddCycleSolution tddCycleSolution = new TddCycleSolution();
    Assert;
  }
}
```

Importing the Assert class fixes the immediate problem but the line is still
not valid and needs completing.

```java
package tdd.example.first;

import org.junit.Assert;
import org.junit.Test;

public class TddCycleSolutionTest {
  @Test
  public void whenGivenAnEmptyStringTheSolutionReturnsAZero() {
    TddCycleSolution tddCycleSolution = new TddCycleSolution();
    Assert.assertThat(tddCycleSolution.check(""));
  }
}
```

Referencing the check method of the solution breaks the test again and requires
the developer to return to the implementation.

```java
package tdd.example.first;

public class TddCycleSolution {
  int check(String value) {
    return -1;
  }
}
```

The stub method fixes the problem with just a few lines of basic code, just
enough to satisfy the immediate issue.

```java
package tdd.example.first;

import org.junit.Assert;
import org.junit.Test;

public class TddCycleSolutionTest {
  @Test
  public void whenGivenAnEmptyStringTheSolutionReturnsAZero() {
    TddCycleSolution tddCycleSolution = new TddCycleSolution();
    Assert.assertThat(tddCycleSolution.check(""),is());
  }
}
```

Extending the line fixes the error relating to the syntax of the line but a new
error is created when `is()` is added.

```java
package tdd.example.first;

import org.junit.Assert;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
```

In this example the hamcrest matcher is added through a static import, once
again the test is green. There is still nothing to refactor so the developer
continues.

```java
package tdd.example.first;

import org.junit.Assert;
import org.junit.Test;

public class TddCycleSolutionTest {
  @Test
  public void whenGivenAnEmptyStringTheSolutionReturnsAZero() {
    TddCycleSolution tddCycleSolution = new TddCycleSolution();
    Assert.assertThat(tddCycleSolution.check(""),is(equalTo()));
  }
}
```

The test breaks again with the addition of the `equalTo()` matcher which is
once again resolved with another import allowing the developer to continue.

```java
package tdd.example.first;

import org.junit.Assert;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;

public class TddCycleSolutionTest {
  @Test
  public void whenGivenAnEmptyStringTheSolutionReturnsAZero() {
    TddCycleSolution tddCycleSolution = new TddCycleSolution();
    Assert.assertThat(tddCycleSolution.check(""),is(equalTo(0)));
  }
}
```

With the test completed the developer the test is now red again but it is time
to tackle the implementation.

```java
package tdd.example.first;

public class TddCycleSolution {
  int check(String value) {
    return 0;
  }
}
```

Changing the return value of the implementation stub to match the expected
result solves the issue.

The test is complete and green, all that remains is to refactor. At this point
the test and the class are very clean - the minimum code to satisfy the given
requirements from the test - so nothing needs to be done.

It took a while to illustrate but if a developer works through the cycle it only
takes a couple of minutes to complete that first cycle. It took a bit of
switching back and forth but at each point of failure the problem was fixed
immediately. Only a single unit test was implemented but several TDD cycles
were needed to get there. A modern IDE makes it much easier to achieve since it
is likely to have tools to create the code stubs from a single key press when
something new is encountered. Code completion will have accelerated things too
and ensured common typos are avoided.

Most developers in a modern IDE will be pretty much following this pattern
simply because it makes life easier but not necessarily in the context of a
test-first approach to development.

### Points to Observe
The example is very simple but there are some subtleties here worthy of note.
First of all is the use of the package namespace and scope to enable white box
testing. The test and implementation code are in separate files in the same
package - better still the developer will have placed the test code into a
different folder structure that allows the IDE to distinguish test code from
implementation code. When it comes to compiling and packaging the code the tests
are not included, only the implementation code should be in the finished
artifact. This is not unique to Java, this approach should be consistent in any
development, not just for TDD - it is simply good practice.

The second point is keeping the class and method naming clear and relevant.
Naming conventions in development tend to be consistent across languages and
platforms but it is vital that consistency is maintained across all parts of the
code.
