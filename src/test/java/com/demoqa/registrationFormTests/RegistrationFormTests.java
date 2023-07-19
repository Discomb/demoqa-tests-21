package com.demoqa.registrationFormTests;

import com.codeborne.selenide.*;
import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;

import static com.codeborne.selenide.Configuration.baseUrl;
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
        $("#dateOfBirthInput").sendKeys(Keys.CONTROL + "a");
        $("#dateOfBirthInput").sendKeys("25 Apr 1985" + Keys.ESCAPE);
        $("#subjectsInput").setValue("Ma");
        $("#react-select-2-option-0").click();
        $("#hobbiesWrapper").$(byText("Sports")).click();
        $("#hobbiesWrapper").$(byText("Music")).click();
        $("#uploadPicture").uploadFile(new File("C:\\Users\\Николай\\Pictures\\IMG_20230224_123307.jpg"));
        $("#currentAddress").setValue("Test Country\nTest City\nAddress line 1\nAddress line2");
        $("#stateCity-wrapper #state").click();
        $("#stateCity-wrapper #state #react-select-3-option-1").click();
        $("#stateCity-wrapper #city").click();
        $("#stateCity-wrapper #city #react-select-4-option-2").click();
        $("#submit").click();

        $(".modal-content table > tbody > tr:nth-child(1) > td:nth-child(2)").shouldHave(Condition.text("TestName TestSurname"));
        $(".modal-content table > tbody > tr:nth-child(2) > td:nth-child(2)").shouldHave(Condition.text("testmail@randommail.com"));
        $(".modal-content table > tbody > tr:nth-child(3) > td:nth-child(2)").shouldHave(Condition.text("Male"));
        $(".modal-content table > tbody > tr:nth-child(4) > td:nth-child(2)").shouldHave(Condition.text("9991234545"));
        $(".modal-content table > tbody > tr:nth-child(5) > td:nth-child(2)").shouldHave(Condition.text("25 April,1985"));
        $(".modal-content table > tbody > tr:nth-child(6) > td:nth-child(2)").shouldHave(Condition.text("Maths"));
        $(".modal-content table > tbody > tr:nth-child(7) > td:nth-child(2)").shouldHave(Condition.text("Sports, Music"));
        $(".modal-content table > tbody > tr:nth-child(8) > td:nth-child(2)").shouldHave(Condition.text("IMG_20230224_123307.jpg"));
        $(".modal-content table > tbody > tr:nth-child(9) > td:nth-child(2)").shouldHave(Condition.text("Test Country Test City Address line 1 Address line2"));
        $(".modal-content table > tbody > tr:nth-child(10) > td:nth-child(2)").shouldHave(Condition.text("Uttar Pradesh Merrut"));
    }
}