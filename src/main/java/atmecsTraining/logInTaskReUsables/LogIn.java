package atmecsTraining.logInTaskReUsables;

import org.openqa.selenium.WebDriver;

public class LogIn {
    public WebDriver driver;

    /**
     * Constructor Description: Used to initialize the WebDriver variable
     *
     * @param driver WebDriver
     */

    public LogIn(WebDriver driver) {
        this.driver = driver;
    }

    /**
     * Method Description: Used to perform login
     *
     * @param userNameLocator Locator of the UserName field
     * @param userNameText    Text to be entered in the UserName field
     * @param passWordLocator Locator of the Password field
     * @param passWordText    Text to be entered in the Password field
     * @param logInLocator    Locator of the Login button
     */

    public void performLogIn(String userNameLocator, String userNameText,
                             String passWordLocator, String passWordText,
                             String logInLocator) {
        ReusableActions reusableActions = new ReusableActions(driver);
        reusableActions.sendText(reusableActions.findElementById(userNameLocator), userNameText);
        reusableActions.sendText(reusableActions.findElementById(passWordLocator), passWordText);
        reusableActions.clickUsingJavaScriptExecutor(reusableActions.findElementById(logInLocator));
    }
}
