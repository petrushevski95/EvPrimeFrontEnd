# Acceptance Criteria

## Test Scenario 1: Slider Menu "<" (Close Button)
**Given** the user is on the home page at `http://localhost:3000/`  
**And** there is a slider menu button in the top left corner  
**And** the user clicks on the "Slider menu" button  
**And** the slider menu appears  
**And** there is a "Home" button text displayed  
**And** there is an "Events" button text displayed  
**And** there is a "Contact" button text displayed  
**And** there is a "Login" button text displayed  
**When** the user clicks the "<" button  
**Then** the slider menu is closed  

---

## Test Scenario 2: "Home" Button 
**Given** the user is on the events page `http://localhost:3000/events`  
**When** the user clicks on the "Home" button  
**Then** the user is redirected to the home page `http://localhost:3000/`  

---

## Test Scenario 3: "Events" Button 
**Given** the user is on the home page `http://localhost:3000/`  
**When** the user clicks on the "Events" button  
**Then** the user is redirected to the events page `http://localhost:3000/events`  

---

## Test Scenario 4: "Contact" Button 
**Given** the user is on the home page `http://localhost:3000/`  
**When** the user clicks on the "Contact" button  
**Then** the user is redirected to the contact page `http://localhost:3000/contact`  

---

## Test Scenario 5: "Login" Button 
**Given** the user is on the home page `http://localhost:3000/`  
**When** the user clicks on the "Login" button  
**Then** the user is redirected to the login page `http://localhost:3000/auth?mode=login` 