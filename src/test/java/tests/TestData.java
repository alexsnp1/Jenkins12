package tests;

import com.github.javafaker.Faker;

import java.util.Locale;
import java.util.concurrent.ThreadLocalRandom;

public class TestData {


    public static Faker faker = new Faker(new Locale("en-US"));

    public static String firstName = faker.name().firstName(),
            lastName = faker.name().lastName(),
            userEmail = faker.internet().emailAddress(),
            userGender = faker.options().option("Male", "Female", "Other"),
            userAddress = faker.address().streetAddress(),
            userSubjects = faker.options().option("Eng", "Che", "Comm", "Eco", "Soc"),
            userHobbies = faker.options().option("Reading", "Sports", "Music"),
            monthOfBirth = faker.options().option("January", "February", "March", "April", "May", "June",
            "July", "August", "September", "October", "November", "December"),
            userState = faker.options().option("NCR", "Uttar Pradesh", "Haryana", "Rajasthan"),
            userPicture = faker.options().option("img.png", "img2.jpeg", "img3.jpg");


    public static String
            userPhone = getRandomPhone(),
            userCity = getRandomCity(),
            dayOfBirth = getRandomDay(),
            yearOfBirth = getRandomYear();


    public static int getRandomInt(int min, int max) {
        return ThreadLocalRandom.current().nextInt(min, max + 1);

    }

    public static String getRandomPhone() {
        return String.format("%s%s", getRandomInt(10000,99999), getRandomInt(10000,99999));
    }

    public static String getRandomItemFromArray(String[] array) {
        int index = getRandomInt(0, array.length - 1);

        return array[index];

    }
    public static String getRandomDay() {
            int day = ThreadLocalRandom.current().nextInt(1, 31);
            return day < 10 ? String.valueOf(day) : String.format("%02d", day);

    }
    public static String getRandomYear() {
        int year = ThreadLocalRandom.current().nextInt(1990, 2025);
        return String.valueOf(year);
        }

    public static String getRandomCity() {
        String[] cities = {};
        if (userState.equals("NCR")) {
            cities = new String[]{"Delhi", "Gurgaon", "Noida"};
        } else if (userState.equals("Uttar Pradesh")) {
            cities = new String[]{"Agra", "Lucknow", "Merrut"};
        } else if (userState.equals("Haryana")) {
            cities = new String[]{"Karnal", "Panipat"};
        } else if (userState.equals("Rajasthan")) {
            cities = new String[]{"Jaipur", "Jaiselmer"};
        }

        return getRandomItemFromArray(cities);
    }
}
