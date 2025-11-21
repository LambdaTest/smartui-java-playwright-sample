# SmartUI SDK Sample for Playwright Java

Welcome to the SmartUI SDK sample for Playwright Java. This repository demonstrates how to integrate SmartUI visual regression testing with Playwright Java.

## Repository Structure

```
smartui-java-playwright-sample/
├── src/
│   └── test/
│       └── java/
│           └── com/
│               └── lambdatest/
│                   ├── SmartUISDKPlaywrightCloud.java    # Cloud test
│                   └── SmartUISDKPlaywrightLocal.java      # Local test
├── sdk-playwright-cloud-java.xml                          # TestNG suite for Cloud
├── sdk-playwright-local-java.xml                          # TestNG suite for Local
├── pom.xml                                                 # Maven dependencies
└── smartui-web.json                                        # SmartUI config (create with npx smartui config:create)
```

## 1. Prerequisites and Environment Setup

### Prerequisites

- Java 10 or higher
- Maven 3.6 or higher
- Node.js (for SmartUI CLI)
- LambdaTest account credentials (for Cloud tests)
- Chrome browser (for Local tests)

### Environment Setup

**For Cloud:**
```bash
export LT_USERNAME='your_username'
export LT_ACCESS_KEY='your_access_key'
export PROJECT_TOKEN='your_project_token'
```

**For Local:**
```bash
export PROJECT_TOKEN='your_project_token'
```

## 2. Initial Setup and Dependencies

### Clone the Repository

```bash
git clone https://github.com/LambdaTest/smartui-java-playwright-sample
cd smartui-java-playwright-sample
```

### Install Dependencies

The repository already includes the required dependencies in `pom.xml`. Build the project to download dependencies:

```bash
mvn clean compile
```

**Dependencies included:**
- `com.microsoft.playwright:playwright` - Playwright Java library
- `io.github.lambdatest:lambdatest-java-playwright-sdk` - SmartUI SDK for Playwright Java
- `org.testng:testng` - TestNG testing framework

### Create SmartUI Configuration

```bash
npx smartui config:create smartui-web.json
```

## 3. Steps to Integrate Screenshot Commands into Codebase

The SmartUI screenshot function is already implemented in the repository.

**Cloud Test** (`src/test/java/com/lambdatest/SmartUISDKPlaywrightCloud.java`):
```java
page.navigate("https://www.lambdatest.com");
SmartUISnapshot.smartuiSnapshot(page, "screenshot");
```

**Local Test** (`src/test/java/com/lambdatest/SmartUISDKPlaywrightLocal.java`):
```java
page.navigate("https://www.lambdatest.com");
SmartUISnapshot.smartuiSnapshot(page, "screenshot");
```

**Note**: The code is already configured and ready to use. You can modify the URL and screenshot name if needed.

## 4. Execution and Commands

### Local Execution

```bash
npx smartui exec -- mvn test -D suite=sdk-playwright-local-java.xml
```

### Cloud Execution

```bash
npx smartui exec -- mvn test -D suite=sdk-playwright-cloud-java.xml
```

## Test Files

### Cloud Test (`SmartUISDKPlaywrightCloud.java`)

- Connects to LambdaTest Cloud using CDP (Chrome DevTools Protocol)
- Reads credentials from environment variables (`LT_USERNAME`, `LT_ACCESS_KEY`)
- Takes screenshot with name: `screenshot`

### Local Test (`SmartUISDKPlaywrightLocal.java`)

- Runs Playwright locally using Chromium
- Requires Chrome browser installed
- Takes screenshot with name: `screenshot`

## View Results

After running the tests, visit your SmartUI project dashboard to view the captured screenshots and compare them with baseline builds.

## More Information

For detailed onboarding instructions, see the [SmartUI Playwright Java Onboarding Guide](https://www.lambdatest.com/support/docs/smartui-onboarding-playwright-java/).
