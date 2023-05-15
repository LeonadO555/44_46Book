package ui.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class PageBase {
    public WebDriver driver;


    public PageBase(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void click(WebElement element) {
        element.click();
    }

    public void fillField(WebElement field, String value) {
        click(field);
        field.clear();
        field.sendKeys(value);
    }
}
