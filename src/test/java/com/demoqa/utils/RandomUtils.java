package com.demoqa.utils;

import com.github.javafaker.Faker;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.Random;

public class RandomUtils {

    public static void main(String[] args) {
        generateBirthdate();
    }

    static Faker faker = new Faker(Locale.ENGLISH);
    static Random random = new Random();

    public static int getRandomInt(int min, int max) {
        return random.nextInt(((max - min) + 1) + min);
    }

    public static String generateName() {

        return faker.name().firstName();
    }

    public static String generateLastName() {

        return faker.name().lastName();
    }

    public static String generateEmail() {

        return faker.internet().emailAddress();
    }

    public static String rangomGender() {

        String[] genders = {"Male", "Female", "Other"};

        return genders[getRandomInt(0, genders.length - 1)];

    }

    public static String generatePhoneNumber() {

        return faker.phoneNumber().subscriberNumber(10);
    }

    public static String[] generateBirthdate() {

        Date bd = faker.date().birthday();
        String[] birthdate = new String[3];
        Calendar calendar = Calendar.getInstance();

        calendar.setTime(bd);

        birthdate[0] = String.valueOf(calendar.get(Calendar.DAY_OF_MONTH));
        birthdate[1] = new SimpleDateFormat("MMMM", Locale.ENGLISH).format(bd.getTime());
        birthdate[2] = String.valueOf(calendar.get(Calendar.YEAR));

        return birthdate;
    }

    public static String randomSubject(String prev) {

        String[] subjects = {"Maths", "Accounting",
                "Arts", "Social Studies",
                "Biology", "Physics", "Chemistry",
                "Computer Science", "Commerce", "Economics",
                "Civics", "Hindi", "English", "History"};

        String subject = subjects[getRandomInt(0, subjects.length - 1)];

        if (prev.equals(subject)) {
            return randomSubject(prev);
        } else {
            return subject;
        }

    }

    public static String randomHobbie(String prev) {

        String[] hobbies = {"Sports", "Reading", "Music"};

        String hobby = hobbies[getRandomInt(0, hobbies.length - 1)];

        if (prev.equals(hobby)) {
            return randomHobbie(prev);
        } else {
            return hobby;
        }

    }

    public static String getRandomAddress() {

        return faker.address().fullAddress();

    }

    public static String randomState() {

        String[] states = {"NCR", "Uttar Pradesh",
                "Haryana", "Rajasthan"};

        return states[getRandomInt(0, states.length - 1)];

    }

    public static String randomCity(String state) {

        switch (state) {
            case "Uttar Pradesh" -> {
                String[] cities = {"Agra", "Lucknow",
                        "Merrut"};
                return cities[getRandomInt(0, cities.length - 1)];
            }
            case "NCR" -> {
                String[] cities = {"Delhi", "Gurgaon",
                        "Noida"};
                return cities[getRandomInt(0, cities.length - 1)];
            }
            case "Haryana" -> {
                String[] cities = {"Karnal", "Panipat"};
                return cities[getRandomInt(0, cities.length - 1)];
            }
            case "Rajasthan" -> {
                String[] cities = {"Jaipur", "Jaiselmer"};
                return cities[getRandomInt(0, cities.length - 1)];
            }
        }

        return null;
    }


}
