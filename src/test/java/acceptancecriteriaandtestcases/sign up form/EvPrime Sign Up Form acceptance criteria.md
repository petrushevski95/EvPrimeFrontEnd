# Acceptance Criteria

## Test Scenario 1: Successful Signup
**Prerequisite:** "Create User" button must be clicked on the login form.  
**Given** user is on the sign up form `http://localhost:3000/auth?mode=signup`  
**When** user enters a valid email  
**And** user enters a valid password  
**And** clicks the "Go" button  
**Then** user is redirected to the home page `http://localhost:3000/`  

---

## Test Scenario 2: Unsuccessful Signup (Invalid Email Format but Valid Password)
**Prerequisite:** "Create User" button must be clicked on the login form.  
**Given** user is on the sign up form `http://localhost:3000/auth?mode=signup`  
**When** user enters an invalid email  
**And** user enters a valid password  
**And** clicks the "Go" button  
**Then** an error with message "Invalid email." is popped up  
**And** "User signup failed due to validation errors." is displayed  

---

## Test Scenario 3: Unsuccessful Signup (Invalid Email Format and Invalid Password)
**Prerequisite:** "Create User" button must be clicked on the login form.  
**Given** user is on the sign up form `http://localhost:3000/auth?mode=signup`  
**When** user enters an invalid email  
**And** user enters an invalid password  
**And** clicks the "Go" button  
**Then** an error with message "Invalid email." is popped up  
**And** another error message "Invalid password. Must be at least 6 characters long." is popped up  
**And** "User signup failed due to validation errors." is displayed  

---

## Test Scenario 4: Unsuccessful Signup (Existing Email)
**Prerequisite:** "Create User" button must be clicked on the login form and email must be registered.  
**Given** user is on the sign up form `http://localhost:3000/auth?mode=signup`  
**When** user enters an existing email  
**And** user enters a valid password  
**And** clicks the "Go" button  
**Then** an error with message "Email exists already." is popped up  
**And** "User signup failed due to validation errors." is displayed  

---

## Test Scenario 5: Unsuccessful Signup (Existing Email and Invalid Password)
**Prerequisite:** "Create User" button must be clicked on the login form and email must be registered.  
**Given** user is on the sign up page `http://localhost:3000/auth?mode=signup`  
**And** user enters an existing email  
**And** user enters an invalid password  
**When** user clicks the "Go" button  
**Then** an error with message "Email exists already." is popped up  
**And** another error message "Invalid password. Must be at least 6 characters long." is popped up  
**And** "User signup failed due to validation errors." is displayed  

---

## Test Scenario 6: Unsuccessful Signup (Valid Email and Invalid Password)
**Prerequisite:** "Create User" button must be clicked on the login form.  
**Given** user is on the sign up form `http://localhost:3000/auth?mode=signup`  
**When** user enters a valid email  
**And** user enters an invalid password  
**And** clicks the "Go" button  
**Then** an error with message "Invalid password. Must be at least 6 characters long." is popped up  
**And** "User signup failed due to validation errors." is displayed  

---

## Test Scenario 7: "Log in" Button
**Given** user is on the sign up form `http://localhost:3000/auth?mode=signup`  
**When** user clicks the "Log in" button  
**Then** "Log in" button text is changed to "Create User"  
**And** "Create User" form title is changed to "Log in"  
**And** user is redirected to the login form `http://localhost:3000/auth?mode=login` 