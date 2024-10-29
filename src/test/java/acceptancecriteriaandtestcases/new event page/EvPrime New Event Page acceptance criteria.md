# Test Scenario

## Test Scenario 1: "Create Event" Button

**Prerequisite:** User must be logged in.  

**Given** the user is on the new event page `http://localhost:3000/events/new`  
**And** the create event form is displayed  
**And** the user enters an event title into the "Event Title" field  
**And** the user enters an event image URL into the "Event Image" field  
**And** the user enters an event date into the "Event Date" field  
**And** the user enters an event location into the "Event Location" field  
**And** the user enters an event description into the "Event Description" field  
**When** the user clicks on the "Create Event" button  
**Then** the user is redirected to the events page `http://localhost:3000/events`  
**And** the created event is displayed on the events page with the correct details.  