package atmecsTraining.logInTask.testCases;

import atmecsTraining.logInTaskReUsables.LogIn;
import atmecsTraining.logInTaskReUsables.ReusableActions;
import atmecsTraining.logInTaskReUsables.ReusableVerifications;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.TimeoutException;
import org.testng.annotations.Test;

public class TestLogIn extends BrowserActions {

    String url = getTestData("url");
    String expectedLandingPageTitle = getTestData("expectedPageTitle");
    String userNameLocator = getLocators("userNameLocator");
    String passWordLocator = getLocators("passwordLocator");
    String logInLocator = getLocators("logInLocator");
    String userNameText = getTestData("userNameText");
    String passWordText = getTestData("passwordText");
    String profileUserNameLocator = getLocators("profileUserNameLocator");
    String failedTextLocator = getLocators("logInFailedTextLocator");

    /**
     * Method Description: Used to get the locators from the file using its key
     *
     * @param key key of the locator
     * @return Locator as a String
     */

    public String getLocators(String key) {
        return locatorsFile.getProperty(key);
    }

    /**
     * Method Description: Used to get the test data from the file using its key
     *
     * @param key key of the test data
     * @return Test data as a String
     */

    public String getTestData(String key) {
        return testDataFile.getProperty(key);
    }

    /**
     * TestCase Description: Perform login and verify whether the login is successful or not
     */

    @Test
    public void testLogIn() {
        ReusableActions reusableActions = new ReusableActions(driver);
        ReusableVerifications reusableVerifications = new ReusableVerifications(driver);
        reusableActions.openUrl(url);
        reusableVerifications.verifyPageTitle(expectedLandingPageTitle);
        LogIn logInObject = new LogIn(driver);
        logInObject.performLogIn(userNameLocator, userNameText, passWordLocator, passWordText, logInLocator);
        try {
            reusableVerifications.verifyLoginResult
                    (reusableActions.waitForTheElementToBeVisibleUsingId
                            (1, profileUserNameLocator), userNameText);
            System.out.println("Login Successful");
        } catch (TimeoutException exception) {
            System.out.println("Login failed: " + reusableActions.getTextFromElement(reusableActions.findElementById(failedTextLocator)));
        } catch (NoSuchElementException exception) {
            System.out.println("Profile username text element not found.");
        }
    }
}
