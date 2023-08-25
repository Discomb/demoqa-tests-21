package com.demoqa.tests;

import com.demoqa.pages.RegistrationPage;
import io.qameta.allure.Description;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static io.qameta.allure.Allure.step;

public class RegistrationRemoteTests extends RemoteTestBase {

    RegistrationPage registrationPage = new RegistrationPage();
    TestData testData = new TestData();

    @Test()
    @Tag("remote")
    @DisplayName("Проверка заполнения регистрационной формы")
    @Description("Проверка заполнения регистрационной формы")
    void fillFormTest() {
        step("Открываем регистрационную форму", () -> {
            registrationPage.openPage();
        });
        step("Заполняем регистрационную форму", () -> {
            registrationPage
                    .setFirstName(testData.firstName)
                    .setLastName(testData.lastName)
                    .setUserEmail(testData.userEmail)
                    .setGender(testData.userGender)
                    .setUserNumber(testData.userPhoneNumber)
                    .setBirthDate(testData.userBirthDate)
                    .setSubject(testData.subject1)
                    .setSubject(testData.subject2)
                    .setHobbie(testData.hobbie1)
                    .setHobbie(testData.hobbie2)
                    .uploadPicture(testData.userPicture)
                    .setAddress(testData.userAddress)
                    .setState(testData.userState)
                    .setCity(testData.userCity)
                    .submit();
        });
        step("Проверяем результат", () -> {
            registrationPage.checkResults(testData);
        });
    }
}
