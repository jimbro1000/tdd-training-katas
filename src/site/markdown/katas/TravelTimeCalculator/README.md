# Travel Time Calculator

## Grade - Advanced

## Introduction

A company's itinerary planning system allows users to specify a calendar of
meetings that can be physical or online. For physical meetings the user must be
in the right location, for online meetings the user can be in any location but
must not be travelling. The system uses time between meetings to select the
best time to travel so that the user is always in the right place.

The travel time calculator is a component in the larger system. It has a fixed
interfaces that are predefined and must be adhered to.

## Requirements

The calculator accepts two locations and returns the predicted travel time
between those two points. The interface for finding the travel time is a
method "getTravelTime" and accepts two string values:

    TravelTimeCalculator.getTravelTime(
        travelFromLocation, 
        travelToLocation
    )

It is assumed that the method of travel is simply the fastest option and that
the time to travel remains the same regardless of the time of day. Travel time
is the same regardless of direction (A to B or B to A).

The travel time is returned as a string in the format "hh:mm"

If a travel time for the given destinations has not been previously submitted or
the from and to locations are the same the result is a zero time ("00:00").

A list of all recognised locations can be obtained from the calculator through
a method "getTravelLocations" that returns string with a comma separated list
of locations in alphabetical order:

    TravelTimeCalculator.getTravelLocations()

A list of possible destinations for a given location can be obtained by using a
method "getTravelDestinations". This method accepts the queried location as a
string. The output is a comma-separated list of destination locations:

    TravelTimeCalculator.getTravelDestinations(location)

The calculator also has a method to update the travel time based on history
"setTravelTime" that accepts two string values for locations and a third string
value holding the travel time in the format "hh:mm":

    TravelTimeCalculator.setTravelTime(
        travelFromLocation, 
        travelToLocation, 
        travelTime
    )

When setting the travel time, if a location is not recognised it is added to the
dictionary of locations and the time taken stored verbatim. If both locations
are recognised the average of the existing and the supplied travel times are
kept. The calculated average is always rounded up to the nearest minute.

An attempt to set the from and to locations the same is ignored.

To illustrate this, given the travel time data:

| Locations  | Blackpool | Leeds | London | Manchester | Newcastle |
| ---------- | --------- | ----- | ------ | ---------- | --------- |
| Blackpool  | NA        | 1:39  | 3:21   | 1:06       | 2:37      |
| Leeds      |           | NA    | 2:15   | 0:56       | 1:24      |
| London     |           |       | NA     | 1:00       | 1:10      |
| Manchester |           |       |        | NA         | 2:28      |
| Newcastle  |           |       |        |            | NA        |

Calling `getTravelTime("Leeds","Manchester")` returns the value `"0:56"`

Calling `getTravelLocations()` returns the value
`"Blackpool,Leeds,London,Manchester,Newcastle"`

Calling `setTravelTime("Leeds","London","2:17")` modifies the data such that
calling `getTravelTime("Leeds","London")` returns the value `"2:16"`

Calling `setTravelTime("London","Birmingham","1:22")` adds Birmingham as a
destination so that `getTravelLocations()` returns the value
`"Birmingham,Blackpool,Leeds,London,Manchester,Newcastle"`. Calling
`getTravelTime("Birmingham","London")` returns the value `"1:22"`. Calling
`getTravelTime("Leeds","Birmingham")` returns the value `"0:00"`.
