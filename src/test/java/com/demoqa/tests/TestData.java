package com.demoqa.tests;

import static com.demoqa.utils.RandomUtils.*;

public class TestData {

    public static String
            firstName = generateName(),
            lastName = generateLastName(),
            userEmail = generateEmail(),
            userGender = rangomGender(),
            userPhoneNumber = generatePhoneNumber(),
            subject1 = randomSubject("none"),
            subject2 = randomSubject(subject1),
            hobbie1 = randomHobbie("none"),
            hobbie2 = randomHobbie(hobbie1),
            userPicture = "coala.jpg",
            userAddress = getRandomAddress(),
            userState = randomState(),
            userCity = randomCity(userState);

    public static String[]
            userBirthDate = generateBirthdate();


}
