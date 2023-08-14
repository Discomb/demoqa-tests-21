package com.demoqa.tests;

import com.demoqa.pages.RegistrationPage;
import org.junit.jupiter.api.Test;

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
                .setBirthDate("07", "September", "2023")
                .setSubject("Maths")
                .setSubject("Economics")
                .setHobbie("Sports")
                .setHobbie("Music")
                .uploadPicture("coala.jpg")
                .setAddress("Test Country\nTest City\nAddress line 1\nAddress line2")
                .setState("Uttar Pradesh")
                .setCity("Merrut")
                .submit()

                .checkResults(new String[][]{
                        {"Student Name", "TestName TestSurname"},
                        {"Student Email", "testmail@randommail.com"},
                        {"Gender", "Male"},
                        {"Mobile", "9991234545"},
                        {"Date of Birth", "07 September,2023"},
                        {"Subjects", "Maths, Economics"},
                        {"Hobbies", "Sports, Music"},
                        {"Picture", "coala.jpg"},
                        {"Address", "Test Country Test City Address line 1 Address line2"},
                        {"State and City", "Uttar Pradesh Merrut"}
                });
    }

}
