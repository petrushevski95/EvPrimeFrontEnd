# Acceptance Criteria

## Test Scenario 1: "Create an Event" Button

**Prerequisite:** User must be logged in.  

**Given** the user is on the events page `http://localhost:3000/events`  
**And** the user points to the hover button  
**And** the "Create an event" button is displayed  
**When** the user clicks the "Create an event" button  
**Then** the user is redirected to the create new event page `http://localhost:3000/events/new` 