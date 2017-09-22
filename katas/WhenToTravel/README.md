# When To Travel - Itinerary Planning

## Grade - Advanced

## Introduction

A company's itinerary planning system allows users to specify a calendar of
meetings that can be physical or online. For physical meetings the user must be
in the right location, for online meetings the user can be in any location but
must not be travelling. The system uses time between meetings to select the
best time to travel so that the user is always in the right place.

## Requirements

The planning system's primary method accepts a list of planned meetings
covering a single week. The list is represented as a string in the form of a
comma-separated list of appointments. Each appointment takes the form of start
day (of the week) and a time in the form "Ddd hh:mm" and an end day and time.
The two values are concatenated with a hypen, the pair is suffixed with a single
character flag indicating if the appointment is for a physical meeting or a
teleconference in the format "Ddd hh:mm-Ddd hh:mm F". The flag is either P for a
physical meeting or T for a teleconference. If the meeting is physical the
appointment is followed by an additional space and the location taking the form
"Ddd hh:mm-Ddd hh:mm F location"

The week is assumed to start on a Monday and ends on the following Sunday.

The appointments in the list can appear in any order but never overlap.

Given the appointment list the itinerary planner returns a list of transits to
place the user in the right location for each physical appointment. The list is
a comma-separated list of locations followed by the expected travel time in the
format "location hh:mm".

If the appointment list contains only teleconference meetings the travel list is
an empty string.

If no possible solution to the planned itinerary cannot be found the method
returns an error message string "no solution possible".

It is assumed that the user is in the right location for the first physical
meeting.

The journeys in the transit list cannot overlap with any appointments.

Travel transit times are obtained from an external service `TravelTimeCalculator`.
The service provides several methods that can be used to find a travel solution:

`getTravelLocations`, `getTravelDestinations` and `getTravelTime`.

`getTravelLocations` returns a list of recognised meeting locations as a string in
the form of a comma-separated list.

`getTravelDestinations` accepts a location as string and returns a string in the
form of a comma-separated list representing all of the possible destinations
from the given location.

`getTravelTime` accepts two locations as strings, the first is the start
location, the second is the end destination. The result is the transit time in
the form of a string "hh:mm". If a transit time is not available the returned
string is a zero-time ("00:00").

Access to the service is limited to the company's own network and cannot be
accessed by the developers.

In order to test the planner it will be necessary to create a mock substitute.
