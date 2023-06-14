package ui.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import ui.utils.ScrollUtils;
import ui.wait.Wait;

public class ProfilePage extends PageBase {
    Wait wait;

    public ProfilePage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "userName-value")
    WebElement username;

    @FindBy(xpath = "//*[contains(text(),'Next')]")
    WebElement nextTableButton;

    public void waitForLoading() {
        wait = new Wait(driver);
        wait.forVisibility(username);
    }

    public void checkUsername(String expectedUsername) {
        checkItemText(username, expectedUsername, "Username is not equal to expected");
    }

    public void scrollToTableNextButton() {
        ScrollUtils.scrollToElement(driver, nextTableButton);
    }
}
