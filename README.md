Selenium-Java-Gradle test automation to add a bank account to xero
===================
Required : JDK 1.8, Intellij/Eclipse, Chrome Driver
### Steps to follow
 * Open the terminal and go to the location where you want to save this project
 * Copy the link to clone this repo
 * Use command git clone copiedlinkabove
 * Now open the project using intellij 
 * In UserStepsDefinition.java line 29: change the location of the chrome driver to reflect one on your machine
 * Create a new Junit Run/Debug config in intellij with following
 * Name: TestRunnerConfig
 * Class: TestRunner.DummyTestRunner
 * Working directory: $MODULE_WORKING_DIR$
 * Use classpath of module: dummytest.test 
 * Click apply
 * You can run this test by clicking run on the junit config created above (or)
 * Open the DummyTestRunner file and right click and choose  Run 'DummyTestRunner'
