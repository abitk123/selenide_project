package selenide.pages;

import com.codeborne.selenide.*;
import io.qameta.allure.*;
import org.openqa.selenium.By;
import selenide.LoadableComponent;
import selenide.components.Alerts;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.$;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class RegistrationPage extends LoadableComponent {
    private SelenideElement usernameField = $("input#sign-username");
    private SelenideElement passwordField = $("input#sign-password");
    private SelenideElement confirmButton = $(By.xpath("//*[@onclick='register()']"));
    private SelenideElement modalWindow = $("#signInModal .modal-content");
    private SelenideElement signupLabel = $("#signInModalLabel");

    public void waitUntilLoaded() {
        signupLabel.shouldBe(visible);
        usernameField.shouldBe(visible);
        passwordField.shouldBe(visible);
        confirmButton.shouldBe(visible);
    }

    public void registration(String login, String pass, Alerts alert) {
        waitUntilLoaded();
        Allure.step("Заполняем логин и пароль", () -> {
            usernameField.shouldBe(visible).setValue(login);
            passwordField.shouldBe(visible).setValue(pass);
        });

        Allure.step("Подтверждаем регистрацию", () -> {
            confirmButton.click();
        });

        Allure.step("Получаем алерт о регистрации", () -> {
            String dialog = Selenide.confirm();
            assertEquals(dialog, alert.getMessage());
        });

    }

    public SelenideElement getModal() {
        return modalWindow;
    }


}
