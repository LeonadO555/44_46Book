package e2e;

import api.RegistrationApi;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;
import ui.TestBase;
import ui.pages.LoginPage;
import ui.pages.ProfilePage;
import ui.pages.SelectPage;

public class RegistrationNewUserTest extends TestBase {
    RegistrationApi registrationApi;
    Response response;
    LoginPage loginPage;
    ProfilePage profilePage;
    SelectPage selectPage;

    @Test
    public void registerNewUserViaApiAndLoginViaUITest() {
//        LinkedHashMap<String, String> hashMapString = new LinkedHashMap<>();
//        hashMapString.put("1016", "Pound");
//        hashMapString.put("1018", "Dollar");
//        selectPage = new SelectPage(app.driver);
//        for (Map.Entry<String, String> oneObject : hashMapString.entrySet()) {
//            String name = oneObject.getKey();
//            String expectedText = oneObject.getValue();
//            selectPage.selectValueDropdown(name);
//            String actualText = app.driver.findElement(By.xpath("")).getText();
//            Assert.assertEquals(actualText, expectedText, actualText + "is not equal" + expectedText);
//        }
//
//        LinkedHashMap<String, Integer> hashMapInteger = new LinkedHashMap<>();
//        hashMapInteger.put("222", 111);

        String password = "yA*UeeuA2pU3";
        registrationApi = new RegistrationApi();
        response = registrationApi.registerUser(201, password);
        String userName = response.jsonPath().getString("username");

        loginPage = new LoginPage(app.driver);
        loginPage.waitForLoading();
        loginPage.fillLoginForm(userName, password);
        loginPage.clickLoginButton();

        profilePage = new ProfilePage(app.driver);
        profilePage.waitForLoading();
        profilePage.scrollToTableNextButton();
        profilePage.checkUsername(userName);
    }

    @Test
    public void newUserNotRegisterViaApiAndLoginViaUITest() {
        String invalidPassword = "123123";
        registrationApi = new RegistrationApi();
        response = registrationApi.registerUser(400, invalidPassword);
        String errMessage = response.jsonPath().getString("message");
        String userName = registrationApi.randomDataBodyForRegisterUser(invalidPassword).getUserName();
        String expectedErrorMessage = "Passwords must have at least one non alphanumeric character, one digit ('0'-'9'), one uppercase ('A'-'Z'), one lowercase ('a'-'z'), one special character and Password must be eight characters or longer.";
        Assert.assertEquals(errMessage, expectedErrorMessage, "Error message is not correct");

        loginPage = new LoginPage(app.driver);
        loginPage.waitForLoading();
        loginPage.fillLoginForm(userName, invalidPassword);
        loginPage.clickLoginButton();
        loginPage.waitForLoading();
    }
}
