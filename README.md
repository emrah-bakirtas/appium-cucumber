Technologies Covered in This Project
====================================

# Cucumber
[Cucumber](https://cucumber.io/) is a tool for running automated tests written in plain language. Because they're written in plain language, they can be read by anyone on your team. Because they can be read by anyone, you can use them to help improve communication, collaboration and trust on your team.

# BrowserStack
[BrowserStack](https://www.browserstack.com/) is a live, web-based browser testing tool. Instant access to all desktop and mobile browsers. 

# maven-cucumber-reporting
[maven-cucumber-reporting](https://github.com/damianszczepanik/cucumber-reporting)  is a Java report publisher primarily created to publish cucumber reports on the Jenkins build server. It publishes pretty html reports with charts showing the results of cucumber runs.

Building and Running the Project
=============================

## Prerequisites
There are a few things needed before you run the tests. Make sure you have the latest versions of the following installed:
- [Java Development Kit](http://www.oracle.com/technetwork/java/javase/downloads/index.html)
- [Maven](https://maven.apache.org/)

#### Note
- Scenarios (in Gerkhin) are in appium-cucumber\src\test\resources\features.

## Setup
1. Clone the repo
2. Install dependencies with `mvn install`

## Run tests
#### First, you will need to set two environments (shown below) to your machine for accessing to browserstack
    Env Name : BROWSERSTACK_ACCESSKEY, Env Value : <Your Browserstack Access Key>
    Env Name : BROWSERSTACK_USERNAME, Env Value : <Your Browserstack Username>

1. Run all test with `mvn test`

2. Run only smoke test with `mvn test -Dcucumber.options="--tags @smoke"`
    #### Note for first 2 steps
    - You can view the default cucumber report in target/site/cucumber-report/index.html file

3. Run `mvn verify` or `mvn verify -Dcucumber.options="--tags @smoke"` to generate pretty html report with maven-cucumber-reporting    
    #### Note
    - You can view the cucumber report in target/cucumber-reports/cucumber-html-reports/index.html directory

#### Notes for running tests on BrowserStack
- You can view your test results on the [BrowserStack automate dashboard](https://app-automate.browserstack.com/)
