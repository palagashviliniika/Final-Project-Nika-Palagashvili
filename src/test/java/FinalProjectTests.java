import Pages.Dasveneba;
import Pages.HomePage;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.testng.SoftAsserts;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Configuration.baseUrl;

@Listeners({SoftAsserts.class})
public class FinalProjectTests {
    private HomePage homePage = new HomePage();
    private Dasveneba dasveneba = new Dasveneba();
    public FinalProjectTests(){
        Configuration.timeout=5000;
        Configuration.browser="chrome";
        Configuration.browserSize="1920x1080";
        baseUrl="https://www.swoop.ge/";
    }

    @Test(priority = 0)
    public void firstTask(){
        homePage.Open();
        homePage.OpenLoginModal();
        homePage.Login("automatization@gmail.com", "12345678");
        homePage.GetAuthInfo().should(appear);
        homePage.GetAuthInfo().shouldHave(exactText("მეილი ან პაროლი არასწორია, თუ დაგავიწყდათ პაროლი,გთხოვთ ისარგებლოთ პაროლის აღდგენის ფუნქციით!"));
        homePage.GetPasswordField().text().isEmpty();
    }

    @Test(priority = 1)
    public void secondTask(){
        homePage.Open();
        homePage.OpenLoginModal();
        homePage.SelectJuridialRegister();
        homePage.GetWarningText().should(appear);
        homePage.GetSubscriptionCheckbox().shouldBe(checked);
    }

    @Test(dependsOnMethods = {"secondTask"}, priority = 2)
    public void thirdTask(){
        homePage.Open();
        homePage.OpenLoginModal();
        homePage.SelectJuridialRegister();
        homePage.GetLegalFormDropdown().selectOption("სააქციო საზოგადოება");
        homePage.Register(
                "company",
                "205205205205",
                "Tbilsi",
                "0138",
                "",
                "12341234",
                "12341234",
                "Nika Palagashvili",
                "01234567891",
                "555555555");
        homePage.GetRegistrationMessage().shouldHave(exactText("რეგისტრაციის დროს დაფიქსირდა შეცდომა!"));
    }

    @Test(priority = 3)
    public void fourthTask(){
        dasveneba.OpenDasveneba();
        dasveneba.FillPriceFilter("170", "180");
        dasveneba.Search();
        sleep(5000);
        System.out.println($$(".discounted-prices "));
//        sleep(5000);
    }
}
