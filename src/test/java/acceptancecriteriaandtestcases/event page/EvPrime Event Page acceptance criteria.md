# Acceptance Criteria

## Test Scenario 1: Click on Event

**Prerequisite:** User must be logged in and an event must already be created.  

**Given** the user is on the events page `http://localhost:3000/events`  
**When** the user clicks on the event picture  
**Then** the user is redirected to the "Event" page `http://localhost:3000/events/{id}`  

---

## Test Scenario 2: Displayed Information on the Event Page

**Prerequisite:** User must be logged in and an event must already be created.  

**Given** the user is on the "Event" page `http://localhost:3000/events/{id}`  
**And** the event title is displayed  
**And** the event date is displayed  
**And** the event image is displayed  
**When** the event description is displayed  
**Then** the event location is displayed  

---

## Test Scenario 3: Successful Delete Event

**Prerequisite:** User must be logged in and an event must already be created.  

**Given** the user is on the "Event" page `http://localhost:3000/events/{id}`  
**And** the user clicks on the "Delete event" button  
**And** a window with the message "Are you sure you want to delete this event?" is displayed  
**And** the "Delete" button is displayed on the left side  
**And** the "No" button is displayed on the right side  
**When** the user clicks on the "Delete" button  
**Then** the user is redirected to the events page `http://localhost:3000/events`  
**And** the event is successfully deleted from the events page  

---

## Test Scenario 4: "Edit Event" Button

**Prerequisite:** User must be logged in and an event must already be created.  

**Given** the user is on the event page `http://localhost:3000/events/{id}`  
**When** the user clicks on the "Edit event" button  
**Then** the user is redirected to the edit event page `http://localhost:3000/events/{id}/edit`  

---

## Test Scenario 5: "Back to Events" Button

**Prerequisite:** User must be logged in and an event must already be created.  

**Given** the user is on the event page `http://localhost:3000/events/{id}`  
**When** the user clicks on the "Back to events" button  
**Then** the user is redirected to the events page `http://localhost:3000/events`  

---

## Test Scenario 6: "Update Event" Button

**Prerequisite:** User must be logged in, an event must already be created, and the "Edit" button must be clicked.  

**Given** the user is on the edit event page `http://localhost:3000/events/{id}/edit`  
**And** the user enters a new event title into the "Event Title" field  
**And** the user enters a new event location into the "Event Location" field  
**When** the user clicks on the "Update event" button  
**Then** the user is redirected to the event page `http://localhost:3000/events/{id}`  
**And** the event information is displayed on the event page with the updated details.