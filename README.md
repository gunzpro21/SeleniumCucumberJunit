# Don't hesitate to give me a ⭐ to make the project more popular.
# Selenium Complete Example
- This framework for automation in checking Website using Selenium, Cucumber and Junit 4. [You can reach me](https://github.com/gunzpro21/gunzpro21). 
- The framework has following features
1.	Modular Design
2.	Maven based framework
3.	Log4j2 enabled for logging
4.	Report Generation (Extent-reporting)
5.	Helper class to handle web component such as (Button, Wait,... etc)
6.	Using gherkin to develop feature files
7.	Centralized Configuration (Using Properties file)
8.	POM
9.	LOMBOK
10.	Page Factory
11.	Screen shot at the end of every scenario
> :warning: Note
> 
> What is automation in testing? The Web is abuzz with talk about “automated testing” and “test automation”. Automation comes with a tasty and digestible story: eliminate “manual testing”, and replace messy, complex humanity with reliable, fast, efficient robots! [Testing can not be automated and automate all your test cases does not give you a full status of your product](https://developsense.com/blog/2019/12/the-secret-life-of-automation). [Heuristics of GUI Automation Tools](https://developsense.com/blog/2007/08/heuristics-of-gui-automation-tools) give you a better approach to automation. [The Round Earth model](https://www.satisfice.com/blog/archives/4947) guides you what you need to spend your effort  for automation in testing.
>
> What is BDD? You are trying to automate test cases with a supporting tool to write some tests with human natural language, BDD does not look like that. You should [Learn about BDD, VisualTest and Approval Testing](https://cucumber.io/blog/bdd/bdd-approval-testing-and-visualtest/), it will help you what is BDD and how to use it correctly. Andy Knight has written a [Better behavior-driven development: 4 rules for writing good Gherkin](https://techbeacon.com/app-dev-testing/better-behavior-driven-development-4-rules-writing-good-gherkin).
## Required software
* [Java 1.8+ installed](https://phoenixnap.com/kb/install-java-windows)
* [Maven Installed](https://mkyong.com/maven/how-to-install-maven-in-windows/)
* [Enable LOMBOK plugin on your IDE](https://www.baeldung.com/lombok-ide)
## How to execute the tests
### Runner:
- You can open the RunnerTest on src\test\java\runners and change the feature you want to execute, but I recommend you run it by the command line. It enables us to run in different test execution strategies and, also in a pipeline, that is the repo purpose.
### Command line:
mvn -Dtest=RunnerTest test
## Cucumber Report
Over view:
![image](https://user-images.githubusercontent.com/27693044/228492135-c6147027-d5e4-402d-99f6-1babed362458.png)
Detail page:
![image](https://user-images.githubusercontent.com/27693044/228492358-a0b82ec6-9d95-41db-8e84-a1ac15a95c8f.png)
Screeshot of a scenario:
![image](https://user-images.githubusercontent.com/27693044/228492539-63ac26b5-e9db-49c6-a084-d18f3be43d81.png)
