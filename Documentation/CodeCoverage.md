# Code Coverage

## What it is, Why it matters

One of the key tenets of TDD is that code is written test first and only the
code required to fulfil the test is implemented. It sounds simple but it is
really easy for a developer to add a little extra code here and there just to
"code ahead" or to add a function that will be useful even if it isn't strictly
needed. When refactoring it is also easy to leave in bits of code that aren't
required any more.

Code coverage is a measure of the lines of code in the implementation that are
covered by tests. In an ideal world that figure should always be 100% but
nothing is ever that simple. Some languages require lines of code that are
required by grammar but provide no direct function for implementation. The
calculation for lines of code in the implementation is not always as accurate
as we would like to believe. A common example of good but untested code is
the declaration of constants. The end result is typically code coverage in the
area of 70-80%.

The calculation itself is pretty simple
```
Code Coverage = (Number of lines of code exercised)/(Total Number of lines of code) * 100%
```

## When it matters

The simple answer is all the time but the real value comes from relative scores,
from one build to the next. If the score is going down in a new build compared to
the previous one then something is going wrong - new code or refactoring of old
code will cause some variation in the score, up or down. If the value is going
down make sure you understand why. If code has been added without new tests why
is that happening - it could be refactoring to remove duplicate code or to
improve clarity but neither case should result in a significant change.

Most coverage tools provide a detailed analysis of where code is and is not
being covered. Examining the results should guide you to where the score is
being reduced.

## When it doesn't matter

The short answer is that it always matters but nothing is ever quite that
simple. Blindly trusting to a code coverage tool to "score" your code for
coverage is likely to lead to problems. In it's simplest case there is nothing
wrong with the calculation but it isn't hard to create complex, multi-branch
logic that satisfies the requirement that "every line is tested" but fails to
test every combination of logical branching.

It isn't so much that code coverage doesn't matter - it is more that the
developer must pay close attention to what is actually being tested. Simply
trusting a 100% code coverage score and assuming that the code is "test complete"
will end badly.
