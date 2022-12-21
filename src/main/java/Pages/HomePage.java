package Pages;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.$;

public class HomePage {
    private SelenideElement loginButton = $(".swoop-login").$(withText("შესვლა")),
    email = $(byName("Email")),
    password = $(byName("password")),
    authButton = $("#AuthBtn"),
    authInfo = $("#authInfo"),
    registerModal = $(".register"),
    juridial = $("#ui-id-2"),
    warningText = $("#register-content-2 h4"),
    subscriptionCheckbox = $("#IsLegalSubscribedNewsletter"),
    legalFormDropdown = $("#lLegalForm"),
    mandatoryCompanyName = $("#lName"),
    mandatoryTaxCode = $("#lTaxCode"),
    mandatoryCity = $("#lCity"),
    mandatoryPostalCode = $("#lPostalCode"),
    mandatoryPersonEmail = $("#lContactPersonEmail"),
    mandatoryPersonPassword = $("#lContactPersonPassword"),
    mandatoryPersonConfirmPassword = $("#lContactPersonConfirmPassword"),
    mandatoryPersonName = $("#lContactPersonName"),
    mandatoryPersonPersonalID = $("#lContactPersonPersonalID"),
    mandatoryPersonPhone = $("#lContactPersonPhone"),
    legalTerms = $("#IsLegalAgreedTerms"),
    registerButton = $("a[onclick='SubmitLegalForm()']"),
    registrationMessage = $("#legalInfoMassage");

    public void OpenLoginModal() {
        loginButton.click();
    }

    public void Open() {
        Selenide.open("");
    }

    public void Login(String emailValue, String passwordValue){
        email.setValue(emailValue);
        password.setValue(passwordValue);
        authButton.click();
    }

    public SelenideElement GetAuthInfo() {
        return authInfo;
    }

    public SelenideElement GetPasswordField() {
        return password;
    }

    public void SelectJuridialRegister() {
        registerModal.click();
        juridial.click();
    }

    public SelenideElement GetWarningText() {
        return warningText;
    }

    public SelenideElement GetSubscriptionCheckbox() {
        return subscriptionCheckbox;
    }

    public SelenideElement GetLegalFormDropdown() {
        return legalFormDropdown;
    }

    public void Register(
            String companyName,
            String taxCode,
            String city,
            String postalCode,
            String email,
            String password,
            String confirmPassword,
            String personName,
            String personalID,
            String phone) {
        mandatoryCompanyName.setValue(companyName);
        mandatoryTaxCode.setValue(taxCode);
        mandatoryCity.setValue(city);
        mandatoryPostalCode.setValue(postalCode);
        mandatoryPersonEmail.setValue(email);
        mandatoryPersonPassword.setValue(password);
        mandatoryPersonConfirmPassword.setValue(confirmPassword);
        mandatoryPersonName.setValue(personName);
        mandatoryPersonPersonalID.setValue(personalID);
        mandatoryPersonPhone.setValue(phone);
        legalTerms.click();
        registerButton.click();
    }

    public SelenideElement GetRegistrationMessage() {
        return registrationMessage;
    }
}
