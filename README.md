#  🚀 DemoQA Selenium POM Framework

This project is a Selenium Java automation framework built using the Page Object Model (POM) design pattern. It automates different UI components from the DemoQA website and is structured to be clean, reusable, and easy to maintain.

---

## 🛠 Tech Stack

- Java  
- Selenium WebDriver  
- TestNG  
- Maven  
- Extent Reports  

---

## 📁 Project Structure

```
ElementMasterWebsite
│
├── src/main/java
│   ├── base            # Common reusable methods
│   ├── pages           # Page Object classes
│   └── utils           # Utility classes (helpers, reusable methods)
│
├── src/test/java
│   ├── base            # Test base setup
│   ├── listeners       # TestNG listeners (screenshot and reporting logic)
│   ├── tests           # Test classes
│   └── utils           # Retry logic
│
├── src/test/resources
│   ├── testdata        # Excel test data
│   └── config.properties  # Configuration file
│
├── reports             # Extent report
├── screenshots         # Screenshots captured on failure
├── pom.xml             # Maven dependencies
└── testng.xml          # Test execution file

```

---

## ✨ Features Implemented

- Page Object Model (POM) design  
- Data-driven testing using DataProvider  
- Retry mechanism for failed tests  
- Screenshot capture on failure  
- Extent Reports for test reporting  
- Parallel execution using TestNG  
- WebDriverWait for dynamic elements  

---

## 🧪 Test Coverage

The framework automates the following modules from DemoQA:

## Forms
- Fill form and submit  
- Validate input handling  

### Web Tables
- Add, edit, delete records  
- Search functionality  

### Alerts & Windows
- Handle alerts (accept, dismiss, prompt)  
- Switch between tabs/windows  

### Frames
- Handle iframe and nested iframe  
- Switch back to main page  

### Widgets
- Date Picker  
- Slider  
- Accordion  

---

## 👩‍💻 Author

Vaishnavi

---
## 🏁 Conclusion

This framework provides a structured and scalable solution for UI test automation using Selenium and TestNG. By following the Page Object Model and best practices like reusable components, proper test separation, and efficient wait strategies, it ensures maintainability and reliability.

---

## ▶️ How to Run

Run all tests using Maven:

```bash
mvn test
