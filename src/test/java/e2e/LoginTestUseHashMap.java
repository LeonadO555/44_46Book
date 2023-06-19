package e2e;

import org.testng.annotations.Test;
import ui.TestBase;
import ui.pages.LoginPage;
import ui.pages.ProfilePage;

import java.util.LinkedHashMap;
import java.util.Map;

public class LoginTestUseHashMap extends TestBase {

    LoginPage loginPage;
    ProfilePage profilePage;

    @Test
    public void loginTestUseHashMap() {
        LinkedHashMap<String, String> credentials = new LinkedHashMap<>();
        credentials.put("polo3636", "Popmil1pop@");
        credentials.put("mariva", "8389!Mariva");

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
