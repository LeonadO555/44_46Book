package ui.utils;

import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import org.testng.Assert;
import ui.TestBase;
import ui.pages.SelectPage;

import java.util.LinkedHashMap;
import java.util.Map;


public class HashMap extends TestBase {

    SelectPage selectPage;
    Faker faker = new Faker();

    // example
    public void hashMap() {


        LinkedHashMap<String, String> hashMapString = new LinkedHashMap<>();
        hashMapString.put("1016", faker.name().fullName());
        hashMapString.put("1018", "Dollar");

        for (Map.Entry<String, String> oneObject : hashMapString.entrySet()) {
            String name = oneObject.getKey();
            String expectedText = oneObject.getValue();
            System.out.println(name);
            System.out.println(expectedText);
            selectPage.selectValueDropdown(name);
            String actualText = app.driver.findElement(By.xpath("")).getText();
            Assert.assertEquals(actualText, expectedText, actualText + " is not equal" + expectedText);
        }

    }

}


// Пример HashMap
//        LinkedHashMap<String, String> newContactObject = new LinkedHashMap<>();
//        newContactObject.put("myName", expectedResponse.jsonPath().getString("firstName"));
//        newContactObject.put("myLastName", expectedResponse.jsonPath().getString("lastName"));
//        newContactObject.put("myDescription", expectedResponse.jsonPath().getString("description"));


//        LinkedHashMap<String, String> hashMapString = new LinkedHashMap<>();
//        hashMapString.put("1016", faker.name().fullName());
//        hashMapString.put("1018", "Dollar");
//        selectPage = new SelectPage(app.driver);
//        for (Map.Entry<String, String> oneObject : hashMapString.entrySet()) {
//            String name = oneObject.getKey();
//            String expectedText = oneObject.getValue();
//            System.out.println(name);
//            System.out.println(expectedText);
//            selectPage.selectValueDropdown(name);
//            String actualText = app.driver.findElement(By.xpath("")).getText();
//            Assert.assertEquals(actualText, expectedText, actualText + " is not equal" + expectedText);
//       }


