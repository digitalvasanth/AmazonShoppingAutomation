🛒 Project Title
Amazon Shopping – Add to Cart Automation & Order Amount Validation

📌 Project Overview
This Selenium automation mini‑project automates the online shopping workflow on Amazon.in.
The script performs:

Launching browser (Chrome/Edge/Firefox)
Navigating to Amazon
Searching for the product “Home appliances”
Selecting the first product
Adding product to cart
Reading the order amount
Adding another item
Validating the updated cart amount
Closing the browser

This project follows Page Object Model (POM), Data‑Driven Testing, Reusable Components, and Multi‑browser Execution as required.

🎯 Mini Project Requirements & Implementation
This project follows all mandatory guidelines:
✔ Multi‑browser Support
Supports Chrome, Edge, Firefox using WebDriverManager.
✔ Data‑Driven
Input “Home appliances” read via:

testdata.xlsx (Apache POI)
config.properties

✔ POM (Page Object Model)
Pages implemented:

HomePage.java
ProductPage.java
CartPage.java

✔ Reusable Methods

Browser init → DriverFactory.java
Launch & teardown → BaseTest.java
Excel reading → ExcelUtils.java

✔ Synchronization
Thread waits used (can be replaced with WebDriverWait).
✔ Exception Handling
Try–catch used in utilities.
✔ ID/Name Locators
Avoided XPath where possible (Amazon supports ID for search & cart).
✔ Relative Paths
All files use relative paths like:
src/main/resources/config.properties

✔ Test Results
Results printed to console output.

🏗️ Tech Stack

Programming Language: Java
Automation Tool: Selenium WebDriver
Testing Framework: TestNG
Build Tool: Maven
Browser Driver Management: WebDriverManager
Data‑Driven Library: Apache POI
Framework Design: Page Object Model (POM)
Configuration Management: Properties File
Development Environment: Eclipse IDE



📁 Project Structure
AmazonAutomation/
 ├── pom.xml
 ├── src
 │   ├── main
 │   │    ├── java
 │   │    │    ├── base
 │   │    │    │     BaseTest.java
 │   │    │    │     DriverFactory.java
 │   │    │    ├── pages
 │   │    │    │     HomePage.java
 │   │    │    │     ProductPage.java
 │   │    │    │     CartPage.java
 │   │    │    └── utils
 │   │    │          ExcelUtils.java
 │   │    └── resources
 │   │         config.properties
 │   │         testdata.xlsx
 │   └── test
 │        ├── java
 │        │      └── testcases
 │        │            TC_AmazonCartTest.java
 │        └── resources
 │               testng.xml
 └── README.md


⚙️ Configuration Settings
config.properties
browser=chrome
url=https://www.amazon.in/
searchItem=Home appliances

Change browser to edge or firefox anytime.

📊 Excel Input (testdata.xlsx)
SearchItem
Home appliances



▶️ How to Run the Automation
Method 1: Run through testng.xml (Recommended)

Right‑click testng.xml
Click Run As → TestNG Suite


Method 2: Run the test directly
Right‑click:
TC_AmazonCartTest.java → Run As → TestNG Test


Method 3: Run using Maven
mvn clean test


🔍 Validation Logic
After adding the second item:
updatedAmount >= firstAmount

If increased → Test PASS
Else → Test FAIL

🤖 Used Design Patterns

Page Object Model (POM)
Data‑Driven Framework
Factory Pattern (DriverFactory)
Configuration Management
TestNG Annotations


🛡️ Exception Handling
Handled in:

ExcelUtils
DriverFactory
BaseTest

Meaningful error messages logged to console.

🏆 Why This Project is Industry Standard
✔ Clean folder structure
✔ Reusable components
✔ Multi-browser support
✔ Data driven
✔ POM framework
✔ Separation of concerns
✔ Easy maintenance
✔ TestNG integration
✔ Maven dependencies fully automated
