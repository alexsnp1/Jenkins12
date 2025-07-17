package tests;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import pages.RegistrationPage;

import static io.qameta.allure.Allure.step;
import static tests.TestData.*;

public class RegistrationWithTestDataTests extends TestBase {

    RegistrationPage registrationPage = new RegistrationPage();

    @Test
    @Tag("jenkins")
    void fillFormTest() {
        step("Open form", () -> {
        registrationPage
                .openPage()
                .removeBanner();
        });
        step("Fill form", () -> {
        registrationPage
                .setFirstName(firstName)
                .setLastName(lastName)
                .setEmail(userEmail)
                .setGender(userGender)
                .setUserNumber(userPhone)
                .setDateOfBirth(dayOfBirth, monthOfBirth, yearOfBirth)
                .setSubjectsInput(userSubjects)
                .setHobbiesWrapper(userHobbies)
                .setCurrentAddress(userAddress)
                .setState()
                .setStateCityWrapper(userState)
                .setCity()
                .setStateCityWrapper(userCity)
                .clickSubmitButton();
        });

        step("Check form", () -> {
        registrationPage.checkResults("Student Name", firstName + " " + lastName)
                .checkResults("Student Email", userEmail)
                .checkResults("Gender", userGender)
                .checkResults("Mobile", userPhone)
                .checkResults("Date of Birth", dayOfBirth + " " + monthOfBirth + "," + yearOfBirth)
                .checkResults("Subjects", userSubjects)
                .checkResults("Hobbies", userHobbies)
                .checkResults("Address", userAddress)
                .checkResults("State and City", userState + " " + userCity);
        });
    }

    @Test
    void minDataTest() {
        registrationPage.openPage()
                .setFirstName(firstName)
                .setLastName(lastName)
                .setEmail(userEmail)
                .setGender(userGender)
                .setUserNumber(userPhone)
                .clickSubmitButton();

        registrationPage.checkResults("Student Name", firstName + " " + lastName)
                .checkResults("Student Email", userEmail)
                .checkResults("Gender", userGender)
                .checkResults("Mobile", userPhone);
    }

    @Test
    void negativeDataTest() {
        registrationPage.openPage()
                .setFirstName(firstName)
                .setLastName(lastName)
                .setEmail("myemail")
                .setGender(userGender)
                .setUserNumber("my number")
                .clickSubmitButton();

        registrationPage.checkResults("Student Name", firstName + " " + lastName)
                .checkResults("Student Email", "myemail")
                .checkResults("Gender", userGender)
                .checkResults("Mobile", "my number");
    }
}

