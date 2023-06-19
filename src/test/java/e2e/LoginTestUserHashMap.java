package e2e;

import org.testng.annotations.Test;
import ui.TestBase;
import ui.pages.LoginPage;
import ui.pages.ProfilePage;

import java.util.LinkedHashMap;
import java.util.Map;

public class LoginTestUserHashMap extends TestBase {

    LoginPage loginPage;
    ProfilePage profilePage;

    @Test
    public void loginTestUserHashMap() {
        LinkedHashMap<String, String> credentials = new LinkedHashMap<>();
        credentials.put("polo3636", "Popmil1pop@");
        credentials.put("mariva", "8389!Mariva");
        credentials.put("mvorontsova", "Pn!jE37Na$Ft*uX");

        for (Map.Entry<String, String> credential : credentials.entrySet()) {
            String userName = credential.getKey();
            String password = credential.getValue();

            loginPage = new LoginPage(app.driver);
            loginPage.waitForLoading();
            loginPage.fillLoginForm(userName, password);
            loginPage.clickLoginButton();

            profilePage = new ProfilePage(app.driver);
            profilePage.waitForLoading();
            profilePage.scrollToTableNextButton();
            profilePage.checkUsername(userName);
            profilePage.logout();
        }
    }
}