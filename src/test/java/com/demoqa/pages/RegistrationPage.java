package com.demoqa.pages;

import com.codeborne.selenide.SelenideElement;
import com.demoqa.pages.components.CalendarComponent;
import com.demoqa.pages.components.DropDownComponent;
import com.demoqa.pages.components.ResultTableComponent;
import com.demoqa.tests.TestData;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static com.demoqa.pages.components.ResultTableComponent.*;

public class RegistrationPage {

    CalendarComponent calendar = new CalendarComponent();
    DropDownComponent dropdown = new DropDownComponent();

    ResultTableComponent resultTable = new ResultTableComponent();

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
            submitButton = $("#submit");

    String
            stateDropdown = "#state",
            cityDropdown = "#city";

    private void hideBanners() {
        executeJavaScript("$('#fixedban').remove()");
        executeJavaScript("$('footer').remove()");
    }

    public RegistrationPage openPage() {
        open("/automation-practice-form");
        hideBanners();

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

    public RegistrationPage setBirthDate(String[] birthDate) {

        birthDateInput.click();
        calendar.setDate(birthDate[0], birthDate[1], birthDate[2]);

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

        dropdown.setValue(stateDropdown, value);

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

    public void checkResults(String[][] values) {

        for (String[] valuePair : values
        ) {
            resultTable.checkResult(valuePair[0], valuePair[1]);
        }

    }

    public void checkResults(TestData testData) {

            resultTable
                    .checkResult(nameField, testData.firstName + " " + testData.lastName)
                    .checkResult(emailField, testData.userEmail)
                    .checkResult(genderField, testData.userGender)
                    .checkResult(birthdayField, testData.userBirthDate[0] + " " + testData.userBirthDate[1] + "," + testData.userBirthDate[2])
                    .checkResult(subjectsField, testData.subject1 + ", " + testData.subject2)
                    .checkResult(hobbiesField, testData.hobbie1 + ", " + testData.hobbie2)
                    .checkResult(picturefield, testData.userPicture)
                    .checkResult(addressField, testData.userAddress)
                    .checkResult(stateAndCityField, testData.userState + " " + testData.userCity);

    }

}
