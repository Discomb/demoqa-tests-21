package com.demoqa.tests;

import com.demoqa.pages.RegistrationPage;
import org.junit.jupiter.api.Test;

import static com.demoqa.tests.TestData.*;

public class RegistrationWithRandomDataFormTests extends TestBase {

    RegistrationPage registrationPage = new RegistrationPage();


    @Test
    void fillFormTest() {

        registrationPage.openPage()
                .setFirstName(firstName)
                .setLastName(lastName)
                .setUserEmail(userEmail)
                .setGender(userGender)
                .setUserNumber(userPhoneNumber)
                .setBirthDate(userBirthDate)
                .setSubject(subject1)
                .setSubject(subject2)
                .setHobbie(hobbie1)
                .setHobbie(hobbie2)
                .uploadPicture(userPicture)
                .setAddress(userAddress)
                .setState(userState)
                .setCity(userCity)
                .submit()

                .checkResults(new String[][]{
                        {"Student Name", firstName + " " + lastName},
                        {"Student Email", userEmail},
                        {"Gender", userGender},
                        {"Mobile", userPhoneNumber},
                        {"Date of Birth", userBirthDate[0] + " " + userBirthDate[1] + "," + userBirthDate[2]},
                        {"Subjects", subject1 + ", " + subject2},
                        {"Hobbies", hobbie1 + ", " + hobbie2},
                        {"Picture", userPicture},
                        {"Address", userAddress},
                        {"State and City", userState + " " + userCity}
                });
    }
}
