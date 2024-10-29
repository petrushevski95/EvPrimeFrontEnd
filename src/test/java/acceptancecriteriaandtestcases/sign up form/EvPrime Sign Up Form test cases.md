# Test Cases

## Test Case 1: Successful Signup (PASS)
**Prerequisite:** "Create User" button must be clicked on the login form.  
**Given** user is on the sign up form `http://localhost:3000/auth?mode=signup`  
**And** user enters "test@gmail.com" into the "E-Mail" field  
**And** user enters "test123" into the "Password" field  
**When** user clicks "Go" button  
**Then** user is redirected to the home page `http://localhost:3000/`  
**And** the sign-up form is no longer visible  

---

## Test Case 2: Unsuccessful Signup (Invalid Email Format but Valid Password) (PASS)
**Prerequisite:** "Create User" button must be clicked on the login form.  
**Given** user is on the sign up form `http://localhost:3000/auth?mode=signup`  
**And** user enters "test_testgmail.com" into the "E-Mail" field  
**And** user enters "test123" into the "Password" field  
**When** user clicks "Go" button  
**Then** an error with message "Invalid email." is popped up  
**And** "User signup failed due to validation errors." is displayed  

---

## Test Case 3: Unsuccessful Signup (Invalid Email Format and Invalid Password) (PASS)
**Prerequisite:** "Create User" button must be clicked on the login form.  
**Given** user is on the sign up form `http://localhost:3000/auth?mode=signup`  
**And** user enters "test_testgmail.com" into the "E-Mail" field  
**And** user enters "test" into the "Password" field  
**When** user clicks "Go" button  
**Then** an error with message "Invalid email." is popped up  
**And** another error message "Invalid password. Must be at least 6 characters long." is popped up  
**And** "User signup failed due to validation errors." is displayed  

---

## Test Case 4: Unsuccessful Signup (Existing Email) (PASS)
**Prerequisite:** "Create User" button must be clicked on the login form and email must be registered.  
**Given** user is on the sign up form `http://localhost:3000/auth?mode=signup`  
**And** user enters "test@gmail.com" into the "E-Mail" field  
**And** user enters "password123" into the "Password" field  
**When** user clicks "Go" button  
**Then** an error with message "Email exists already." is popped up  
**And** "User signup failed due to validation errors." is displayed  

---

## Test Case 5: Unsuccessful Signup (Existing Email and Invalid Password) (PASS)
**Prerequisite:** "Create User" button must be clicked on the login form and email must be registered.  
**Given** user is on the sign up page `http://localhost:3000/auth?mode=signup`  
**And** user enters "test@gmail.com" into the "E-Mail" field  
**And** user enters "test" into the "Password" field  
**When** user clicks "Go" button  
**Then** an error with message "Email exists already." is popped up  
**And** another error message "Invalid password. Must be at least 6 characters long." is popped up  
**And** "User signup failed due to validation errors." is displayed  

---

## Test Case 6: Unsuccessful Signup (Valid Email and Invalid Password) (PASS)
**Prerequisite:** "Create User" button must be clicked on the login form.  
**Given** user is on the sign up form `http://localhost:3000/auth?mode=signup`  
**And** user enters "test_test@gmail.com" into the "E-Mail" field  
**And** user enters "test" into the "Password" field  
**And** user clicks "Go" button  
**Then** an error with message "Invalid password. Must be at least 6 characters long." is popped up  
**And** "User signup failed due to validation errors." is displayed  

---

## Test Case 7: "Log In" Button (PASS)
**Given** user is on the sign up form `http://localhost:3000/auth?mode=signup`  
**When** user clicks the "Log in" button  
**Then** "Log in" button text is changed to "Create User"  
**And** "Create User" form title is changed to "Log in"  
**And** user is redirected to the login form `http://localhost:3000/auth?mode=login` 