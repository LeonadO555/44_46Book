package ui.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import ui.wait.Wait;

public class FramePages extends PageBase {

    Wait wait;

    public FramePages(WebDriver driver) {
        super(driver);
    }

    @FindBy(className = "ag-popup__frame__layout__iframe")
    WebElement iframeForm;

    @FindBy(xpath = "//*[@id=\"mailbox\"]/div[1]/button")
    WebElement loginButton;

    @FindBy(name = "username")
    WebElement usernameInput;

    @FindBy(className = "submit-button-wrap")
    WebElement nextButton;

    @FindBy(name = "password")
    WebElement passwordInput;


    public void login(String login, String password) {
        driver.get("https://mail.ru");
        wait = new Wait(driver);
        loginButton.click();
        driver.switchTo().frame(iframeForm);
        usernameInput.sendKeys(login);
        nextButton.click();
        wait.forVisibility(passwordInput);
        passwordInput.sendKeys(password);
        nextButton.click();
    }
}




/*
* public void login(String login, String password){
        driver.get("https://mail.ru");
        wait = new Wait(driver);
        loginButton.click();
        driver.switchTo().frame(iframeForm);
        usernameInput.sendKeys(login);
        nextButton.click();
        wait.forVisibility(passwordInput);
        passwordInput.sendKeys(password);
        nextButton.click();
    }
@Test
    public void checkLogin() throws InterruptedException {
        framePage = new ui.pages.FramePages(app.driver);
        framePage.login("selenium.introduction@mail.ru", "qwerty@2020");
        Thread.sleep(10000);

    }
public class ui.pages.FramePages extends PageBase {
        Wait wait;

    public ui.pages.FramePages(WebDriver driver) {
            super(driver);
        }


    @FindBy(className = "ag-popup__frame__layout__iframe")
    WebElement iframeForm;

    @FindBy(xpath = "//*[@id=\"mailbox\"]/div[1]/button")
    WebElement loginButton;

    @FindBy(name = "username")
    WebElement usernameInput;

    @FindBy(className = "submit-button-wrap")
    WebElement nextButton;

    @FindBy(name = "password")
    WebElement passwordInput;


    public void login(String login, String password){
        driver.get("https://mail.ru");
        wait = new Wait(driver);
        loginButton.click();
        driver.switchTo().frame(iframeForm);
        usernameInput.sendKeys(login);
        nextButton.click();
        wait.forVisibility(passwordInput);
        passwordInput.sendKeys(password);
        nextButton.click();
    }
}
* */