# Test Cases

## Test Case 1: Successful Login (PASS)

**Prerequisite:** Email must be already registered.  

**Given** the user is on the login form `http://localhost:3000/auth?mode=login`  
**And** the user enters `"test@gmail.com"` into the "E-Mail" field  
**And** the user enters `"test123"` into the "Password" field  
**When** the user clicks the "Go" button  
**Then** the user is redirected to the home page `http://localhost:3000/`  
**And** the sign-up form is no longer visible  
**And** the hover button is displayed in the bottom right corner  

---

## Test Case 2: Unsuccessful Login (Invalid Email Format or Unregistered Email) (PASS)

**Given** the user is on the login page `http://localhost:3000/auth?mode=login`  
**And** the user enters `"test_testgmail.com"` into the "E-Mail" field  
**When** the user clicks the "Go" button  
**Then** the message "Authentication failed." is displayed  

---

## Test Case 3: Unsuccessful Login (Valid Email but Invalid Password) (PASS)

**Prerequisite:** Email must be already registered.  

**Given** the user is on the login page `http://localhost:3000/auth?mode=login`  
**And** the user enters `"test@gmail.com"` into the "E-Mail" field  
**And** the user enters `"test12345"` into the "Password" field  
**When** the user clicks the "Go" button  
**Then** an error with the message "Invalid email or password entered." is popped up  
**And** the message "Invalid credentials." is displayed  

---

## Test Case 4: "Create User" Button (PASS)

**Given** the user is on the login page `http://localhost:3000/auth?mode=login`  
**When** the user clicks the "Create User" button  
**Then** the "Create User" button text is changed to "Log in"  
**And** the "Log in" form title is changed to "Create User"  
**And** the user is redirected to the signup form `http://localhost:3000/auth?mode=signup`