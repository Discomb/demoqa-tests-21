package com.demoqa.registrationFormTests;

import com.codeborne.selenide.*;
import org.junit.jupiter.api.*;
import org.openqa.selenium.Keys;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Configuration.baseUrl;
import static com.codeborne.selenide.Selectors.byCssSelector;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class RegistrationFormTests {

    @BeforeAll
    static void beforeAll() {
        baseUrl = "https://demoqa.com";
        Configuration.browserSize = "1920x1080";
        Configuration.pageLoadStrategy = "eager";
    }

    @Test
    void fillFormTest(){
        open("/automation-practice-form");

        executeJavaScript("$('#fixedban').remove()");
        executeJavaScript("$('footer').remove()");

        $("#firstName").setValue("TestName");
        $("#lastName").setValue("TestSurname");
        $("#userEmail").setValue("testmail@randommail.com");
        $("#genterWrapper").$(byText("Male")).click();
        $("#userNumber").setValue("9991234545");
        $("#dateOfBirthInput").click();
        $(".react-datepicker__month-select").click();
        $(".react-datepicker__month-select").$(byText("April")).click();
        $(".react-datepicker__year-select").click();
        $(".react-datepicker__year-select").$(byText("1985")).click();
        $(".react-datepicker__month-container").$(byText("25")).click();
        $("#subjectsInput").setValue("Ma");
        $(".subjects-auto-complete__menu.css-26l3qy-menu").$(byText("Maths")).click();
        $("#hobbiesWrapper").$(byText("Sports")).click();
        $("#hobbiesWrapper").$(byText("Music")).click();
        $("#uploadPicture").uploadFromClasspath("coala.jpg");
        $("#currentAddress").setValue("Test Country\nTest City\nAddress line 1\nAddress line2");
        $("#stateCity-wrapper #state").click();
        $("#stateCity-wrapper #state").$(byText("Uttar Pradesh")).click();
        $("#stateCity-wrapper #city").click();
        $("#stateCity-wrapper #city").$(byText("Merrut")).click();
        $("#submit").click();

        $(".table-responsive").$(byText("Student Name")).parent().shouldHave(text("TestName TestSurname"));
        $(".table-responsive").$(byText("Student Email")).parent().shouldHave(text("testmail@randommail.com"));
        $(".table-responsive").$(byText("Gender")).parent().shouldHave(text("Male"));
        $(".table-responsive").$(byText("Mobile")).parent().shouldHave(text("9991234545"));
        $(".table-responsive").$(byText("Date of Birth")).parent().shouldHave(text("25 April,1985"));
        $(".table-responsive").$(byText("Subjects")).parent().shouldHave(text("Maths"));
        $(".table-responsive").$(byText("Hobbies")).parent().shouldHave(text("Sports, Music"));
        $(".table-responsive").$(byText("Picture")).parent().shouldHave(text("coala.jpg"));
        $(".table-responsive").$(byText("Address")).parent().shouldHave(text("Test Country Test City Address line 1 Address line2"));
        $(".table-responsive").$(byText("State and City")).parent().shouldHave(text("Uttar Pradesh Merrut"));
    }
}