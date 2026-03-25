# 🛒 Amazon Add-To-Cart Automation Framework

A robust Selenium-based automation framework designed for end-to-end testing of the **Amazon.in** shopping experience. This project implements the **Page Object Model (POM)** and **Data-Driven Testing** to ensure high maintainability and scalability.

---

## 🚀 Project Overview

This automation suite handles the complex UI workflows of Amazon, including:
* **Product Search:** Dynamic searching via `config.properties`.
* **Window Handling:** Managing new tabs when opening product details.
* **Popup Management:** Handling warranty and side-panel overlays using **JavaScript Executor**.
* **Cart Validation:** Real-time extraction and assertion of cart subtotal values.

## 🛠️ Tech Stack

| Component | Technology |
| :--- | :--- |
| **Language** | Java 8+ |
| **Automation** | Selenium WebDriver |
| **Test Framework** | TestNG |
| **Build Tool** | Maven |
| **Data Handling** | Apache POI (Excel) |
| **Driver Management** | WebDriverManager |
| **Utilities** | JavaScript Executor & WebDriverWait |

---

## 📂 Project Structure

```text
AmazonCartAutomation/
├── src/main/java/
│   ├── base/           # DriverSetup.java (Initialization & Teardown)
│   ├── page/           # Page Objects (HomePage, ProductPage, CartPage)
│   └── utils/          # ExcelUtils.java (Data-Driven Logic)
├── src/test/java/
│   └── testcases/      # Test Scripts (MainTest, TC_AmazonCartTest)
├── resources/          
│   ├── config.properties # Environment Configurations
│   └── testng.xml       # Test Suite Execution
└── test-output/        # Generated Test Reports

```
**🏃 How to Run**
**1. Using Maven (Command Line)**
Bash
mvn clean test
**2. Using TestNG XML**
Right-click src/test/resources/testng.xml and select Run as TestNG Suite.

**📊 Test Reporting**
Comprehensive execution reports are automatically generated after every run in the test-output/ directory:

index.html - Full interactive report.

emailable-report.html - Summary report for stakeholders.

**📋 Prerequisites**
**Java:** JDK 8 or higher

**Build Tool:** Maven 3.6+

**IDE:** IntelliJ IDEA or Eclipse

Browser: Latest version of Chrome/Firefox/Edge


