# Acceptance Criteria

## Test Scenario 1: Successful Login

**Prerequisite:** Email must be already registered.  

**Given** the user is on the login form `http://localhost:3000/auth?mode=login`  
**And** the user enters a valid email  
**And** the user enters a valid password  
**When** the user clicks the "Go" button  
**Then** the user is redirected to the home page `http://localhost:3000/`  
**And** the hover button is displayed in the bottom right corner  

---

## Test Scenario 2: Unsuccessful Login (Invalid Email Format or Unregistered Email)

**Given** the user is on the login page `http://localhost:3000/auth?mode=login`  
**And** the user enters an invalid email format (missing "@" or ".com")  
**When** the user clicks the "Go" button  
**Then** the message "Authentication failed." is displayed  

---

## Test Scenario 3: Unsuccessful Login (Invalid Email or Password)

**Prerequisite:** Email must be already registered.  

**Given** the user is on the login page `http://localhost:3000/auth?mode=login`  
**And** the user enters an invalid email  
**When** the user clicks the "Go" button  
**Then** an error with the message "Invalid email or password entered." is popped up  
**And** the message "Invalid credentials." is displayed  

---

## Test Scenario 4: "Create User" Button 

**Given** the user is on the login page `http://localhost:3000/auth?mode=login`  
**When** the user clicks the "Create User" button  
**Then** the "Create User" button text is changed to "Log in"  
**And** the "Log in" form title is changed to "Create User"  
**And** the user is redirected to the signup form `http://localhost:3000/auth?mode=signup`