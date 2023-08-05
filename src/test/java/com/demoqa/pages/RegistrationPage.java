package com.demoqa.pages;

import com.codeborne.selenide.SelenideElement;
import com.demoqa.pages.components.CalendarComponent;
import com.demoqa.pages.components.DropDownComponent;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class RegistrationPage {

    CalendarComponent calendar = new CalendarComponent();
    DropDownComponent dropdown = new DropDownComponent();

    SelenideElement
            firstNameInput = $("#firstName"),
            lastNameInput = $("#lastName"),
            userEmailInput = $("#userEmail"),
            genderWrapper = $("#genterWrapper"),
            userNumberInput = $("#userNumber"),
            birthDateInput = $("#dateOfBirthInput"),
            subjectsInput = $("#subjectsInput"),
            subjectsWrapper = $("#subjectsWrapper"),
            hobbiesWrapper = $("#hobbiesWrapper"),
            pictureUploader = $("#uploadPicture"),
            addressInput = $("#currentAddress"),
    stateDropdown = $("#stateCity-wrapper #state"),
    cityDropdown = $("#stateCity-wrapper #city"),
    submitButton =$("#submit");


    public RegistrationPage openPage() {
        open("/automation-practice-form");
        executeJavaScript("$('#fixedban').remove()");
        executeJavaScript("$('footer').remove()");

        return this;
    }


    public RegistrationPage setFirstName(String value) {
        firstNameInput.setValue(value);

        return this;
    }

    public RegistrationPage setLastName(String value) {
        lastNameInput.setValue(value);

        return this;
    }

    public RegistrationPage setUserEmail(String value) {
        userEmailInput.setValue(value);

        return this;
    }

    public RegistrationPage setGender(String value) {
        genderWrapper.$(byText(value)).click();

        return this;
    }

    public RegistrationPage setUserNumber(String value) {
        userNumberInput.setValue(value);

        return this;
    }

    public RegistrationPage setBirthDate(String day, String month, String year) {

        birthDateInput.click();
        calendar.setDate(day, month, year);

        return this;
    }

    public RegistrationPage setSubject(String value) {

        subjectsInput.setValue(value.substring(0, 1));
        subjectsWrapper.$(byText(value)).click();

        return this;
    }

    public RegistrationPage setHobbie(String value) {

        hobbiesWrapper.$(byText(value)).click();

        return this;
    }

    public RegistrationPage uploadPicture(String fileName) {

        pictureUploader.uploadFromClasspath(fileName);

        return this;
    }

    public RegistrationPage setAddress(String value) {

        addressInput.setValue(value);

        return this;
    }

    public RegistrationPage setState(String value) {

        dropdown.setValue(stateDropdown,value);

        return this;
    }

    public RegistrationPage setCity(String value) {

        dropdown.setValue(cityDropdown, value);

        return this;
    }

    public RegistrationPage submit() {

        submitButton.click();

        return this;
    }

//    public RegistrationPage checkResult(String value) {
//        $(".table-responsive").$(byText("Student Name")).parent().shouldHave(text(value));
//
//        return this;
//    }

}
