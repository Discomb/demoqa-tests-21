package com.demoqa.tests;

import com.demoqa.pages.RegistrationPage;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

public class RegistrationWithPageObjectsFormTests extends TestBase {

    RegistrationPage registrationPage = new RegistrationPage();

    @Test
    void fillFormTest() {

        registrationPage.openPage()
                .setFirstName("TestName")
                .setLastName("TestSurname")
                .setUserEmail("testmail@randommail.com")
                .setGender("Male")
                .setUserNumber("9991234545")
                .setBirthDate("25", "April", "1985")
                .setSubject("Maths")
                .setSubject("Economics")
                .setHobbie("Sports")
                .setHobbie("Music")
                .uploadPicture("coala.jpg")
                .setAddress("Test Country\nTest City\nAddress line 1\nAddress line2")
                .setState("Uttar Pradesh")
                .setCity("Merrut")
                .submit();

        $(".table-responsive").$(byText("Student Name")).parent().shouldHave(text("TestName TestSurname"));
        $(".table-responsive").$(byText("Student Email")).parent().shouldHave(text("testmail@randommail.com"));
        $(".table-responsive").$(byText("Gender")).parent().shouldHave(text("Male"));
        $(".table-responsive").$(byText("Mobile")).parent().shouldHave(text("9991234545"));
        $(".table-responsive").$(byText("Date of Birth")).parent().shouldHave(text("25 April,1985"));
        $(".table-responsive").$(byText("Subjects")).parent().shouldHave(text("Maths, Economics"));
        $(".table-responsive").$(byText("Hobbies")).parent().shouldHave(text("Sports, Music"));
        $(".table-responsive").$(byText("Picture")).parent().shouldHave(text("coala.jpg"));
        $(".table-responsive").$(byText("Address")).parent().shouldHave(text("Test Country Test City Address line 1 Address line2"));
        $(".table-responsive").$(byText("State and City")).parent().shouldHave(text("Uttar Pradesh Merrut"));
    }
}