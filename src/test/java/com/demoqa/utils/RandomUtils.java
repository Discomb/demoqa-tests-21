package com.demoqa.utils;

import com.github.javafaker.Faker;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class RandomUtils {

    Faker faker = new Faker(Locale.ENGLISH);

    public String generateName() {

        return faker.name().firstName();
    }

    public String generateLastName() {

        return faker.name().lastName();
    }

    public String generateEmail() {

        return faker.internet().emailAddress();
    }

    public String randomGender() {

        String[] genders = {"Male", "Female", "Other"};

        return faker.options().option(genders);

    }

    public String generatePhoneNumber() {

        return faker.phoneNumber().subscriberNumber(10);
    }

    public String[] generateBirthdate() {

        Date bd = faker.date().birthday();
        String[] birthdate = new String[3];

        birthdate[0] = new SimpleDateFormat("dd").format(bd.getTime());
        birthdate[1] = new SimpleDateFormat("MMMM", Locale.ENGLISH).format(bd.getTime());
        birthdate[2] = new SimpleDateFormat("yyyy").format(bd.getTime());

        return birthdate;
    }

    public String randomSubject(String prev) {

        String[] subjects = {"Maths", "Accounting",
                "Arts", "Social Studies",
                "Biology", "Physics", "Chemistry",
                "Computer Science", "Commerce", "Economics",
                "Civics", "Hindi", "English", "History"};

        String subject = faker.options().option(subjects);

        if (prev.equals(subject)) {
            return randomSubject(prev);
        } else {
            return subject;
        }

    }

    public String randomHobbie(String prev) {

        String[] hobbies = {"Sports", "Reading", "Music"};

        String hobby = faker.options().option(hobbies);

        if (prev.equals(hobby)) {
            return randomHobbie(prev);
        } else {
            return hobby;
        }

    }

    public String getRandomAddress() {

        return faker.address().fullAddress();

    }

    public String randomState() {

        String[] states = {"NCR", "Uttar Pradesh",
                "Haryana", "Rajasthan"};

        return faker.options().option(states);

    }

    public String randomCity(String state) {

        switch (state) {
            case "Uttar Pradesh" -> {
                String[] cities = {"Agra", "Lucknow",
                        "Merrut"};
                return faker.options().option(cities);
            }
            case "NCR" -> {
                String[] cities = {"Delhi", "Gurgaon",
                        "Noida"};
                return faker.options().option(cities);
            }
            case "Haryana" -> {
                String[] cities = {"Karnal", "Panipat"};
                return faker.options().option(cities);
            }
            case "Rajasthan" -> {
                String[] cities = {"Jaipur", "Jaiselmer"};
                return faker.options().option(cities);
            }
        }

        return null;
    }


}
