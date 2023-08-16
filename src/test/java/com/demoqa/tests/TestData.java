package com.demoqa.tests;

import com.demoqa.utils.RandomUtils;

public class TestData {

    RandomUtils randomUtils = new RandomUtils();

    public String
            firstName = randomUtils.generateName(),
            lastName = randomUtils.generateLastName(),
            userEmail = randomUtils.generateEmail(),
            userGender = randomUtils.randomGender(),
            userPhoneNumber = randomUtils.generatePhoneNumber(),
            subject1 = randomUtils.randomSubject("none"),
            subject2 = randomUtils.randomSubject(subject1),
            hobbie1 = randomUtils.randomHobbie("none"),
            hobbie2 = randomUtils.randomHobbie(hobbie1),
            userPicture = "coala.jpg",
            userAddress = randomUtils.getRandomAddress(),
            userState = randomUtils.randomState(),
            userCity = randomUtils.randomCity(userState);

    public String[]
            userBirthDate = randomUtils.generateBirthdate();


}
