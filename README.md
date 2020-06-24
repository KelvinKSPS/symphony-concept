# Symphony Concept

![Java CI with Gradle and JUnit](https://github.com/KelvinKSPS/symphony-concept/workflows/Java%20CI%20with%20Gradle%20and%20JUnit/badge.svg?branch=master)



* E2E Test Automation
* Browser/OS Strategy
* Custom Email PIN/Confirmation Handler
* Custom SMS Handler (ready)
* Continuous Integration - [Click here to see latest runs](https://github.com/KelvinKSPS/symphony-concept/actions/)

#

# Table of Contents

1. [Prerequisites](#prerequisites)
2. [Running Tests](#running-tests)
    1. [Command Line Interface](#command-line-interface)
    2. [Reporting](#reporting)
3. [Most Important Test Cases](#most-important-test-cases)
4. [Notes](#notes)
5. [Built With](#built-with)
6. [Contributing / Triggering CI Tests](#contributing)

# 
## Prerequisites

```
For running locally: Java SDK 1.8 && (Linux)
For running on docker: Any Docker image with Java 1.8
For running on github: Create a PR and the tests will run automatically
```

#

## Running Tests

We can run the test by using Gradle Wrapper. The tests are able to be run in Chrome (83) and Firefox. This project also supports headless mode - running automated tests without using System UI.

### Command Line Interface

You can run the tests using the following command:

```
./gradlew build -Dbrowser="${BROWSER}" -Dheadless="${HEADLESS_OPTION}"
```

Where

```
BROWSER => The browser to be used by test. Currently, it could be 'chrome' or 'firefox'.

HEADLESS_OPTION => true or false for headless run.
```

### Example


```
./gradlew build -Dbrowser="chrome" -Dheadless="true"
```

It will run on chrome using headless mode.


#
### Reporting

18 tests are automated. The report / JUnit pattern is using `Should`/`When` style.

Currently this is set to show the results inline.
For detailed result, check `build/reports/tests/test/index.html` inside the project folder or inside the artifact generated after CI Tests.

Example for `inline` reporting:

<pre><b>&gt; Task :test</b>

<b>Symphony.WebApp.ResetPassPageTests</b>

<b>  Test </b>Should_DisplaySignInPage_When_ClickingOnCancel<font color="#4E9A06"> PASSED</font><font color="#CC0000"> (4.2s)</font>
<b>  Test </b>Should_DisplayToCheckCaptcha_When_FillingValidEmailAndConfirming<font color="#4E9A06"> PASSED</font><font color="#CC0000"> (4.9s)</font>
<b>  Test </b>Should_DisplayToInputEmail_When_FillingInvalidEmail<font color="#4E9A06"> PASSED</font><font color="#CC0000"> (2.8s)</font>

<b>Symphony.WebApp.SignUpPageTests</b>

<b>  Test </b>Should_NotProceedToSecondScreen_When_FillingValidValuesAndInvalidEmail<font color="#4E9A06"> PASSED</font><font color="#CC0000"> (5.9s)</font>
<b>  Test </b>Should_NotProceedToSecondScreen_When_FillingValidValuesAndInvalidPassword<font color="#4E9A06"> PASSED</font><font color="#CC0000"> (3.4s)</font>
<b>  Test </b>Should_CheckAllSecurityChecks_When_FillingAValidPassword<font color="#4E9A06"> PASSED</font><font color="#CC0000"> (5.2s)</font>
<b>  Test </b>Should_NotProceedToSecondScreen_When_FillingValidValuesAndInvalidLastName<font color="#4E9A06"> PASSED</font><font color="#CC0000"> (5.5s)</font>
<b>  Test </b>Should_NotProceedToSecondScreen_When_FillingValidValuesAndInvalidFirstName<font color="#4E9A06"> PASSED</font><font color="#CC0000"> (3.9s)</font>
<b>  Test </b>Should_CheckSpecialCase_When_FillingAValidAndInvalidPassword<font color="#4E9A06"> PASSED</font><font color="#CC0000"> (3.2s)</font>
<b>  Test </b>Should_CheckUpperCase_When_FillingAValidAndInvalidPassword<font color="#4E9A06"> PASSED</font><font color="#CC0000"> (3.3s)</font>
<b>  Test </b>Should_CheckNumberCase_When_FillingAValidAndInvalidPassword<font color="#4E9A06"> PASSED</font><font color="#CC0000"> (3.3s)</font>
<b>  Test </b>Should_CheckLowerCase_When_FillingAValidAndInvalidPassword<font color="#4E9A06"> PASSED</font><font color="#CC0000"> (5s)</font>

<b>Symphony.WebApp.FullIntegrationTests</b>

<b>  Test </b>Should_CreateAccount_When_FillingAllFieldsAndValidateEmailAndSMS<font color="#4E9A06"> PASSED</font><font color="#CC0000"> (43.2s)</font>

<b>Symphony.WebApp.SignInPageTests</b>

<b>  Test </b>Should_DisplayEnglishMessage_When_SelectingLanguageAsEnglishAfterItWasFrench<font color="#4E9A06"> PASSED</font><font color="#CC0000"> (3.3s)</font>
<b>  Test </b>Should_DisplayJapaneseMessage_When_SelectingLanguageAsJapanese<font color="#4E9A06"> PASSED</font><font color="#CC0000"> (4.8s)</font>
<b>  Test </b>Should_DisplayFrenchMessage_When_SelectingLanguageAsFrench<font color="#4E9A06"> PASSED</font><font color="#CC0000"> (4.8s)</font>
<b>  Test </b>Should_DisplayErrorMessage_When_LoginWithoutParameters<font color="#4E9A06"> PASSED</font><font color="#CC0000"> (2.7s)</font>
<b>  Test </b>Should_OpenPasswordPageWithRecoverPasswordButton_When_ClickingPasswordLink<font color="#4E9A06"> PASSED</font><font color="#CC0000"> (2.7s)</font>

<font color="#8AE234"><b>SUCCESS: </b></font><b>Executed 18 tests in 1m 53s</b>


</pre>
#

## Most Important Test Cases

As requested, the most important test cases and the priorities.

Table of priorities

| Priority P    |  Definition|
| :-------------: |:-------------:| 
| P0            | critical      | 
| P1            | major         | 
| P2            | medium        | 
| P3            | minor        | 


[Click here to access the Document](https://docs.google.com/spreadsheets/d/1n6v_yfHQ5lDrcMHfSU6pgaccQP3cBnX0ZOf6QnaLjNU/edit?usp=sharing)

#
## Notes

* The automation supports Firefox, but the webapp under testing from symphony does not, what will fail all tests if running using Firefox;
* For the reason above, the CI tests are running against Google Chrome;
* Available on Windows, but currently not able to test on it. Usually we need to do some `PATH` and specific configurations. A Script for configuring a Windows machine would be a good deal. For *forcing* testing on windows, use `-DforceWindows="true"`
 
#
## Built With

* [Java 1.8](www.java.com) - Programming Language
* [Gradle 5.+](gradle.org) - Build Framework
* [JUnit 4.+](junit.org) - Test Management Framework
* [Selenium 3.+](selenium.dev) - Web Automation Framework
* [Docker](docker.com) - Container Tool
* [GitHub Actions](github.com/features/actions) - Workflow Setup / CI-CD Toolset

#
## Contributing

Feel free to create `Pull Requests` to test the CI Feature.
