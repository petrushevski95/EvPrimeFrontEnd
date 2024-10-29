# Acceptance Criteria

## Test Scenario 1: Successful Reach Out

**Given** the user is on the contact page `http://localhost:3000/contact`  
**And** the user enters a full name value into the "Full name" field  
**And** the user enters an email value into the "Email" field  
**And** the user enters a message value into the "Message" field  
**When** the user clicks the "Send" button  
**Then** the error message is successfully sent to the website developer

---

## Test Scenario 2: Unsuccessful Reach Out (Empty "Full Name" Field)

**Given** the user is on the contact page `http://localhost:3000/contact`  
**And** the user leaves the "Full name" field empty  
**And** the user enters an email value into the "Email" field  
**When** the user clicks the "Send" button  
**And** the "Full name" bottom border color of the field changes from black to blue  
**Then** an error message with the text "Please fill out this field." is displayed

---

## Test Scenario 3: Unsuccessful Reach Out (Empty "Email" Field)

**Given** the user is on the contact page `http://localhost:3000/contact`  
**And** the user enters a full name value into the "Full name" field  
**And** the user leaves the "Email" field empty  
**When** the user clicks the "Send" button  
**And** the "Email" bottom border color of the field changes from black to blue  
**Then** an error message with the text "Please fill out this field." is displayed

---

## Test Scenario 4: Unsuccessful Reach Out (Invalid Email Format "Without @")

**Given** the user is on the contact page `http://localhost:3000/contact`  
**And** the user enters a full name value into the "Full name" field  
**And** the user enters an invalid email value into the "Email" field  
**And** the "Email" field bottom border color changes to red  
**When** the user clicks the "Send" button  
**Then** an error message with the text "Please include '@' in the email address. 'entered email value' is missing an '@'." is displayed

---

## Test Scenario 5: Unsuccessful Reach Out (Invalid Email "Without Part Following '@' ")

**Given** the user is on the contact page `http://localhost:3000/contact`  
**And** the user enters a full name value into the "Full name" field  
**And** the user enters an invalid email value into the "Email" field  
**And** the "Email" field bottom border color changes to blue  
**When** the user clicks the "Send" button  
**Then** an error message with the text "Please enter a part following '@'. 'email value' is incomplete." is displayed

---

## Test Scenario 6: Unsuccessful Reach Out (Empty "Message" Field)

**Given** the user is on the contact page `http://localhost:3000/contact`  
**And** the user enters a full name value into the "Full name" field  
**And** the user enters an email value into the "Email" field  
**And** the user leaves the "Message" field empty  
**When** the user clicks the "Send" button  
**And** the "Message" bottom border color of the field changes from black to blue  
**Then** an error message with the text "Please fill out this field." is displayed
