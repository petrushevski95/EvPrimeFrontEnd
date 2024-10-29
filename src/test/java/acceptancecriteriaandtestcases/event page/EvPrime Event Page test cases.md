# Test Cases

## Test Case 1: Click on Event (PASS)

**Prerequisite:** User must be logged in and an event must already be created.  

**Given** the user is on the events page `http://localhost:3000/events`  
**When** the user clicks on the event picture  
**Then** the user is redirected to the "Event" page `http://localhost:3000/events/4c8fdc9f-2643-4d39-a27b-33f9070ab00c`  

---

## Test Case 2: Displayed Event Information on the Event Page (PASS)

**Prerequisite:** User must be logged in and an event must already be created.  

**Given** the user is on the "Event" page `http://localhost:3000/events/00c43ba8-87bb-45c3-a78c-7e33fd170cb9`  
**And** the event title "Test title" is displayed  
**And** the event date "10.25.2024" is displayed  
**And** the event image "https://cdn.pixabay.com/photo/2014/06/03/19/38/board-361516_640.jpg" is displayed  
**When** the event description "test" is displayed  
**Then** the event location "Test location" is displayed  

---

## Test Case 3: Successful Delete Event (PASS)

**Prerequisite:** User must be logged in and an event must already be created.  

**Given** the user is on the "Event" page `http://localhost:3000/events/00c43ba8-87bb-45c3-a78c-7e33fd170cb9`  
**And** the user clicks on the "Delete event" button  
**And** a window with the message "Are you sure you want to delete this event?" is displayed  
**And** the "Delete" button is displayed on the left side  
**And** the "No" button is displayed on the right side  
**When** the user clicks on the "Delete" button  
**Then** the user is redirected to the events page `http://localhost:3000/events`  
**And** the event is successfully deleted from the events page  

---

## Test Case 4: Unsuccessful Delete Event (PASS)

**Prerequisite:** User must be logged in and an event must already be created.  

**Given** the user is on the "Event" page `http://localhost:3000/events/00c43ba8-87bb-45c3-a78c-7e33fd170cb9`  
**And** the user clicks on the "Delete event" button  
**And** a window with the message "Are you sure you want to delete this event?" is displayed  
**And** the "Delete" button is displayed on the left side  
**And** the "No" button is displayed on the right side  
**When** the user clicks on the "No" button  
**Then** the user is redirected back to the event page `http://localhost:3000/events/00c43ba8-87bb-45c3-a78c-7e33fd170cb9`  

---

## Test Case 5: "Edit Event" Button (PASS)

**Prerequisite:** User must be logged in and an event must already be created.  

**Given** the user is on the edit event page `http://localhost:3000/events/00c43ba8-87bb-45c3-a78c-7e33fd170cb9`  
**When** the user clicks on the "Edit event" button  
**Then** the user is redirected to the edit event page `http://localhost:3000/events/{id}/edit`  

---

## Test Case 6: "Back to Events" Button (PASS)

**Prerequisite:** User must be logged in and an event must already be created.  

**Given** the user is on the event page `http://localhost:3000/events/00c43ba8-87bb-45c3-a78c-7e33fd170cb9`  
**When** the user clicks on the "Back to events" button  
**Then** the user is redirected to the events page `http://localhost:3000/events`  

---

## Test Case 7: "Update Event" Button (PASS)

**Prerequisite:** User must be logged in, an event must already be created, and the "Edit" button must be clicked.  

**Given** the user is on the edit event page `http://localhost:3000/events/00c43ba8-87bb-45c3-a78c-7e33fd170cb9`  
**And** the user enters "Test title 2024" into the "Event Title" field  
**And** the user enters "Test location 2024" into the "Location" field  
**When** the user clicks on the "Update event" button  
**Then** the user is redirected to the event page `http://localhost:3000/events/00c43ba8-87bb-45c3-a78c-7e33fd170cb9`  
**And** the "Event title" is updated to "Test title 2024"  
**And** the "Location" is updated to "Test location 2024"  