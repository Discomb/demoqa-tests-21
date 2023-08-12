package com.demoqa.utils;

import com.github.javafaker.Faker;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;

import static java.lang.String.format;

public class RandomUtils {

    public static void main(String[] args) {
        generateBirthdate();
    }

    static Faker faker = new Faker(Locale.ENGLISH);
    static Random random = new Random();

    public static int getRandomInt(int min, int max){
        return random.nextInt(((max - min) + 1) + min);
    }

    public static String generateName(){

        return faker.name().firstName();
    }

    public static String generateLastName(){

        return faker.name().lastName();
    }
    public static String generateEmail(){

        return faker.internet().emailAddress();
    }

    public static String rangomGender(){

        String[] genders = {"Male", "Female", "Other"};

        return genders[getRandomInt(0, 2)];

    }

    public static String generatePhoneNumber(){

        return faker.phoneNumber().subscriberNumber(10);
    }

    public static String[] generateBirthdate(){

        Date bd = faker.date().birthday();
        String[] birthdate = new String[3];
        Calendar calendar = Calendar.getInstance();

        calendar.setTime(bd);

        birthdate[0] = String.valueOf(calendar.get(Calendar.DAY_OF_MONTH));
        birthdate[1] = new SimpleDateFormat("MMMM", Locale.ENGLISH).format(bd.getTime());
        birthdate[2] = String.valueOf(calendar.get(Calendar.YEAR));

        return birthdate;
    }


}
