package com.demoqa.pages.components;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

public class ResultTableComponent {

    SelenideElement tableField = $(".table-responsive");

    public static String
            nameField =  "Student Name",
            emailField = "Student Email",
            genderField = "Gender",
            mobileNumberField = "Mobile",
            birthdayField = "Date of Birth",
            subjectsField = "Subjects",
            hobbiesField = "Hobbies",
            picturefield = "Picture",
            addressField = "Address",
            stateAndCityField = "State and City";

    public ResultTableComponent checkResult(String field, String value) {

        tableField.$(byText(field)).parent().shouldHave(text(value));

        return this;

    }


}
