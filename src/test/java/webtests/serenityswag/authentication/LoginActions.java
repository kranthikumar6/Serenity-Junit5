package webtests.serenityswag.authentication;

import net.serenitybdd.annotations.Step;
import net.serenitybdd.core.steps.UIInteractionSteps;
import org.openqa.selenium.By;

public class LoginActions extends UIInteractionSteps {

    @Step("Log in as {0}")
    public void as(User user) {
        openUrl("https://www.saucedemo.com/");

        // Login as a standard user
        find(By.name("user-name")).sendKeys(user.getUsername());
        find(By.name("password")).sendKeys(user.getPassword());
        find(By.name("login-button")).click();
    }
}
