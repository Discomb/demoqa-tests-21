package com.demoqa.registrationFormTests;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.*;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Configuration.baseUrl;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class RegistrationFormTests {

    @BeforeAll
    static void beforeAll() {
        baseUrl = "https://demoqa.com";
        Configuration.browserSize = "1920x1080";
        Configuration.pageLoadTimeout = Long.parseLong("100000");
        Configuration.holdBrowserOpen = true;
    }

    @Test
    void fillFormTest(){
        open("/automation-practice-form");
        $("#firstName").setValue("Nick");
        $("#lastName").setValue("Surname");
        $("#userEmail").setValue("n.surname@randommail.com");

        $("#userNumber").setValue("9991234545");
        $("#dateOfBirthInput").setValue("28 Feb 1985");
        $("#subjectsContainer").setValue("Math");
        $("#subjectsContainer").submit();



    }
}