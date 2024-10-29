# Test Cases

## Test Case 1: Successful Create an Event (PASS)

**Prerequisite:** User must be logged in and the "Create an Event" button must be clicked.  

**Given** the user is on the new event page `http://localhost:3000/events/new`  
**And** the create event form is displayed  
**And** the user enters `"Test title 2024"` into the "Event Title" field  
**And** the user enters `"https://cdn.pixabay.com/photo/2014/06/03/19/38/board-361516_640.jpg"` into the "Event Image" field  
**And** the user enters `"10.25.2024"` into the "Event Date" field  
**And** the user enters `"Test location 2024"` into the "Event Location" field  
**And** the user enters `"test"` into the "Event Description" field  
**When** the user clicks on the "Create Event" button  
**Then** the user is redirected to the events page `http://localhost:3000/events`  
**And** the event image `"https://cdn.pixabay.com/photo/2014/06/03/19/38/board-361516_640.jpg"` is displayed on the events page  
**And** the test title `"Test title 2024"` is displayed at the bottom of the event image  
**And** the test date `"10.25.2024"` is displayed at the bottom of the event image 