package atmecsTraining.logInTaskReUsables;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class ReusableVerifications {
    public WebDriver driver;

    /**
     * Constructor Description: Used to initialize WebDriver variable
     *
     * @param driver WebDriver
     */

    public ReusableVerifications(WebDriver driver) {
        this.driver = driver;
    }

    /**
     * Method Description: Used to verify the actual page title with the expected page title
     *
     * @param expectedTitle Expected page title
     */

    public void verifyPageTitle(String expectedTitle) {
        ReusableActions reusableActions = new ReusableActions(driver);
        String actualTitle = reusableActions.getPageTitle();
        Assert.assertEquals(actualTitle,expectedTitle,"Landing page title mismatch");
    }

    /**
     * Method Description: Used to verify whether the given user name is present in the profile user name field or not
     *
     * @param profileUserNameElement WebElement of the profile user name
     * @param userName               Text entered in the User Name field
     */

    public void verifyLoginResult(WebElement profileUserNameElement, String userName) {
        ReusableActions reusableActions = new ReusableActions(driver);
        String actualText = reusableActions.getTextFromElement(profileUserNameElement);
        Assert.assertEquals(actualText,userName,"Bug in displaying the username");
    }
}
