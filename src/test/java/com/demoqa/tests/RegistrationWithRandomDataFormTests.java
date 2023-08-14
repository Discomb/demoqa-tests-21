package com.demoqa.tests;

import com.demoqa.pages.RegistrationPage;
import org.junit.jupiter.api.Test;

public class RegistrationWithRandomDataFormTests extends TestBase {

    RegistrationPage registrationPage = new RegistrationPage();
    TestData testData = new TestData();


    @Test
    void fillFormTest() {

        registrationPage.openPage()
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
                .submit()

                .checkResults(testData);
    }
}
