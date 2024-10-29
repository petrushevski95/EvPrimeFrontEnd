# Test Cases

## Test Case 1: Successful Reach Out (PASS)

**Given** the user is on the contact page `http://localhost:3000/contact`  
**And** the user enters "Test full name" into the "Full name" field  
**And** the user enters "test@gmail.com" into the "Email" field  
**And** the user enters "Test message" into the "Message" field  
**When** the user clicks the "Send" button  
**Then** the error message is successfully sent to the website developer  

---

## Test Case 2: Unsuccessful Reach Out (Empty "Full Name" Field) (PASS)

**Given** the user is on the contact page `http://localhost:3000/contact`  
**And** the user leaves the "Full name" field empty  
**And** the user enters "test@gmail.com" into the "Email" field  
**When** the user clicks the "Send" button  
**And** the "Full name" bottom border color of the field is changed from black to blue  
**Then** an error message with the text "Please fill out this field." is displayed on the field  

---

## Test Case 3: Unsuccessful Reach Out (Empty "Email" Field) (PASS)

**Given** the user is on the contact page `http://localhost:3000/contact`  
**And** the user enters "Test full name" into the "Full name" field  
**And** the user leaves the "Email" field empty  
**When** the user clicks the "Send" button  
**And** the "Email" bottom border color of the field is changed from black to blue  
**Then** an error message with the text "Please fill out this field." is displayed  

---

## Test Case 4: Unsuccessful Reach Out (Invalid Email Format "Without '@' ") (PASS)

**Given** the user is on the contact page `http://localhost:3000/contact`  
**And** the user enters "Test full name" into the "Full name" field  
**And** the user enters "testgmail.com" into the "Email" field  
**And** the "Email" field bottom border color is changed to red  
**When** the user clicks the "Send" button  
**Then** an error message with the text "Please include '@' in the email address. 'testgmail.com' is missing an '@'." is displayed  

---

## Test Case 5: Unsuccessful Reach Out (Invalid Email "Without Part Following @") (PASS)

**Given** the user is on the contact page `http://localhost:3000/contact`  
**And** the user enters "Test full name" into the "Full name" field  
**And** the user enters "@mail.com" into the "Email" field  
**And** the "Email" field bottom border color is changed to blue  
**When** the user clicks the "Send" button  
**Then** an error message with the text "Please enter a part following '@'. '@mail.com' is incomplete." is displayed  

---

## Test Case 6: Unsuccessful Reach Out (Empty "Message" Field) (PASS)

**Given** the user is on the contact page `http://localhost:3000/contact`  
**And** the user enters "Test full name" into the "Full name" field  
**And** the user enters "test@gmail.com" into the "Email" field  
**And** the user leaves the "Message" field empty  
**When** the user clicks the "Send" button  
**And** the "Message" bottom border color of the field is changed from black to blue  
**Then** an error message with the text "Please fill out this field." is displayed 