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
        //oneObject     manyObjects
        for (Map.Entry<String, String> credential : credentials.entrySet()) {
            String userName = credential.getKey();  //brkpt - проверить вэлью в наших пер-х **(до - после)
            String password = credential.getValue(); //brkpt

            loginPage = new LoginPage(app.driver);
            loginPage.waitForLoading(); //Нужно теперь постоянно писать этот лоадинг. Мы же должны видеть основыне эл страницы
            loginPage.fillLoginForm(userName, password); //brkpt
            loginPage.clickLoginButton(); //brkpt

            profilePage = new ProfilePage(app.driver);
            profilePage.waitForLoading();   // Проверяем - если дождется, то все прошло, если нет, то свалился
            profilePage.checkUsername(userName);
            profilePage.logOut();
        }


    }
}
