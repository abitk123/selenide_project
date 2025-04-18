package selenide.components;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Allure;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.$;

public class NavBarComponent {

    private final SelenideElement CART = $(By.xpath("//*[text()='Cart']"));
    private final SelenideElement LOGIN = $("#login2");
    private final SelenideElement LOGOUT = $(By.xpath("//*[text()='Log out']"));
    private final SelenideElement SIGNUP = $("#signin2");
    private final SelenideElement USERNAME_LOGGED = $("#nameofuser");

    public NavBarComponent goTo(SelenideElement element) {
        Allure.step("Переход к " + element.name(), () -> {
            element.shouldBe(visible, enabled).click();
        });

        return this;
    }


    public SelenideElement getCart() {
        return CART;
    }

    public SelenideElement getLogin() {
        return LOGIN;
    }

    public SelenideElement getSignUp() {
        return SIGNUP;
    }

    public SelenideElement logout() {
        return LOGOUT;
    }

    public SelenideElement usernameAfterLogin() {
        return USERNAME_LOGGED;
    }

    public void shouldShowWelcome(String name) {
        Allure.step("Поверяем наличие имени юзера на главной странице после логина", () -> {
            USERNAME_LOGGED.shouldBe(visible).shouldHave(text(name));
        });
    }
}
