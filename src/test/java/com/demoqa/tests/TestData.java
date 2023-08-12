package com.demoqa.tests;

import static com.demoqa.utils.RandomUtils.*;

public class TestData {

    public static String
            firstName = generateName(),
            lastName = generateLastName(),
            userEmail = generateEmail(),
            userGender = rangomGender(),
            userPhoneNumber = generatePhoneNumber(),
            subject1,
            subject2,
            hobbie1,
            hobbie2,
            userPicture,
            userAddress,
            userState,
            userCity;

    public static String[]
            userBirthDate = generateBirthdate();


}
