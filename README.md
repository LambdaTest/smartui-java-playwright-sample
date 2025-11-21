# SmartUI SDK Sample for Playwright Java

Welcome to the SmartUI SDK sample for Playwright Java. This repository demonstrates how to integrate SmartUI visual regression testing with Playwright Java.

## Prerequisites

- Java 10 or higher
- Maven 3.6 or higher
- Node.js (for SmartUI CLI)
- LambdaTest account credentials (for Cloud tests)
- Chrome browser (for Local tests)

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

## Quick Start

### Local Execution

1. **Clone the repository:**
   ```bash
   git clone https://github.com/LambdaTest/smartui-java-playwright-sample
   cd smartui-java-playwright-sample
   ```

2. **Build the project:**
   ```bash
   mvn clean compile
   ```

3. **Set your Project Token:**
   ```bash
   export PROJECT_TOKEN='your_project_token'
   ```

4. **Create SmartUI config:**
   ```bash
   npx smartui config:create smartui-web.json
   ```

5. **Run the test:**
   ```bash
   npx smartui exec -- mvn test -D suite=sdk-playwright-local-java.xml
   ```

### Cloud Execution

1. **Clone the repository:**
   ```bash
   git clone https://github.com/LambdaTest/smartui-java-playwright-sample
   cd smartui-java-playwright-sample
   ```

2. **Build the project:**
   ```bash
   mvn clean compile
   ```

3. **Set your credentials:**
   ```bash
   export LT_USERNAME='your_username'
   export LT_ACCESS_KEY='your_access_key'
   export PROJECT_TOKEN='your_project_token'
   ```

4. **Create SmartUI config:**
   ```bash
   npx smartui config:create smartui-web.json
   ```

5. **Run the test:**
   ```bash
   npx smartui exec -- mvn test -D suite=sdk-playwright-cloud-java.xml
   ```

## Dependencies

The project uses the following key dependencies (already configured in `pom.xml`):

- `com.microsoft.playwright:playwright` - Playwright Java library
- `io.github.lambdatest:lambdatest-java-playwright-sdk` - SmartUI SDK for Playwright Java
- `org.testng:testng` - TestNG testing framework

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
